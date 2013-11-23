package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;

public class PS3GameParser extends GameParser {

    public PS3GameParser(String platformBaseUrl, HtmlDivision game) {
        super(platformBaseUrl, game);
    }

    @Override
    protected String cleanName(String name) {
        String result = name.replace("Juego PS3", "");
        result = result.replace("PS3 ", "");

        return result.trim();
    }

}
