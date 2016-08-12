package wmm.javaframe.study.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/** 
 * @Description TODO add description
 * @Since Ver 1.0
 * @author <a href="mailto:qingtaownag@ebnew.com">wqt</a> 
 * @date 创建时间�?016-6-15 下午1:06:58 
 *
 */
public class jdbctest2 {
	static String sql = null;
	static DBHelper db1 = null;
	static ResultSet ret = null;
	public static List<String> getDatabases() {
		sql = "show databases";// SQL语句
		db1 = new DBHelper("jdbc:mysql://10.4.0.20");// 创建DBHelper对象
		List<String> databaseList = new ArrayList<String>();
		try {
			ret = db1.executeQuery(sql, null);// 执行语句，得到结果集
			while (ret.next()) {
				String databaseName = ret.getString(1);
				if(databaseName.startsWith("e_test")){
					try{
						String update="update "+databaseName+".bmpfjz_bid_item_sheet_template aa join "+databaseName+".reg_user u set aa.comp_id=u.COMPANY_ID,aa.user_id=1 ,aa.user_name=u.name,aa.update_user_id=1, aa.update_user_name=u.NAME where u.id=1";
						db1.execute(update, null);
					}catch (Exception e){
						System.out.println(databaseName);
					}

				}
			}// 显示数据
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return databaseList;
	}

	public static void main(String[] args) {
		List<String> list = getDatabases();
	}
}
