package com.otogami.mediamarkt;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.otogami.core.model.Platform;
import com.otogami.core.model.Videogame;
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

        List<HtmlDivision> games = (List<HtmlDivision>) page.getByXPath("//div[contains(@class, 'product product9')]");
        for (HtmlDivision game : games) {
            GameParser gameParser = new GameParser(platformBaseUrl, game);
            if (gameParser.isGame()) {
                Videogame videogame = buildVideogame(platform, gameParser);

                log.debug("Parsed videogame " + videogame.getTitle());

                videogames.add(videogame);
            }
        }

        return videogames;
    }

    private Videogame buildVideogame(Platform platform, GameParser gameParser) {
        Videogame videogame = new Videogame();

        videogame.setPlatform(platform);
        videogame.setTitle(gameParser.getTitle());
        videogame.setUrl(gameParser.getUrl());
        videogame.setPrice(gameParser.getPrice());

        return videogame;
    }

}
