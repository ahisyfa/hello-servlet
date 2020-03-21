/**
 * Dana.id
 * Copyright (c) 2017-2020 All Rights Reserved.
 */
package httpServlet;

import helper.ServletResponseHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * fundamental servlet
 * @author Ahmad Isyfalana Amin
 * @version $Id: FundamentalServlet.java, v 0.1 2020-03-22  00.28 Ahmad Isyfalana Amin Exp $
 */
@WebServlet(
        name = "FundamentalServlet",
        urlPatterns = {"/fundamental"}
)
public class FundamentalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String content = "fundamental/fundamental.html";

        ServletResponseHelper.with(resp)
                .thenWriteHeader()
                .thenWriteBodyContent(content)
                .thenWriteFooter()
                .fly();
    }

}