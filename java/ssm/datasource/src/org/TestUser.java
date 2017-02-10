package org;

import tools.Aaa;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by andilyliao on 16-9-3.
 */
public class TestUser implements Aaa {
    @Override
    public String doservcie(Object obj) throws ServletException, IOException {
        User u=(User)obj;
        System.out.println(u.getPs());
        System.out.println(u.getUn());
        System.out.println(u.getId());
        return "/ok.html";
    }
}
