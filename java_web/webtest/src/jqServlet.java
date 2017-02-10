import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hadoop on 16-8-25.
 */
@WebServlet(name = "jqServlet")
public class jqServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw =response.getWriter();
        StringBuffer sb =new StringBuffer();
        sb.append("{total:118,row:[id:1,title:'xioaming'],[id:2,'xiaozhang']}");
        pw.write(sb.toString());
        System.out.println(pw);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
