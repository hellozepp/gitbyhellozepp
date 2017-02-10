package tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by andilyliao on 16-9-5.
 */
@WebServlet(name = "InitServlet")
public class InitServlet extends HttpServlet {
//    private static Connection conn=null;
    private static final int maxActive=100;
    private static ArrayBlockingQueue<Connection> abq=new ArrayBlockingQueue<Connection>(maxActive);
    public static Connection getConn() throws InterruptedException {
        return abq.take();
    }
    public static void returnConn(Connection conn) throws InterruptedException {
        abq.put(conn);
    }
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String url="jdbc:mysql://192.168.122.1:3306/mytestdb?useUnicode=true&characterEncoding=utf-8";
            String username="root";
            String password="root";
            for (int i=0;i<maxActive;i++) {
                Connection conn = DriverManager.getConnection(url, username, password);
                conn.setAutoCommit(false);
                abq.put(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            while (abq.size()>0){
                Connection conn =(Connection) abq.take();
                conn.close();
            }
        }  catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
