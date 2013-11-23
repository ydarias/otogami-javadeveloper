package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;

public class PSVitaGameParser extends GameParser {

    public PSVitaGameParser(String platformBaseUrl, HtmlDivision game) {
        super(platformBaseUrl, game);
    }

    @Override
    protected boolean hasSpecificPlatformErrors(String description) {
        return false;
    }

    @Override
    protected String cleanName(String name) {
        String result = name.replace("Juego PSVita", "");
        result = result.replace("PS Vita", "");
        result = result.replace("PSVita", "");

        return result.trim();
    }

}
