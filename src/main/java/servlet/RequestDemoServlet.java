package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: RequestDemoServlet.java, v 0.1 2020-03-15  21.03 Ahmad Isyfalana Amin Exp $
 */
@WebServlet(
        name = "RequestDemoServlet",
        urlPatterns = {"/request-servlet"}
)
public class RequestDemoServlet implements Servlet {

    // preserve servlet config
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // Get Servlet Context
        ServletContext servletContext = servletConfig.getServletContext();

        PrintWriter out = servletResponse.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Display Servlet Request</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h1>Servlet Request Informations: </h1>");

        out.println("<ul>");
        out.println("<li> Servlet Name : " + servletConfig.getServletName() + "</li>");
        out.println("<li> Protocol : " + servletRequest.getProtocol() + "</li>");
        out.println("<li> Server Name : " + servletRequest.getServerName() + "</li>");
        out.println("<li> Character Encoding : " + servletRequest.getCharacterEncoding() + "</li>");
        out.println("<li> Content Type : " + servletRequest.getContentType() + "</li>");
        out.println("<li> Content Length : " + servletRequest.getContentLength() + "</li>");
        out.println("<li> Remote Address : " + servletRequest.getRemoteAddr() + "</li>");
        out.println("<li> Remote Host : " + servletRequest.getRemoteHost() + "</li>");
        out.println("<li> Scheme : " + servletRequest.getScheme() + "</li>");

        Enumeration parameters = servletRequest.getParameterNames();
        while (parameters.hasMoreElements()) {
            String parameterName = (String) parameters.nextElement();
            out.println("<br>Parameter Name: " + parameterName);
            out.println("<br>Parameter Value: " +
                    servletRequest.getParameter(parameterName));
        }
        Enumeration attributes = servletRequest.getAttributeNames();
        while (attributes.hasMoreElements()) {
            String attribute = (String) attributes.nextElement();
            out.println("<BR>Attribute name: " + attribute);
            out.println("<BR>Attribute value: " + servletRequest.getAttribute(attribute));
        }

        out.println("</ul>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return servletConfig.getServletName();
    }

    @Override
    public void destroy() {

    }
}