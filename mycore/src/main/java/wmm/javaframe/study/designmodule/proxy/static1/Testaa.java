package wmm.javaframe.study.designmodule.proxy.static1;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/8/24.
 * 代理类接口就是定义你要做修改的接口的方法，然后通过自己的实现类替换掉原来的实现类，通过代理类操作实现类
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
