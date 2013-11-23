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
import java.util.*;

public class MediamarktRobot implements Robot {

    private static final Logger log = Logger.getLogger(MediamarktRobot.class);

    private static final String BASE_URL = "http://tiendas.mediamarkt.es";

    private static final Map<Platform, String> PLATFORM_URL = new HashMap<Platform, String>();
    static {
        PLATFORM_URL.put(Platform.ps3, "/juegos-ps3");
        PLATFORM_URL.put(Platform.xbox360, "/juegos-xbox-360");
        PLATFORM_URL.put(Platform.wii, "/juegos-nintendo-wii");
        PLATFORM_URL.put(Platform.ps4, "/ecommerce/categories/categories.cfm?id=10001596&languageid=1");
        PLATFORM_URL.put(Platform.xboxone, "/juegos-es");
        PLATFORM_URL.put(Platform.wiiu, "/juegos-wii-u");
    };

	public Collection<Videogame> getVideogamesOnPlatform(Platform platform) {
        log.debug("Getting Videogames for platform " + platform);

        Collection<Videogame> result = new ArrayList<Videogame>();

        WebClient webClient = new WebClient();

        try {
            boolean existsNextPage = true;
            String url = BASE_URL + PLATFORM_URL.get(platform);
            HtmlPage page = webClient.getPage(url);
            do {
                PageParser pageParser = new PageParser(platform, page, BASE_URL);
                Collection<Videogame> videogames = pageParser.getVideogames();
                result.addAll(videogames);

                HtmlAnchor nextPageLink = page.getFirstByXPath("//a[@class='pager pagerNext']");
                if (nextPageLink == null)
                    existsNextPage = false;
                else
                    page = nextPageLink.click();
            } while (existsNextPage);
        } catch (MalformedURLException e) {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        } finally {
            webClient.closeAllWindows();
        }

        log.debug("Parsed " + result.size() + " videogames for " + platform);

        return result;
	}

}
