
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class EncodingFilter extends HttpServlet implements Filter {
//    public final static String DEFAULT_URI_ENCODE = "UTF-8";
    private String encoding = null;
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }
}

