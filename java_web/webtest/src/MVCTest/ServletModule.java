package MVCTest;

import MVCTest.Tool.IDAO;
import MVCTest.Tool.Initservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hadoop on 16-9-6.
 */
@WebServlet(name = "ServletModule")
public class ServletModule extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       User user =new User();
        user.setId(10);
        user.setPass("123");
        user.setUser("aaa");
        IDAO dao =new DAO();
        dao.addUser(user);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}
