package com.otogami.mediamarkt;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
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

	public Collection<Videogame> getVideogamesOnPlatform(Platform platform) {
        log.debug("Getting Videogames for platform " + platform);

        Collection<Videogame> result = new ArrayList<Videogame>();
        WebClient webClient = new WebClient();
        try {
            result = getVideogamesFromSite(platform, webClient);
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

    private Collection<Videogame> getVideogamesFromSite(Platform platform, WebClient webClient) throws IOException {
        Collection<Videogame> result = new ArrayList<Videogame>();
        String url = MediamarktUrlBuilder.getPlatformUrl(platform);
        HtmlPage page = webClient.getPage(url);
        do {
            PageParser pageParser = new PageParser(platform, page, MediamarktUrlBuilder.BASE_URL);
            result.addAll(pageParser.getVideogames());
            page = navigateToNextPage(page);
        } while (page != null);

        return result;
    }

    private HtmlPage navigateToNextPage(HtmlPage page) throws IOException {
        HtmlAnchor nextPageLink = page.getFirstByXPath("//a[@class='pager pagerNext']");
        if (nextPageLink != null)
            page = nextPageLink.click();
        else
            page = null;

        return page;
    }

}
