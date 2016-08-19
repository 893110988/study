package wmm.javaframe.study.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import wmm.javaframe.study.factorybean.bean.MyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2016/8/18.
 */
public class MyFactoryBean implements FactoryBean<MyFactory> ,InitializingBean,ApplicationListener<ApplicationEvent> {

   /* private String myFactoryName;*/
    private MyFactory myFactory;

    public MyFactoryBean() {
        System.out.println("initMyFactoryBean");
    }

    public MyFactory getObject() throws Exception {
        System.out.println("initProxy");
        return this.myFactory;
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }
    /*
    在spring 初始化后，执行完所有属性设置方法(即setXxx)将自动调用 afterPropertiesSet(),
     在配置文件中无须特别的配置， 但此方式增加了bean对spring 的依赖，应该尽量避免使用
     <bean name="lifeBean" class="research.spring.beanfactory.ch4.LifeCycleBean" init-method="init"><bean>
     init-method是通过反射执行的，而afterPropertiesSet是直接执行的。所以 afterPropertiesSet的执行效率比init-method要高，不过init-method消除了bean对Spring依赖
     先判断是有实现InitializingBean调用after  然后在反射判断init-method  调用init方法
     */

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
        if(this.myFactory==null){
            this.myFactory = this.buildMyFactory();
        }
    }

    private MyFactory buildMyFactory() {
       return this.myFactory=new MyFactory("wmm");
    }

    /*
    由于我们是spring托管事务，并且采用注入方式调用。
    这样的写法带来了一些问题，正常的action注入service调用的时候再事务范围内，出事务的时候会对DB连接进行释放，
    因为是这个service是系统启动直接调用的这些方法，不在事务管理范围内，于是这些DB的操作没有进行DB连接释放（关闭）。
    解决办法是，写一个专门的action实现ApplicationListener 接口，在这个action重新的onApplicationEvent方法内，
    调用该单例service，从而实现事务的入口登记，在出事务的时候就可以自动释放连接了。
     */
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("doDB");
    }

    public MyFactory getMyFactory() {
        return myFactory;
    }

    public void setMyFactory(MyFactory myFactory) {
        this.myFactory = myFactory;
    }

}
