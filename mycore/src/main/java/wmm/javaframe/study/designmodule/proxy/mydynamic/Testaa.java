package wmm.javaframe.study.designmodule.proxy.mydynamic;

import sun.misc.ProxyGenerator;
import wmm.javaframe.study.designmodule.proxy.DataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 1，根据传入的第二个参数interfaces动态生成一个类，实现interfaces中的接口，该例中即BusinessProcessor接口的processBusiness方法。并且继承了Proxy类，重写了hashcode,toString,equals等三个方法。具体实现可参看 ProxyGenerator.generateProxyClass(...); 该例中生成了$Proxy0类
 2，通过传入的第一个参数classloder将刚生成的类加载到jvm中。即将$Proxy0类load
 3，利用第三个参数，调用$Proxy0的$Proxy0(InvocationHandler)构造函数 创建$Proxy0的对象，并且用interfaces参数遍历其所有接口的方法，并生成Method对象初始化对象的几个Method成员变量
 4，将$Proxy0的实例返回给客户端。
 现在好了。我们再看客户端怎么调就清楚了。
 1，客户端拿到的是$Proxy0的实例对象，由于$Proxy0继承了BusinessProcessor，因此转化为BusinessProcessor没任何问题。
 BusinessProcessor bp = (BusinessProcessor)Proxy.newProxyInstance(....);
 2，bp.processBusiness()；
 实际上调用的是$Proxy0.processBusiness();那么$Proxy0.processBusiness()的实现就是通过InvocationHandler去调用invoke方法啦!


 生成的代理类classfile


 */
public class Testaa {
    public static void main(String[] args) {
        GoHome goHome=new GoHome();
        GoWork goWork=new GoWork();
        GoHomeProxy proxy=new GoHomeProxy(goHome);
        //object是生成的代理类classfile,然后找到对应的要调用的方法，然后调用GoHomeProxy 的invoke进行处理  然后选择性的调用target的具体方法
        GoHomeInterface object= (GoHomeInterface)Proxy.newProxyInstance(goHome.getClass().getClassLoader(), new Class[]{GoHomeInterface.class}, proxy);
        System.out.println( object.goHome());
        System.out.println( object.goWork());


        GoHomeProxy proxy2=new GoHomeProxy(goWork);
        GoHomeInterface object2= (GoHomeInterface)Proxy.newProxyInstance(GoHomeInterface.class.getClassLoader(), new Class[]{GoHomeInterface.class}, proxy2);
        System.out.println( object2.goHome());
        System.out.println( object2.goWork());
        System.out.println( object2.getClass().getName());
        Class clz = object2.getClass();


        File file = new File("D:/GoHomeInterface.class");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(ProxyGenerator.generateProxyClass("GoHomeInterface",new Class[]{GoHomeInterface.class}));
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
