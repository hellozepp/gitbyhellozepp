package check;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hadoop on 16-9-2.
 */
public class Service implements Iservice{

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name =request.getParameter("name");
        String pwd =request.getParameter("pwd");//获取 value
        String sax =request.getParameter("sax");//男||女
        if(name.equals("111")&&pwd.equals("111")){
//            request.getRequestDispatcher("/Check/ok.html").forward(request,response);
            IDAO idao =new DAO();
            System.out.println("Servicce +"+idao.serializable(sax));
            if(idao.serializable(sax)=="ok"){
                return "ok";
            }

        }
        return "no";
    }
}
