package JDBC.test;

import java.sql.*;

/**
 * Created by hadoop on 16-9-5.
 */
public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Statement statement=null;
        ResultSet rs=null;
        Boolean rsu =null;
        try {
            statement =DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mytestdb","mytestdb","mytestdb").createStatement();
            rs =statement.executeQuery("select * from userinfo");
            while (rs.next()){
                int id=rs.getInt("id");
                String username=rs.getString("name");
                String password=rs.getString("pass");
                System.out.println(id+"  "+username+"  "+password+"  ");
            }
            rsu=statement.execute("insert into userinfo(id,name,pass)VALUE (11,'aaa7','aaa7')");
            System.out.println(rsu);
//            如果第一个结果是 ResultSet 对象，则返回 true；如果第一个结果是更新计数或者没有结果，则返回 false
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
