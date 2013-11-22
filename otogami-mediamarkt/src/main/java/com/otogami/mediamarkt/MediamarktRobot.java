package com.otogami.mediamarkt;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.otogami.core.Robot;
import com.otogami.core.model.Platform;
import com.otogami.core.model.Videogame;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MediamarktRobot implements Robot {

    private static final Logger log = Logger.getLogger(MediamarktRobot.class);

    private static final String BASE_URL = "http://tiendas.mediamarkt.es";

	public Collection<Videogame> getVideogamesOnPlatform(Platform platform) {
        log.debug("Getting Videogames for platform " + platform);

        Collection<Videogame> result = new ArrayList<Videogame>();

        WebClient webClient = new WebClient();

        try {
            HtmlPage page = webClient.getPage(BASE_URL + "/juegos-ps3");
            List<HtmlDivision> games = (List<HtmlDivision>) page.getByXPath("//div[contains(@class, 'product product9')]");
            for (HtmlDivision game : games) {
                GameParser gameParser = new GameParser(BASE_URL, game);
                String title = gameParser.getTitle();
                String url = gameParser.getUrl();

                log.debug("Title -> " + title + ", " + url);
            }
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
