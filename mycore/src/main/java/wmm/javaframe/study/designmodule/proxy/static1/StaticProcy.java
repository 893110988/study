package wmm.javaframe.study.designmodule.proxy.static1;

import wmm.javaframe.study.designmodule.proxy.DataSource;

import java.sql.*;

/**
 * Created by Administrator on 2016/8/23.
 */
public class StaticProcy implements MyConnection {

    private Connection connection;

    public StaticProcy(Connection connection) {
        super();
        this.connection = connection;
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public void close() throws SQLException {
        System.out.println("im fake close ");
        DataSource.getDataSource().recoveryConnection(connection);
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
