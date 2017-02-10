package cn.hellozepp.ssm.po;

import java.io.Serializable;

/**
 * Created by hadoop on 2017/1/5.
 */
public class User implements Serializable {
    private String username=null;
    private String name=null;
    private String password=null;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
