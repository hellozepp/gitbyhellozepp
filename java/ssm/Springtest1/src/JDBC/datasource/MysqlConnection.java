package JDBC.datasource;

import java.sql.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by hadoop on 16-9-10.
 */
public class MysqlConnection implements MyConnection{
       private Statement statement=null;
        private Connection connection=null;
    public MysqlConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestdb","mytestdb","mytestdb");
        for (int i=0;i<100;i++){
            returnConn(connection);
        }
            statement =connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
    private static ArrayBlockingQueue<Connection> abq =new ArrayBlockingQueue<Connection>(100);
    public Connection getConn() throws InterruptedException {
        return abq.take();
    }
    public void returnConn(Connection conn) {
        try {
            abq.put(conn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Object getResult(String sql,Connection conn) throws SQLException {
        boolean rs= Boolean.parseBoolean(null);
        rs =statement.execute(sql);
        if (rs)
        return rs;
        else return false;
    }
    // 关闭操作
    public static void closeConnection(Connection con) throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    public static void closeStatement(Statement st) throws SQLException {
        if (st != null) {
            st.close();
        }
    }

    public static void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }


}
