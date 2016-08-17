package wmm.javaframe.study.annotation.handle;

import wmm.javaframe.study.annotation.ann.MyAnnotation;
import wmm.javaframe.study.annotation.model.UserAnno;
import wmm.javaframe.study.reflect.vistor.PrintVisitor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/8/17.
 */
public class MyAnnotationHandle {
    public  void getAnno(Class cls){
       String name="name:";
        Field[] fields=cls.getDeclaredFields();
        for(Field field:fields)
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                try {
                    String methodName="set" + firstLetterToUpper(field.getName());
                    Method method= cls.getMethod(methodName, new Class[]{String.class});
                    MyAnnotation myAnno =(MyAnnotation)field.getAnnotation(MyAnnotation.class);
                    method.invoke(cls.newInstance(),new Object[] {name+myAnno.value() });
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
    }

    public static String firstLetterToUpper(String str){
        char[] array = str.toCharArray();
        array[0] -= 32;
        return String.valueOf(array);
    }
    public static void main(String[] args) {
        MyAnnotationHandle impl=new MyAnnotationHandle();
        //UserAnno anno=new UserAnno();
       // Class cls=UserAnno.class;
        impl.getAnno(UserAnno.class);
       // System.out.println(anno.getName());
    }
}
