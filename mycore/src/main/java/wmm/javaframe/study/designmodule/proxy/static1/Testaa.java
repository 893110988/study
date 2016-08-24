package wmm.javaframe.study.designmodule.proxy.static1;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/8/24.
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
