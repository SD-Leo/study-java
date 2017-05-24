/*
 * 2017-05-24
 */
package ru.davist.study.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author StarovoytovD
 */
public class MyServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(MyServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("AuthType = {}", req.getAuthType());
        log.debug("ContextPath = {}", req.getContextPath());
        log.debug("HeaderNames = {}", req.getHeaderNames());
        log.debug("Method = {}", req.getMethod());
        log.debug("Session = {}", req.getSession().getId());
        log.debug("Locale = {}", req.getLocale());


        int i = new Random().nextInt();
        if (i > 1_500_000_000) {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                log.error("",e);
            }
        }
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        StringBuilder sb = new StringBuilder();
        sb.append("Session id:");
        sb.append("<b>");
        sb.append(req.getSession().getId());
        sb.append("</b><br/>");
        sb.append("session is new:");
        sb.append("<b>");
        sb.append(req.getSession().isNew());
        sb.append("</b>");
        sb.append("<br/>");
        sb.append(i);
        writer.write(sb.toString());
        writer.close();
    }
}
