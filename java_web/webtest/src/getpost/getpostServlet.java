package getpost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hadoop on 16-8-23.
 */
@WebServlet(name = "getpostServlet")
public class getpostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
//        out.println("ok");
        out.write("doPost");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        response.setContentType("test/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
//        request.getRequestDispatcher(j)
        out.write(request.getParameter("bbb").toString());
        out.write("doGet");
        out.close();
    }
}
