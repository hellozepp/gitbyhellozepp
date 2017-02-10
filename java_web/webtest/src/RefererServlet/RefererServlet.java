package RefererServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hadoop on 16-8-19.
 */
@WebServlet(name = "RefererServlet")
public class RefererServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //向页面添加文本内容
    response.setContentType("text/html;charset=Utf-8");
        String referer =request.getHeader("Referer");
//        System.out.println(referer);
        if (referer.startsWith("http://localhost:8080/Referer1/good/"))
        {
            response.getWriter().write("<h1 style=“color:red”>ok</h1>");
        }else
            response.getWriter().write("<h1 style=“color:red”>别闹</h1>");
    }
}
