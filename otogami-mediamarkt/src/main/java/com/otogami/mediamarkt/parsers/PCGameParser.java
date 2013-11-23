package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.otogami.core.model.Platform;

public class PCGameParser extends GameParser {

    public PCGameParser(String platformBaseUrl, HtmlDivision game) {
        super(platformBaseUrl, game);
    }

    @Override
    protected boolean hasSpecificPlatformErrors(String description) {
        if (containsString(description, "Juego Xbox 360", "Juego PS3"))
            return true;

        return false;
    }

    @Override
    protected String cleanName(String name) {
        String result = cleanString(name, "Juego PC");

        if (result.startsWith("PC "))
            result = result.substring(3);

        return result.trim();
    }

    @Override
    protected Platform getPlatform() {
        return Platform.pc;
    }

}
