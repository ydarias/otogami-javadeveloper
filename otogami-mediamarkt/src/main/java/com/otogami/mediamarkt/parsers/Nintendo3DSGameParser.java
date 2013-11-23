package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;

public class Nintendo3DSGameParser extends GameParser {

    public Nintendo3DSGameParser(String platformBaseUrl, HtmlDivision game) {
        super(platformBaseUrl, game);
    }

    @Override
    protected String cleanName(String name) {
        String result = name.replace("3DS", "");
        result = result.replace("3SD", "");

        // there are words with ds for example words, so needs to check the start :-)
        if (result.startsWith("DS"))
            result = result.substring(2);

        return result.trim();
    }

}
