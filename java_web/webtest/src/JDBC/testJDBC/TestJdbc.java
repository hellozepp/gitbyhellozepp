package JDBC.testJDBC;

import java.sql.*;

/**
 * Created by andilyliao on 16-9-3.
 */
public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Card card=new Card();
        card.setId(12);
//        card.setName("pppp' or 1=1 #");//sql inject
        card.setName("pppp");
        card.setUid(1);
//        Connection conn=null;
//        Statement stm=null;
//        PreparedStatement stmp=null;
        ResultSet rs=null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url="jdbc:mysql://localhost:3306/mytestdb?useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="root";
        try (
                Connection conn= DriverManager.getConnection(url,username,password);
             PreparedStatement stmp=conn.prepareStatement("select * from card where name = ?");
        ){
            //jdbc
//            stm=conn.createStatement();
//            stm.execute("insert into card(id,name,uid) values("+card.getId()+",'"+card.getName()+"',"+card.getUid()+")");
//            String sql="select * from card where name ='"+card.getName()+"'";
//            System.out.println(sql);
//            rs=stm.executeQuery(sql);
            stmp.setString(1,card.getName());
            rs=stmp.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int uid=rs.getInt("uid");
                System.out.println("-------------------------");
                System.out.println(id+"    "+name+"    "+uid);
            }
            System.out.println("-------------------------");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
