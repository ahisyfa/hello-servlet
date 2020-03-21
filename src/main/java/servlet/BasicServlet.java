package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: HomeServlet.java, v 0.1 2020-03-14  22.34 Ahmad Isyfalana Amin Exp $
 */
@WebServlet(
    name = "BasicServlet",
    urlPatterns = {"/basic-servlet"}
)
public class BasicServlet implements Servlet {

    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("HomeServlet :: Init HomeServlet : " + servletConfig.toString());
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HomeServlet :: service");
        ServletOutputStream out = servletResponse.getOutputStream();
        out.write("Home".getBytes());
        out.flush();
        out.close();
    }

    @Override
    public String getServletInfo() {
        return "HomeServlet :: Home Servlet Info";
    }

    @Override
    public void destroy() {
        System.out.println("ooh destroyed");
    }

}