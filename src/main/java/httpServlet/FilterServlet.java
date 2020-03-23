package httpServlet;

import helper.ServletResponseHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: FilterServlet.java, v 0.1 2020-03-22  16.27 Ahmad Isyfalana Amin Exp $
 */
@WebServlet(
        name = "FilterServlet",
        urlPatterns = {"/filter"}
)
public class FilterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String content = "filter/filter.html";

        ServletResponseHelper.with(resp)
                .thenWriteHeader()
                .thenWriteBodyContent(content)
                .thenWriteFooter()
                .fly();
    }
}