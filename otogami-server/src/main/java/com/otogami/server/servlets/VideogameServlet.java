package com.otogami.server.servlets;

import com.otogami.server.facade.VideogameFacade;
import com.otogami.server.facade.VideogameSearchSpecification;
import com.otogami.server.model.VideogameEntity;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideogameServlet extends HttpServlet {

    @Autowired private VideogameFacade videogameFacade;

    private Configuration freemakerConfiguration;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());

        freemakerConfiguration = new Configuration();
        freemakerConfiguration.setServletContextForTemplateLoading(getServletContext(), "WEB-INF/templates");
        freemakerConfiguration.setObjectWrapper(new DefaultObjectWrapper());
        freemakerConfiguration.setDefaultEncoding("UTF-8");
        freemakerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        freemakerConfiguration.setIncompatibleImprovements(new Version(2, 3, 20));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VideogameSearchSpecification searchSpecification = dataBinding(request);

        List<VideogameEntity> videogames = videogameFacade.getVideogames(searchSpecification);

        response.setHeader("Content-Type", "text/html");

        try {
            Map<String, Object> data = buildTemplateContext(videogames);
            Template template = freemakerConfiguration.getTemplate("videogames.ftl");
            PrintWriter responseWriter = response.getWriter();
            template.process(data, responseWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    private VideogameSearchSpecification dataBinding(HttpServletRequest request) {
        VideogameSearchSpecification searchSpecification = new VideogameSearchSpecification();
        searchSpecification.setTitle(request.getParameter("title"));
        searchSpecification.setPlatform(request.getParameter("platform"));
        if (request.getParameter("availability") != null)
            searchSpecification.setAvailable(true);
        if (request.getParameter("price") != null)
            searchSpecification.setMinorPrice(true);

        return searchSpecification;
    }

    private Map<String, Object> buildTemplateContext(List<VideogameEntity> videogames) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("videogames", videogames);
        return data;
    }

}
