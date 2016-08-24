package wmm.javaframe.study.designmodule.proxy.static1;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;

/**
 * Created by Administrator on 2016/8/23.
 */
public interface MyConnection extends Wrapper {

    Statement createStatement() throws SQLException;

    void close() throws SQLException;
}
