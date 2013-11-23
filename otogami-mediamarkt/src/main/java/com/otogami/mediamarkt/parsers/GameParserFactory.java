package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.otogami.core.model.Platform;

public class GameParserFactory {

    public static GameParser buildInstance(Platform platform, String platformBaseUrl, HtmlDivision game) {
        if (Platform.ps3.equals(platform))
            return new PS3GameParser(platformBaseUrl, game);
        if (Platform.xbox360.equals(platform))
            return new Xbox360GameParser(platformBaseUrl, game);
        if (Platform.wii.equals(platform))
            return new WiiGameParser(platformBaseUrl, game);
        if (Platform.ps4.equals(platform))
            return new PS4GameParser(platformBaseUrl, game);

        return null;
    }

}
