package com.otogami.mediamarkt;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.otogami.core.model.Platform;
import com.otogami.core.model.Videogame;
import com.otogami.mediamarkt.parsers.GameParser;
import com.otogami.mediamarkt.parsers.GameParserFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PageParser {

    private static final Logger log = Logger.getLogger(PageParser.class);

    private Platform platform;

    private HtmlPage page;

    private String platformBaseUrl;

    public PageParser(Platform platform, HtmlPage page, String platformBaseUrl) {
        this.platform = platform;
        this.page = page;
        this.platformBaseUrl = platformBaseUrl;
    }

    public Collection<Videogame> getVideogames() {
        log.debug("Parsing new page ...");

        Collection<Videogame> videogames = new ArrayList<Videogame>();
        List<HtmlDivision> gameDivs = (List<HtmlDivision>) page.getByXPath("//div[contains(@class, 'product product9')]");
        for (HtmlDivision gameDiv : gameDivs)
            processVideogame(videogames, gameDiv);

        return videogames;
    }

    private void processVideogame(Collection<Videogame> videogames, HtmlDivision gameDiv) {
        GameParser gameParser = GameParserFactory.buildInstance(platform, platformBaseUrl, gameDiv);
        if (gameParser.isGame()) {
            Videogame videogame = gameParser.buildVideogameInstance();
            videogames.add(videogame);

            log.debug("Parsed videogame " + videogame.getTitle());
        }
    }

}
