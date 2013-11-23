package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;

public class WiiGameParser extends GameParser {

    public WiiGameParser(String baseUrl, HtmlDivision game) {
        super(baseUrl, game);
    }

    @Override
    protected boolean hasSpecificPlatformErrors(String description) {
        return false;
    }

    @Override
    protected String cleanName(String name) {
        String result = name.replace("Juego Wii", "");
        result = result.replace("Wii", "");
        result = result.replace("WII", "");

        return result.trim();
    }

}
