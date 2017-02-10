package MVCTest;

import java.io.Serializable;

/**
 * Created by hadoop on 16-9-2.
 */
public class User{
    private String name;
    private String pass;

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public int getId() {
        return id;
    }
    public String getUser() {
        return name;
    }
    public void setUser(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

}
