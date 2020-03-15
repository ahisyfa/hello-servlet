package servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: SimpleServlet.java, v 0.1 2020-03-15  21.29 Ahmad Isyfalana Amin Exp $
 */
@WebServlet(
        name = "SimpleServlet",
        urlPatterns = {"/simple-servlet"}
)
public class SimpleServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter out =  servletResponse.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Sample SimpleServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>This servlet extend GenericServlet</h1>");
        out.println("<p>By Extend GenericServlet we get benefits:</p>");
        out.println("<ol>");
        out.println("<li>" + "You have to provide implementations for all five methods of the Servlet interface, even though most of the time you\n" +
                "only need one. This makes your code look unnecessarily complicated."  + "</li>");
        out.println("<li>" + "The ServletConfig object is passed to the init method. You need to preserve this object to use it from other methods.\n" +
                "This is not difficult, but it means extra work."  + "</li>");
        out.println("</ol>");
        out.println("</body>");
        out.println("</html>");
    }
}