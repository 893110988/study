package wmm.javaframe.study.designmodule.proxy.static1;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/8/24.
 * 代理类接口就是定义你要做修改的接口的方法，然后通过自己的实现类替换掉原来的实现类，通过代理类操作实现类
 *
 *  我们使用代理模式解决了上述问题，从静态代理的使用上来看，我们一般是这么做的。
 1，代理类一般要持有一个被代理的对象的引用。
 2，对于我们不关心的方法，全部委托给被代理的对象处理。
 3，自己处理我们关心的方法。
 */
public class Testaa {
    /*static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
    public static void main(String[] args) {
        try {
            MyConnection conn=DataSource.getDataSource().getConnection();
            ResultSet set=conn.createStatement().executeQuery("SELECT * FROM USER ");
            conn.close();
            System.out.println("adfasdf");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
