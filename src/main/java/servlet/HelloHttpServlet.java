package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: HelloHttpServlet.java, v 0.1 2020-03-14  23.07 Ahmad Isyfalana Amin Exp $
 */
@WebServlet(
    name = "HelloHttpServlet",
    urlPatterns = {"/hello-http-servlet"}
)
public class HelloHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =  resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Sample HTTP Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hallo HTTP Servlet</h1>");
        out.println("</body>");
        out.println("</html>");
    }

}