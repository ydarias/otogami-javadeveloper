package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.otogami.core.model.Platform;

public class XboxOneGameParser extends GameParser {

    public XboxOneGameParser(String platformBaseUrl, HtmlDivision game) {
        super(platformBaseUrl, game);
    }

    @Override
    protected boolean hasSpecificPlatformErrors(String description) {
        return false;
    }

    @Override
    protected String cleanName(String name) {
        String result = cleanString(name, "Xbox One");

        return result.trim();
    }

    @Override
    protected Platform getPlatform() {
        return Platform.xboxone;
    }

}
