package org;

import tools.Aaa;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by andilyliao on 16-8-31.
 */
public class Testserv implements Aaa {

    public String doservcie(Object obj) throws ServletException, IOException {
        User user=(User) obj;
        if(user.getUn().equalsIgnoreCase("a1")&&user.getPs().equalsIgnoreCase("a1")){
            return "/ok.html";
        }else{
            return "/err.html";
        }
    }
}
