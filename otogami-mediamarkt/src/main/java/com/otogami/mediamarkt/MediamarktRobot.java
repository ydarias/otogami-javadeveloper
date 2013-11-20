package com.otogami.mediamarkt;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.otogami.core.Robot;
import com.otogami.core.model.Platform;
import com.otogami.core.model.Videogame;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;

public class MediamarktRobot implements Robot {

    private static final Logger log = Logger.getLogger(MediamarktRobot.class);

	public Collection<Videogame> getVideogamesOnPlatform(Platform platform) {
        log.debug("Getting Videogames for platform " + platform);

        Collection<Videogame> result = new ArrayList<Videogame>();

        WebClient webClient = new WebClient();

        try {
            HtmlPage page = webClient.getPage("http://tiendas.mediamarkt.es/juegos-ps3");
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            webClient.closeAllWindows();
        }

        return result;
	}

}
