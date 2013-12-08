package com.otogami.server.servlets;

import freemarker.template.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class VideogameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "text/html");

        Configuration configuration = new Configuration();
        configuration.setServletContextForTemplateLoading(getServletContext(), "WEB-INF/templates");
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        configuration.setIncompatibleImprovements(new Version(2, 3, 20));

        Map<String, Object> data = new HashMap<String, Object>();

        Template template = configuration.getTemplate("videogames.ftl");

        PrintWriter out = response.getWriter();
        try {
            template.process(data, out);
        } catch (TemplateException e) {
            out.println("ERROR");
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
