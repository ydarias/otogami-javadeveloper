package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.otogami.core.model.Platform;

public class Nintendo3DSGameParser extends GameParser {

    public Nintendo3DSGameParser(String platformBaseUrl, HtmlDivision game) {
        super(platformBaseUrl, game);
    }

    @Override
    protected boolean hasSpecificPlatformErrors(String description) {
        return false;
    }

    @Override
    protected String cleanName(String name) {
        String result = cleanString(name, "Juego Nintendo", "Juego DSi", "3DS", "3SD");

        // there are words with ds for example words, so needs to check the start :-)
        if (result.startsWith("DS "))
            result = result.substring(3);

        return result.trim();
    }

    @Override
    protected Platform getPlatform() {
        return Platform.n3ds;
    }

}
