package check;

import java.io.Serializable;

/**
 * Created by hadoop on 16-9-2.
 */
public class User implements Serializable {

    private static final long serialVersionUID=22321L;
    private String sax;

    //构造器
    public User(String sax) {
        this.sax = sax;
    }

    public String getSax() {
        return sax;
    }


    public void setSax(String sax) {
        this.sax = sax;
    }



}
