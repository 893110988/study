package wmm.javaframe.study.mvc.factory;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.io.SAXReader;

//依赖注入容器
public class BeanFactory {

    private Map<String,Object> beanMap=new HashMap<String,Object>();

    /**
     * 初始化xml文件 
     * */
    public void init(String xmlUrl){
        SAXReader  saxReader=new SAXReader();
        File file=new File(xmlUrl);
        try{
            saxReader.addHandler("/beans/bean",new BeanHandler());
            saxReader.read(file);
        }
        catch(DocumentException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 根据beanid来获取bean 
     * */
    public Object getBean(String beanId){
        Object obj=null;
        obj=beanMap.get(beanId);
        return obj;

    }

    private void setFieldValue(Object obj, Field field, String value) {
        String fieldType=field.getType().getSimpleName();
        try{
            if("int".equals(fieldType)){
                field.setInt(obj, new Integer(value));
            }else if("float".equals(fieldType)){
                field.setFloat(obj, new Float(value));
            }else{
                field.set(obj,value);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    private void setFieldValue(Object obj, Field field, Object bean) {
        try {
            field.set(obj, bean);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


/*************************以下是标签处理器***************************************/

    /**
     * 处理/beans/bean标签 
     * */
    class BeanHandler implements ElementHandler {

        private Object obj=null;

        public void onStart(ElementPath path) {

            Element beanElement=path.getCurrent();      //获取当前的元素  
            Attribute classAttribute=beanElement.attribute("class");  //获取class属性  

            Class<?> bean=null;

            try{
                //根据类名通过反射构造一个class  
                bean=Class.forName(classAttribute.getText());
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
            //获取bean中的所有的域  
            Field fields[]=bean.getDeclaredFields();
            Map<String,Field> fieldMap=new HashMap<String,Field>();

            //所有的域放在一个map中  
            for(Field field:fields){
                fieldMap.put(field.getName(), field);
            }

            try{
                obj=bean.newInstance(); //构造出一个bean实例对象  
            }
            catch(Exception e){
                e.printStackTrace();
            }

            //为property标签增加handler  
            path.addHandler("property", new PropertyHandler(fieldMap,obj));

        }




        public void onEnd(ElementPath path) {
            Element currentElement=path.getCurrent();
            Attribute idAttribute=currentElement.attribute("id");
            beanMap.put(idAttribute.getText(), obj);

            //去掉property处理器  
            path.removeHandler("property");

        }

    }


    /**
     * 处理property标签 
     * */
    class PropertyHandler implements ElementHandler {

        private Map<String,Field> fieldMap;
        private Object obj;

        public PropertyHandler(Map<String,Field> fieldMap,Object obj){
            this.fieldMap=fieldMap;
            this.obj=obj;

        }

        public void onEnd(ElementPath path) {
            path.removeHandler("value");
            path.removeHandler("ref");

        }

        public void onStart(ElementPath path) {
            Element propertyElement=path.getCurrent();
            Attribute nameAttribute=propertyElement.attribute("name");
            path.addHandler("value", new ValueHandler(fieldMap,obj,nameAttribute));
            path.addHandler("ref", new RefHandler(fieldMap,obj,nameAttribute));

        }

    }



    /**
     * 处理value标签 
     * */
    class ValueHandler implements ElementHandler{

        private Map<String,Field> fieldMap;
        private Object obj;
        private Attribute nameAttribute;

        public ValueHandler(Map<String,Field> fieldMap,Object obj,Attribute nameAttribute){
            this.fieldMap=fieldMap;
            this.obj=obj;
            this.nameAttribute=nameAttribute;

        }

        public void onEnd(ElementPath path) {
            Element valueElement=path.getCurrent();
            String strValue=valueElement.getText();
            Field tempField=fieldMap.get(nameAttribute.getValue());
            if(tempField!=null){
                tempField.setAccessible(true);

                //设置bean的属性的值  
                setFieldValue(obj,tempField,strValue);
            }

        }

        public void onStart(ElementPath arg0) {
        }

    }



    /**
     * 处理ref标签 
     * */
    class RefHandler implements ElementHandler{

        private Map<String,Field> fieldMap;
        private Object obj;
        private Attribute nameAttribute;
        private Object bean;

        public RefHandler(Map<String,Field> fieldMap,Object obj,Attribute nameAttribute){
            this.fieldMap=fieldMap;
            this.obj=obj;
            this.nameAttribute=nameAttribute;

        }

        public void onEnd(ElementPath arg0) {
            Field tempField=fieldMap.get(nameAttribute.getValue());
            if(tempField!=null){
                tempField.setAccessible(true);

                //设置bean的属性的值  
                setFieldValue(obj,tempField,bean);
            }

        }

        public void onStart(ElementPath path) {
            Element refElement=path.getCurrent();
            Attribute beanAttribute=refElement.attribute("bean");
            bean=getBean(beanAttribute.getValue());


        }


    }



}  