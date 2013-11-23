package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import org.apache.commons.lang.StringUtils;

public class WiiGameParser extends GameParser {

    public WiiGameParser(String baseUrl, HtmlDivision game) {
        super(baseUrl, game);
    }

    @Override
    protected String cleanName(String name) {
        String result = name.replace("Juego Wii", "");
        result = result.replace("Wii", "");
        result = result.replace("WII", "");

        return result.trim();
    }

}
