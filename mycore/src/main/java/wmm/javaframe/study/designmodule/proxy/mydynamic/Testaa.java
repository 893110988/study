package wmm.javaframe.study.designmodule.proxy.mydynamic;

import wmm.javaframe.study.designmodule.proxy.DataSource;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Testaa {
    public static void main(String[] args) {

        GoHomeProxy proxy=new GoHomeProxy();
        GoHome goHome=new GoHome();
        GoHomeInterface object= (GoHomeInterface)Proxy.newProxyInstance(goHome.getClass().getClassLoader(),goHome.getClass().getInterfaces(),proxy );
        System.out.println( object.goHome());
        System.out.println( object.goWork());
    }

}
