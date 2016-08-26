package wmm.javaframe.study.designmodule.factory.method;

/**
 * Created by Administrator on 2016/8/25.
 * 简单工厂模拟了+springBean管理里面获取需要的Bean
 */
public class Testaaa {


    public static void main(String[] args) {
        DriverInterface inter = new OracleFactory().getDriverInterface();
        inter.getConnection();
        inter = new MysqlFactory().getDriverInterface();
        inter.getConnection();
    }
}
