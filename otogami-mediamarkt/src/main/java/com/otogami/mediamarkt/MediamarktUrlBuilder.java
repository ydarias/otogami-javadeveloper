package com.otogami.mediamarkt;

import com.otogami.core.model.Platform;

import java.util.HashMap;
import java.util.Map;

public class MediamarktUrlBuilder {

    public static final String BASE_URL = "http://tiendas.mediamarkt.es";

    private static final Map<Platform, String> PLATFORM_URL = new HashMap<Platform, String>();
    static {
        PLATFORM_URL.put(Platform.ps3, "/juegos-ps3");
        PLATFORM_URL.put(Platform.xbox360, "/juegos-xbox-360");
        PLATFORM_URL.put(Platform.wii, "/juegos-nintendo-wii");
        PLATFORM_URL.put(Platform.ps4, "/ecommerce/categories/categories.cfm?id=10001596&languageid=1");
        PLATFORM_URL.put(Platform.xboxone, "/juegos-es");
        PLATFORM_URL.put(Platform.wiiu, "/juegos-wii-u");
        PLATFORM_URL.put(Platform.n3ds, "/juegos-3ds");
        PLATFORM_URL.put(Platform.psvita, "/juegos-ps-vita");
        PLATFORM_URL.put(Platform.pc, "/juegos-pc");
    };

    public static String getPlatformUrl(Platform platform) {
        return BASE_URL + PLATFORM_URL.get(platform);
    }

}
