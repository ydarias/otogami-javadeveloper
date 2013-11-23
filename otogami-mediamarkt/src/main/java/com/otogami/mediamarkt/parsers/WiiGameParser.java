package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.otogami.core.model.Platform;

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
        String result = cleanString(name, "Juego Wii", "Wii", "WII");

        return result.trim();
    }

    @Override
    protected Platform getPlatform() {
        return Platform.wii;
    }

}
