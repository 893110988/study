package wmm.javaframe.study.designmodule.proxy.static1;


import com.mysql.jdbc.Statement;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Administrator on 2016/8/23.
 */
public class DataSource {
    private static LinkedList<Connection> conns=new LinkedList<Connection>();
    private Connection getConn(String url,String userName,String password) throws SQLException {
        return DriverManager.getConnection(url,userName,password);
    }



    private DataSource(){
        if(conns==null||conns.size()==0){
            for(int i=0;i<10;i++){
                try {
                    conns.add(getConn("jdbc:mysql://127.0.0.1/dynamicdb","root","123456"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public MyConnection getConnection() throws SQLException {
        if(conns!=null&&conns.size()>0) {
            return new StaticProcy(conns.remove());
        }
        return null;
    }


    public static DataSource getDataSource(){
        return GetDataSource.dataSource;
    }


    private static class GetDataSource{
        static DataSource dataSource=new DataSource();
    }

}
