package MVCTest;

import MVCTest.Tool.IDAO;
import MVCTest.Tool.Initservlet;
import MVCTest.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**

 * Created by hadoop on 16-9-6.
 */
public class DAO implements IDAO {
    private Connection connection= Initservlet.getConn();
    @Override
    public void addUser(User user){
//        String sql = "inert into userinfo(id,name) values(8,'aaa8')";
        String sql = "SELECT  * FROM userinfo";
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            System.out.println("添加成功!"+resultSet.next());
            connection.commit();
            Initservlet.returnConn(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


}
