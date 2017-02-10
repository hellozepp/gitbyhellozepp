package check;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by hadoop on 16-9-2.
 */
public interface Iservice {
    public String service(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, Exception;

}
