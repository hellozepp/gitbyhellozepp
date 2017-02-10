package before;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hadoop on 16-9-4.
 */
public class DAO implements UserDao {
    public static void main(String[] args) {
        DAO a =new DAO();
        a.login("xxx","xxx");
    }

    @Override
    public void login(String  name, String pass) {
        String sql ="select * from userinfo where name="+name+" pass="+pass;
            MysqlConnection mysqlConnection;
        try {
            mysqlConnection = new MysqlConnection();
            Connection conn =mysqlConnection.getConn();
            mysqlConnection.getResult(sql,conn);
//            mysqlConnection.returnConn(conn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (ClassNotFoundException e) {
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
