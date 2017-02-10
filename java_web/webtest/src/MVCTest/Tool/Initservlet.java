package MVCTest.Tool;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by hadoop on 16-9-6.
 */
public class Initservlet extends HttpServlet {
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/mytestdb";
    public static final String USERNAME = "mytestdb";
    public static final String PASSWORD = "mytestdb";
    public static final int Conn = 100;
    //    private Vector connections =null;
    public static ArrayBlockingQueue<Connection> abq =new ArrayBlockingQueue<Connection>(100);
    public   static Connection getConn(){
        try {
            return abq.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public  static  void returnConn(Connection conn){
        try {
            abq.put(conn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void destroy() {
        super.destroy();
    }
    @Override
    public void init() throws ServletException {
//        System.out.println("z执行了init111111");
        Connection connection=null;
        Statement statement=null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
            for(int i=0;1<Conn;i++){
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                abq.put(connection);
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
