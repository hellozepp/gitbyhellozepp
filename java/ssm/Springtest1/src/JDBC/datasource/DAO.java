package JDBC.datasource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hadoop on 16-9-4.
 */
public class DAO implements UserDao {
    public void setMyConnection(MyConnection myConnection) {
        this.myConnection = myConnection;
    }
    private MyConnection myConnection;


    @Override
    public void login(String  name, String pass) {
        String sql ="select name,pass from userinfo where name='"+name+"' and pass='"+pass+"'";
        try {
            Connection conn =myConnection.getConn();
            Boolean result = (Boolean) myConnection.getResult(sql,conn);
            if(result){
                System.out.println("true");;
            }
            else
                System.out.println("Using a password on the command line interface can be insecure.");
            myConnection.returnConn(conn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean findPwdByUserName(String pass) {
        return false;
    }

}
