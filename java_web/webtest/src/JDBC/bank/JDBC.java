package JDBC.bank;

import java.sql.*;

/**
 * Created by hadoop on 16-9-3.
 */
public class JDBC {
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/userinfo";
    public static final String sqlHandler = "select * from user";
    public static final String USERNAME = "mytestdb";
    public static final String PASSWORD = "123123";
    //    Card card =new Card();
    public static void main(String[] args) throws ClassNotFoundException {
//        Class.forName(DRIVER_CLASS);//开启驱动
        Connection connection = null;
        try {
            connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement =connection.prepareStatement(sqlHandler);
            ResultSet rs =statement.executeQuery(sqlHandler);
            while (rs.next()){
                int id=rs.getInt("id");
                String username=rs.getString("username");
                String password=rs.getString("address");
                System.out.println(id+"  "+username+"  "+password+"  ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
