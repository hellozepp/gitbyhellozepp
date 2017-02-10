package JDBC.datasource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hadoop on 16-9-10.
 */
public interface MyConnection {
    public Connection getConn() throws InterruptedException;
    public void returnConn(Connection conn);
    public Object getResult(String sql,Connection conn) throws SQLException;
}
