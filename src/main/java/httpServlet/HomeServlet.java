package httpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: HomeServlet.java, v 0.1 2020-03-21  19.19 Ahmad Isyfalana Amin Exp $
 */
@WebServlet(
    name = "HomeServlet",
    urlPatterns = {""}
)
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletHelper.writeHtmlHeader(resp);

        ServletHelper.writeHtmlBody(resp, "");

        ServletHelper.writeHtmlFooter(resp);
    }
}