package yemian;

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
@WebServlet(name = "yemianServlet")
public class yemianServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    String userName=request.getParameter("userName");
    String password=request.getParameter("password");
        System.out.println(userName+"   "+password);
        if (userName.trim().equals("111")&&password.equals("111")){
            PrintWriter pw=response.getWriter();
            pw.write("ok");
            pw.close();
        }
        else{
            PrintWriter pw=response.getWriter();
            pw.write("失败");
            pw.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        System.out.println(userName+"   "+password);
        if (userName.trim().equals("111")&&password.equals("111")){
            PrintWriter pw=response.getWriter();
            pw.write("ok");
            pw.close();
        }
        else{
            PrintWriter pw=response.getWriter();
            pw.write("失败");
            pw.close();
        }
    }

}
