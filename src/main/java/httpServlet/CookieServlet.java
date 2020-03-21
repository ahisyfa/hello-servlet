package httpServlet;

import helper.ServletResponseHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: CookieServlet.java, v 0.1 2020-03-21  23.31 Ahmad Isyfalana Amin Exp $
 */
@WebServlet(
        name = "CookieServlet",
        urlPatterns = {"/cookie"}
)
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // inject some cookies

        Cookie cookie1 = new Cookie("author", "Ahmad-Isyfalana-Amin");
        Cookie cookie2 = new Cookie("username", "Ahmad-Isyfalana-Amin");
        Cookie cookie3 = new Cookie("password", "thisIsMySecretPassword");
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);

        String content = "session/cookie.html";

        ServletResponseHelper.with(resp)
                .thenWriteHeader()
                .thenWriteBodyContent(content)
                .thenWriteFooter()
                .fly();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer content = new StringBuffer();
        content.append("<div class=\"container\">");

        content.append("<h1>Here all the header</h1>");
        content.append("<table class='table table-hover table-responsive-md'>");

        content.append("<thead><tr>");
        content.append("<th width='30%'>Name</th>");
        content.append("<th>Value</th>");
        content.append("</tr></thead>");
        content.append("<tbody>");

        Enumeration names = req.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            content.append("<tr>");
            content.append("<td class='font-weight-bold'>" + name + "</td>");
            content.append("<td>" + req.getHeader(name) + "</td>");
            content.append("</tr>");
        }
        content.append("</tbody>");
        content.append("</table> <br/>");

        content.append("<h1>Here all the cookies</h1>");
        content.append("<table class='table table-hover table-responsive-md'>");

        content.append("<thead><tr>");
        content.append("<th width='30%'>Name</th>");
        content.append("<th>Value</th>");
        content.append("</tr></thead>");

        content.append("<tbody>");

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                content.append("<tr>");
                content.append("<td class='font-weight-bold'>" + cookie.getName() + "</td>");
                content.append("<td>" + cookie.getValue() + "</td>");
                content.append("</tr>");
            }
        }

        content.append("</tbody>");
        content.append("</table> <br/>");

        content.append("<hr/><a href='/session' class='btn btn-large btn-primary'>Back</a>");

        content.append("</div>");


        ServletResponseHelper.with(resp)
                .thenWriteHeader()
                .thenWriteSimpleBodyContent(content.toString())
                .thenWriteFooter()
                .fly();
    }
}