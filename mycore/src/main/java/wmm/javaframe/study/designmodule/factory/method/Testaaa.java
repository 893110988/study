package wmm.javaframe.study.designmodule.factory.method;

/**
 * Created by Administrator on 2016/8/25.
 * 工厂生产唯一产品
 * 不确定工厂
 */
public class Testaaa {


    public static void main(String[] args) {
        DriverInterface inter = new OracleFactory().getDriverInterface();
        inter.getConnection();
        inter = new MysqlFactory().getDriverInterface();
        inter.getConnection();
    }
}
