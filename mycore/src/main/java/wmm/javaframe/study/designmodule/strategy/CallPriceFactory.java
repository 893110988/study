package wmm.javaframe.study.designmodule.strategy;

import wmm.javaframe.study.annotation.ann.MyAnnotation;
import wmm.javaframe.study.designmodule.strategy.call.BaseCall;
import wmm.javaframe.study.designmodule.strategy.call.GoldVip;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/30.
 */
public class CallPriceFactory {
    private static final String basePath="wmm.javaframe.study.designmodule.strategy.call";

    private ClassLoader classLoader = getClass().getClassLoader();

    private List<Class<? extends BaseCall>> baseCall;

    private CallPriceFactory(){
        initBaseCall();
    }
    //根据客户的总金额产生相应的策略
    public Double createCalPrice(Double customer){
        BaseCall call;
        //在策略列表查找策略
        for (Class<? extends BaseCall> clazz : baseCall) {
            TotalValidRegion validRegion = handleAnnotation(clazz);//获取该策略的注解
            //判断金额是否在注解的区间
            if (customer > validRegion.min() && customer < validRegion.max()) {
                try {
                    //是的话我们返回一个当前策略的实例
                    call= clazz.newInstance();
                    return call.callPrice(customer);
                } catch (Exception e) {
                    throw new RuntimeException("策略获得失败");
                }
            }
        }
        throw new RuntimeException("策略获得失败");
    }

    //处理注解，我们传入一个策略类，返回它的注解
    private TotalValidRegion handleAnnotation(Class<? extends BaseCall> clazz){
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i] instanceof TotalValidRegion) {
                return (TotalValidRegion) annotations[i];
            }
        }
        return null;
    }

    private void initBaseCall() {
        baseCall=new ArrayList<Class<? extends BaseCall>>();
        File[] resources = getResources();//获取到包下所有的class文件
        Class<BaseCall> aClass;
        try {
            //使用相同的加载器加载策略接口
            aClass = (Class<BaseCall>) classLoader.loadClass(BaseCall.class.getName());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("未找到策略接口",e);
        }
        for (File resource:resources){
           try {
               //载入包下的类
               Class<?> clazz = classLoader.loadClass(basePath + "."+resource.getName().replace(".class", ""));
               //判断是否是CalPrice的实现类并且不是CalPrice它本身，满足的话加入到策略列表
               if (BaseCall.class.isAssignableFrom(clazz) && clazz != aClass) {

                   baseCall.add((Class<? extends BaseCall>) clazz);
               }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    //获取扫描的包下面所有的class文件
    private File[] getResources(){
        try {
            File file = new File(classLoader.getResource(basePath.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(".class")) {//我们只扫描class文件
                        return true;
                    }
                    return false;
                }
            });
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到策略资源");
        }
    }
    public static CallPriceFactory getCallPrice(){
        return GetCallPrice.factory;
    }

    private static class GetCallPrice{
        private static CallPriceFactory factory =new CallPriceFactory();
    }

}
