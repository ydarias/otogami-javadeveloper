package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;

public class WiiUGameParser extends GameParser {

    public WiiUGameParser(String platformBaseUrl, HtmlDivision game) {
        super(platformBaseUrl, game);
    }

    @Override
    protected String cleanName(String name) {
        String result = name.replace("Wii U", "");
        result = result.replace("WII U", "");

        return result.trim();
    }

}
