package helper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Helper class to write html response
 *
 * @author Ahmad Isyfalana Amin
 * @version $Id: ServletResponseHelper.java, v 0.1 2020-03-21  22.17 Ahmad Isyfalana Amin Exp $
 */
public class ServletResponseHelper {

    private static ServletResponseHelper servletResponseHelper;

    private HttpServletResponse httpServletResponse;

    private ServletResponseHelper(HttpServletResponse response) {
        this.httpServletResponse = response;
    }

    public static ServletResponseHelper with(HttpServletResponse response) {

        if (servletResponseHelper == null) {
            servletResponseHelper = new ServletResponseHelper(response);
        }

        return servletResponseHelper;
    }

    public static ServletResponseHelper thenWriteHeader() throws IOException {
        servletResponseHelper
                .getHttpServletResponse()
                .getWriter()
                .append(FileReaderHelper.getContent("layout/header.html"));

        return servletResponseHelper;
    }

    public static ServletResponseHelper thenWriteBodyContent(String content) throws IOException {
        servletResponseHelper
                .getHttpServletResponse()
                .getWriter()
                .append(FileReaderHelper.getContent(content));

        return servletResponseHelper;
    }

    public static ServletResponseHelper thenWriteFooter() throws IOException {
        servletResponseHelper
                .getHttpServletResponse()
                .getWriter()
                .append(FileReaderHelper.getContent("layout/footer.html"));

        return servletResponseHelper;
    }

    public static void fly() throws IOException {
        servletResponseHelper
                .getHttpServletResponse()
                .getWriter()
                .flush();
    }

    /**
     * Getter method for property <tt>httpServletResponse</tt>.
     *
     * @return property value of httpServletResponse
     */
    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }
}