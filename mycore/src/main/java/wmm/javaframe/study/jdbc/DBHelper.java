package wmm.javaframe.study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @Description TODO add description
 * @Since Ver 1.0
 * @author <a href="mailto:qingtaownag@ebnew.com">wqt</a>
 * @date 创建时间�?016-6-13 下午5:26:28
 * 
 */
public class DBHelper {
	
//	public static final String url = "jdbc:mysql://10.4.0.20";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "tianyuan";
	public static final String password = "s7GaCUG5";	

	public Connection conn = null;
	public PreparedStatement pst = null;
	
	 static {  
	        try {  
	            Class.forName("com.mysql.jdbc.Driver");  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	 
	public DBHelper(String url) {
		try {
			conn = DriverManager.getConnection(url, user, password);// 获取连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String sql, LinkedList<Object> params) {  
        try {  
        	pst = conn.prepareStatement(sql);  
            if (params != null) {  
                int i = 1;  
                for (Object p : params) {  
                	pst.setObject(i++, p);  
                }  
            }  
            return pst.executeQuery();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }
	public boolean execute(String sql, LinkedList<Object> params) throws Exception{

			pst = conn.prepareStatement(sql);
			if (params != null) {
				int i = 1;
				for (Object p : params) {
					pst.setObject(i++, p);
				}
			}
			return pst.execute();

	}
}
