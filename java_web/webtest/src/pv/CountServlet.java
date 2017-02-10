package pv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hadoop on 16-8-26.
 */
@WebServlet(name = "CountServlet")
public class CountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Integer count= (Integer) getServletContext().getAttribute("count");
    getServletContext().setAttribute("count",++count);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<h1>欢迎大爷!!!</h1>");
    }

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("count",0);//获取域对象,设置全局参数和存入的数据

    }
}
