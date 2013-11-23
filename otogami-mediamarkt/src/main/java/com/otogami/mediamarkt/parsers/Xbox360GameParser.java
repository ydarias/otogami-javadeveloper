package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import org.apache.commons.lang.StringUtils;

public class Xbox360GameParser extends GameParser {

    public Xbox360GameParser(String baseUrl, HtmlDivision game) {
        super(baseUrl, game);
    }

    @Override
    protected boolean isPlatformGame(String description) {
        if (description.contains("Juego Xbox 360"))
            return true;

        return false;
    }

    protected  String cleanName(String name) {
        String result = name;

        result = result.replace("Juego Xbox360", "");
        result = StringUtils.trim(result);

        return result;
    }

}
