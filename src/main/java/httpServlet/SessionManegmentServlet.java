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
 * @version $Id: SessionManegmentServlet.java, v 0.1 2020-03-21  20.54 Ahmad Isyfalana Amin Exp $
 */
@WebServlet(
    name = "RegisterServlet",
    urlPatterns = {"/session"}
)
public class SessionManegmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = "home/content_home.html";

        ServletResponseHelper.with(resp)
                .thenWriteHeader()
                .thenWriteBodyContent(content)
                .thenWriteFooter()
                .fly();
    }
}