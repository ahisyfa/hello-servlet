package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: GetContextServlet.java, v 0.1 2020-03-15  20.33 Ahmad Isyfalana Amin Exp $
 */
@WebServlet(
        name = "GetContextServlet",
        urlPatterns = {"/hello-context"}
)
public class GetContextServlet implements Servlet {

    // preserve servlet config
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;

        // Add some attribute to servlet context
        servletConfig
                .getServletContext()
                .setAttribute("author", "Ahamd Isyfalana Amin");
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        // Get Servlet Context
        ServletContext servletContext = servletConfig.getServletContext();

        PrintWriter out = servletResponse.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Display Servlet Context</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h1>Servlet Context Informations: </h1>");

        out.println("<ul>");
        out.println("<li> Servlet Name : " + servletConfig.getServletName() + "</li>");
        out.println("<li> ServletContext servletContext.getMajorVersion : " + servletContext.getMajorVersion() + "</li>");
        out.println("<li> ServletContext servletContext.getMinorVersion : " + servletContext.getMinorVersion() + "</li>");
        out.println("<li> ServletContext servletContext.getContextPath : " + servletContext.getContextPath() + "</li>");
        out.println("<li> ServletContext servletContext.getServerInfo : " + servletContext.getServerInfo() + "</li>");
        out.println("<li> ServletContext servletContext.getAttribute : " + servletContext.getAttribute("author") + "</li>");
        out.println("</ul>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}