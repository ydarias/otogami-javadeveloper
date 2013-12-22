package com.otogami.server.servlets;

import com.otogami.server.facade.VideogameFacade;
import com.otogami.server.facade.VideogameSearchSpecification;
import com.otogami.server.model.VideogameEntity;
import com.otogami.server.templates.VideogamesTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class VideogameServlet extends HttpServlet {

    @Autowired
    private VideogameFacade videogameFacade;

    @Autowired
    private VideogamesTemplate videogamesTemplate;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VideogameSearchSpecification searchSpecification = dataBinding(request);
        List<VideogameEntity> videogames = videogameFacade.getVideogames(searchSpecification);

        response.setHeader("Content-Type", "text/html");
        videogamesTemplate.write(response.getWriter(), searchSpecification, videogames);
    }

    private VideogameSearchSpecification dataBinding(HttpServletRequest request) {
        VideogameSearchSpecification searchSpecification = new VideogameSearchSpecification();

        searchSpecification.setTitle(request.getParameter("title"));
        searchSpecification.setPlatform(request.getParameter("platform"));
        if (StringUtils.isNotBlank(request.getParameter("availability")))
            searchSpecification.setAvailable(true);
        if (StringUtils.isNotBlank(request.getParameter("price")))
            searchSpecification.setMinorPrice(true);

        return searchSpecification;
    }

}
