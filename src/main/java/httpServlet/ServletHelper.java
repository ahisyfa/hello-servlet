package httpServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: CustomHttpServlet.java, v 0.1 2020-03-21  19.25 Ahmad Isyfalana Amin Exp $
 */
@WebServlet
public class ServletHelper extends HttpServlet {

    /**
     * Write HTML Header View
     *
     * @param response
     * @throws IOException
     */
    public static void writeHtmlHeader(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<title>" + "Hello Servlet!" + "</title>");

        out.println("<meta charset=\"utf-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");

        // Boostrap CSS
        out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");

        out.println("");
        out.println("");

        out.println("</head>");
        out.println("<body>");
    }

    /**
     * Write HTML Body content
     *
     * @param response
     * @param content
     * @throws IOException
     */
    public static void writeHtmlBody(HttpServletResponse response, String content) throws IOException {
        PrintWriter out = response.getWriter();

        out.println("<div class=\"d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm\">");
            out.println("<h5 class=\"my-0 mr-md-auto font-weight-normal\">Hello Servlet</h5>");
            out.println("<nav class=\"my-2 my-md-0 mr-md-3\">");
                out.println("<a class=\"p-2 text-dark\" href=\"#\">Features</a>");
            out.println("</nav>");
        out.println("<a class=\"btn btn-outline-primary\" href=\"#\">Sign in</a>");
        out.println("</div>");


        out.println("<div class=\"pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center\">");
            out.println("<h1 class=\"display-4\">Hello Servlet</h1>");
            out.println("<p class=\"lead\">Learn Servlet Fundamental with  Ahmad Isyfalana Amin</p>");
            out.println("<p class=\"lead\">Source code: <a target='_blank' href='https://github.com/ahisyfa/hello-servlet'>https://github.com/ahisyfa/hello-servlet</a></p>");
        out.println("</div>");

        out.println("<div class=\"container\">");

        // Content
        out.println(content);

            // Footer Menu
            out.println("<footer class=\"pt-4 my-md-5 pt-md-5 border-top\">");
                out.println("<div class=\"row\">");
                    out.println("<div class=\"col-12 col-md\">");
                    out.println("<img class=\"mb-2\" src=\"https://getbootstrap.com/docs/4.4/assets/brand/bootstrap-solid.svg\" alt=\"\" width=\"24\" height=\"24\">");
                    out.println("<small class=\"d-block mb-3 text-muted\">&copy; 2020</small>");
                    out.println("</div>");

                    out.println("<div class=\"col-6 col-md\">");
                        out.println("<h5>Basic Examples</h5>");
                        out.println("<ul class=\"list-unstyled text-small\">");
                            out.println("<li><a class=\"text-muted\" href=\"/basic-servlet\">Basic Servlet</a></li>");
                        out.println("</ul>");
                    out.println("</div>");

                    out.println("<div class=\"col-6 col-md\">");
                        out.println("<h5>HttpServlet Examples</h5>");
                        out.println("<ul class=\"list-unstyled text-small\">");
                            out.println("<li><a class=\"text-muted\" href=\"/register\">RegisterServlet</a></li>");
                        out.println("</ul>");
                    out.println("</div>");

                out.println("</div>");
            out.println("</footer>");
            // End Footer Menu

        out.println("</div>");


    }

    /**
     * Write HTML Footer
     *
     * @param response
     * @throws IOException
     */
    public static void writeHtmlFooter(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        out.println("<script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>");
        out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>");
        out.println("</body>");
        out.println("</html>");
    }

}