package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;

public class PS3GameParser extends GameParser {

    public PS3GameParser(String platformBaseUrl, HtmlDivision game) {
        super(platformBaseUrl, game);
    }

    @Override
    protected boolean isPlatformGame(String description) {
        String processedDescription = description.trim().toUpperCase();

        if (processedDescription.contains("JUEGO PS3"))
            return true;

        return false;
    }

    @Override
    protected String cleanName(String name) {
        String result = name.trim();

        result = result.replace("Juego PS3", "");
        result = result.replace("PS3 ", "");

        return result;
    }

}
