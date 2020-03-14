package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: BasicFilter.java, v 0.1 2020-03-14  23.42 Ahmad Isyfalana Amin Exp $
 */
@WebFilter("/*")
public class BasicFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("BasicFilter::init -> " + filterConfig.toString());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("BasicFilter::doFilter -> " + servletRequest.toString());

        // Continue to next filter
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("BasicFilter::destroy ");
    }
}