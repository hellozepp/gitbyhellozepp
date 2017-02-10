package org;

import tools.Aaa;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by andilyliao on 16-9-2.
 */
public class Test11 implements Aaa {
    @Override
    public String doservcie(Object obj) throws ServletException, IOException {
        User user=(User)obj;
        return "/ok.html";
    }
}
