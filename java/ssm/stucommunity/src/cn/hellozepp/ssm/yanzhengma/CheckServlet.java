package cn.hellozepp.ssm.yanzhengma;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by hadoop on 2017/1/5.
 */
@WebServlet(name = "CheckServlet")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String checkCode=request.getParameter("checkCode");
        System.out.println(checkCode);
        HttpSession session = request.getSession();
        String vCode=session.getAttribute("code").toString();
        System.out.println("vCode ="+vCode);
//        System.out.println(vCode.trim().toUpperCase()==checkCode.trim().toUpperCase());
        if(vCode.trim().toUpperCase().equals(checkCode.trim().toUpperCase())){
            System.out.println("true");
            response.getWriter().write("1");}
        else {response.getWriter().write("0");
            System.out.println("false");}
        response.getWriter().close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
