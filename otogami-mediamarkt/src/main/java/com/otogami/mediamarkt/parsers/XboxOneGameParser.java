package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;

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
        String result = name.replace("Xbox One", "");

        return result.trim();
    }

}
