package TomcatTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by hadoop on 16-8-21.
 */
@WebServlet(name = "TomServlet")
public class TomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration enu =request.getHeaderNames();
        while (enu.hasMoreElements()){
            String headerName =enu.nextElement().toString();
            PrintWriter pw =response.getWriter();
            pw.println(headerName+":"+request.getHeader(headerName));
        }
        System.out.println("===============================");
        System.out.println("请求方式:"+request.getMethod());
        System.out.println("请求的协议种类:"+request.getProtocol());
        System.out.println("请求资源路径:"+request.getRequestURI());
        System.out.println("请求的路径信息:"+request.getRequestURL());
        System.out.println("请求的 Servlet 路径:"+request.getServletPath());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
