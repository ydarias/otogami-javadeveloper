package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;

public class PCGameParser extends GameParser {

    public PCGameParser(String platformBaseUrl, HtmlDivision game) {
        super(platformBaseUrl, game);
    }

    @Override
    protected boolean hasSpecificPlatformErrors(String description) {
        if (description.contains("Juego Xbox 360"))
            return true;

        if (description.contains("Juego PS3"))
            return true;

        return false;
    }

    @Override
    protected String cleanName(String name) {
        String result = name.replace("Juego PC", "");

        if (result.startsWith("PC "))
            result = result.substring(3);

        return result.trim();
    }

}
