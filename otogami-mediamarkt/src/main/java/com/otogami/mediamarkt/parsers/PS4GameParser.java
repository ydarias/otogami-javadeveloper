package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;

public class PS4GameParser extends GameParser {

    public PS4GameParser(String baseUrl, HtmlDivision game) {
        super(baseUrl, game);
    }

    @Override
    protected boolean hasSpecificPlatformErrors(String description) {
        return false;
    }

    @Override
    protected String cleanName(String name) {
        String result = name.replace("PS4", "");

        return result.trim();
    }

}
