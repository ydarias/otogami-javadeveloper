package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.otogami.core.model.Platform;

public class PS3GameParser extends GameParser {

    public PS3GameParser(String platformBaseUrl, HtmlDivision game) {
        super(platformBaseUrl, game);
    }

    @Override
    protected boolean hasSpecificPlatformErrors(String description) {
        return false;
    }

    @Override
    protected String cleanName(String name) {
        String result = cleanString(name, "Juego PS3", "PS3 ");

        return result.trim();
    }

    @Override
    protected Platform getPlatform() {
        return Platform.ps3;
    }

}
