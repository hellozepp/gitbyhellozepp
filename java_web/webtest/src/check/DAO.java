package check;

import java.io.*;

/**
 * Created by hadoop on 16-9-2.
 */
public class DAO implements IDAO{
    public String serializable(String sax) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("userInfo.txt"));
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("userInfo.txt"));
        User u=null;
//        System.out.println(sax);
        if(sax.equals("男")){
            u =new User("1");}
        else  if(sax.equals("女")) {
            u =new User("0");
        }
        oos.writeObject(u);
        System.out.println("DAO1 +"+ois.readObject());
//        System.out.println("DAO2 +"+((User)ois.readObject()).getSax());
        if( ((User)ois.readObject()).getSax().isEmpty() ){
            return "no";
        }
        ois.close();
        oos.close();
        return "ok";
    }
}
