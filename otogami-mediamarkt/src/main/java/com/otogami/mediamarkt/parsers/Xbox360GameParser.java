package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import org.apache.commons.lang.StringUtils;

public class Xbox360GameParser extends GameParser {

    public Xbox360GameParser(String baseUrl, HtmlDivision game) {
        super(baseUrl, game);
    }

    @Override
    protected boolean isPlatformGame(String description) {
        if (description.toUpperCase().contains("JUEGO XBOX 360"))
            return true;

        if (description.toUpperCase().contains("JUEGO X360"))
            return true;

        if (description.toUpperCase().contains("JUEGO XBOX ONE - XBOX 360"))
            return true;

        return false;
    }

    protected  String cleanName(String name) {
        String result = name;

        result = result.replace("Combo Xbox One - Xbox 360,", "");
        result = result.replace("Juego Xbox360", "");
        result = result.replace("Juego Xbox 360", "");
        result = result.replace("Juego XBox 360", "");
        result = result.replace("Juego XBOX 360", "");
        result = result.replace("Xbox 360", "");
        result = result.replace("XBox 360", "");
        result = result.replace("Xobx 360", "");
        result = StringUtils.trim(result);

        return result;
    }

}
