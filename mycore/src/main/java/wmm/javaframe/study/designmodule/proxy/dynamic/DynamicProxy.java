package wmm.javaframe.study.designmodule.proxy.dynamic;

import wmm.javaframe.study.designmodule.proxy.DataSource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * Created by Administrator on 2016/8/24.
 */
public class DynamicProxy implements InvocationHandler {

    private Object connection;

    public DynamicProxy(Object connection){
        this.connection=connection;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Connection.class.isAssignableFrom(proxy.getClass())&&method.getName().equals("close")){
            DataSource.getDataSource().recoveryConnection((Connection)connection);
            System.out.println("im fake close Dynamic");
            return null;
        }else {
            return method.invoke(connection, args);
        }
    }


}
