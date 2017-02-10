package check;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hadoop on 16-9-2.
 */
@WebServlet(name = "check.Check")
public class Check extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        Iservice ser =new Service();
        try {
            System.out.println("1 servlet   "+ser.service(request, response));
            if ( ser.service(request, response)=="ok"){
                request.getRequestDispatcher("/Check/ok.html").forward(request,response);
            }
            else  request.getRequestDispatcher("/Check/error.html").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }

}
