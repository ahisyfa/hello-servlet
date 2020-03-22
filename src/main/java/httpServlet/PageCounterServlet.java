package httpServlet;

import eventListener.AppAttributeEventListener;
import helper.ServletResponseHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: PageCounterServlet.java, v 0.1 2020-03-22  10.37 Ahmad Isyfalana Amin Exp $
 */
@WebServlet(
        name = "PageCounterServlet",
        urlPatterns = {"/counter"}
)
public class PageCounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String content = "<div class='container'><div class=\"jumbotron\">";


        ServletContext servletContext = getServletContext();

        int counter = (int) servletContext.getAttribute(AppAttributeEventListener.COUNTER);

        counter++;

        servletContext.setAttribute(AppAttributeEventListener.COUNTER, counter);

        content += "<p class='lead'>Hello, human.. </p>";
        content += "<h2 class=\"display-4\">You are visitor number: <code>" + counter +"</code> :-)</h2>";

        content += "<hr class=\"my-4\">";
        content += "<a class=\"btn btn-primary btn-lg\" href=\"/event\" role=\"button\">Back</a>";
        content += "</div></div>";

        ServletResponseHelper.with(resp)
                .thenWriteHeader()
                .thenWriteSimpleBodyContent(content)
                .thenWriteFooter()
                .fly();
    }
}