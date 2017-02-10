package URLDecoderTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * Created by hadoop on 16-9-23.
 */
@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String xxxx =request.getParameter("xxxx");
        String value1 =request.getParameter("xxx");
//        String xxx = URLDecoder.decode(value1);
        PrintWriter out=response.getWriter();
        out.write("\"hello\" "+value1);
        out.close();//千万别忘了关
        System.out.println("\"hello\" "+value1);
        request.getRequestDispatcher("/测试.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}
