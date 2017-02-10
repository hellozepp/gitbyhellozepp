package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by hadoop on 16-8-26.
 */
@WebServlet(name = "ContextTest")
public class ContextTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       //servletContext对象的调用,调用服务器初始化参数
        ServletContext sc =getServletContext();
        String encoding =sc.getInitParameter("encoding");
        System.out.println("编码:"+encoding);

        Enumeration<String> e =sc.getInitParameterNames();
        while (e.hasMoreElements())
        {
            String name= e.nextElement();
            System.out.println(name+":"+sc.getInitParameter(name));
        }
    }

    @Override
    public void init() throws ServletException {
        //首次访问启动
        System.out.println("=========init===================");
    }
}
