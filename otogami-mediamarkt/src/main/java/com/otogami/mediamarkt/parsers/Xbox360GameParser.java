package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;

public class Xbox360GameParser extends GameParser {

    public Xbox360GameParser(String baseUrl, HtmlDivision game) {
        super(baseUrl, game);
    }

    @Override
    protected boolean hasSpecificPlatformErrors(String description) {
        return false;
    }

    protected  String cleanName(String name) {
        String result = name.replace("Combo Xbox One - Xbox 360,", "");
        result = result.replace("Juego Xbox360", "");
        result = result.replace("Juego Xbox 360", "");
        result = result.replace("Juego XBox 360", "");
        result = result.replace("Juego XBOX 360", "");
        result = result.replace("Xbox 360", "");
        result = result.replace("XBox 360", "");
        result = result.replace("Xobx 360", "");

        return result.trim();
    }

}
