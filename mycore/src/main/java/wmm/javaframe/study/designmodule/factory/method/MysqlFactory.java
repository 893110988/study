package wmm.javaframe.study.designmodule.factory.method;

/**
 * Created by Administrator on 2016/8/25.
 */
public class MysqlFactory implements DriverFactoty {
    public DriverInterface getDriverInterface() {
        return new MysqlDriver();
    }
}
