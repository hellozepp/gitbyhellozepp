package demo.action;

import demo.pojo.User;
import demo.service.DemoService;
import demo.service.IDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andilyliao on 16-9-5.
 */
@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    private IDemo demo=new DemoService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u=new User();
        demo.xxx(u);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
