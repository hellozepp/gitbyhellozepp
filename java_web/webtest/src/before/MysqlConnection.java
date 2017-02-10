package before;

import java.sql.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by hadoop on 16-9-10.
 */
public class MysqlConnection {
       private Statement statement=null;
    public MysqlConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            statement = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mytestdb","mytestdb","mytestdb").createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

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
        ResultSet rs=null;
        rs =statement.executeQuery(sql);
        System.out.println(rs);
        return rs;
    }

}
