package com.otogami.server.templates;

import com.otogami.server.facade.VideogameSearchSpecification;
import com.otogami.server.model.VideogameEntity;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VideogamesTemplate {

    private static final Logger log = LoggerFactory.getLogger(VideogamesTemplate.class);

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    public void write(PrintWriter writer, VideogameSearchSpecification searchSpecification, List<VideogameEntity> videogames) {
        try {
            Map<String, Object> data = buildTemplateContext(searchSpecification, videogames);
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("videogames.ftl");
            template.process(data, writer);
        } catch (TemplateException e) {
            log.error("El template videogames.ftl no correcto o contiene errores", e);
        } catch (IOException e) {
            log.error("No se encuentra el fichero videogames.ftl o el PrinterWriter no es correcto", e);
        }
    }

    private Map<String, Object> buildTemplateContext(VideogameSearchSpecification searchSpecification, List<VideogameEntity> videogames) {
        Map<String, Object> data = new HashMap();

        data.put("title", searchSpecification.getTitle());
        data.put("platform", searchSpecification.getPlatform());
        if (searchSpecification.isAvailable())
            data.put("availability", "on");
        if (searchSpecification.isMinorPrice())
            data.put("price", "on");
        data.put("videogames", videogames);

        return data;
    }

}
