package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.otogami.core.model.Platform;

public class Xbox360GameParser extends GameParser {

    public Xbox360GameParser(String baseUrl, HtmlDivision game) {
        super(baseUrl, game);
    }

    @Override
    protected boolean hasSpecificPlatformErrors(String description) {
        return false;
    }

    protected  String cleanName(String name) {
        String result = cleanString(name,
                "Combo Xbox One - Xbox 360,",
                "Juego Xbox360",
                "Juego Xbox 360",
                "Juego XBox 360",
                "Juego XBOX 360",
                "Xbox 360",
                "XBox 360",
                "Xobx 360");

        return result.trim();
    }

    @Override
    protected Platform getPlatform() {
        return Platform.xbox360;
    }

}
