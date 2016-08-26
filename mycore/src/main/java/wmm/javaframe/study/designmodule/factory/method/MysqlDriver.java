package wmm.javaframe.study.designmodule.factory.method;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/8/25.
 */
public class MysqlDriver implements DriverInterface {
    private static Logger log = Logger.getLogger(MysqlDriver.class);
    public void getConnection() {
        log.info("MysqlDriverMysqlDriverMysqlDriverMysqlDriver");
    }
}
