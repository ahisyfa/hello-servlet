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

    public static synchronized ServletResponseHelper with(HttpServletResponse response) {

        if (servletResponseHelper == null) {
            servletResponseHelper = new ServletResponseHelper(response);
        }

        return servletResponseHelper;
    }

    public static synchronized ServletResponseHelper thenWriteHeader() throws IOException {
        servletResponseHelper
                .getHttpServletResponse()
                .getOutputStream()
                .print(FileReaderHelper.getContent("layout/header.html"));

        return servletResponseHelper;
    }

    public static synchronized ServletResponseHelper thenWriteSimpleBodyContent(String content) throws IOException {
        servletResponseHelper
                .getHttpServletResponse()
                .getOutputStream()
                .print(content);

        return servletResponseHelper;
    }

    public static synchronized ServletResponseHelper thenWriteBodyContent(String filePath) throws IOException {
        servletResponseHelper
                .getHttpServletResponse()
                .getOutputStream()
                .print(FileReaderHelper.getContent(filePath));

        return servletResponseHelper;
    }

    public static synchronized ServletResponseHelper thenWriteFooter() throws IOException {
        servletResponseHelper
                .getHttpServletResponse()
                .getOutputStream()
                .print(FileReaderHelper.getContent("layout/footer.html"));

        return servletResponseHelper;
    }

    public static synchronized void  fly() throws IOException {
        servletResponseHelper
                .getHttpServletResponse()
                .getOutputStream()
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