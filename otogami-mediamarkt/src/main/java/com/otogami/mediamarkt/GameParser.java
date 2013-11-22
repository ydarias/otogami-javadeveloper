package com.otogami.mediamarkt;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import org.apache.commons.lang.StringUtils;

public class GameParser {

    private HtmlDivision game;

    private String baseUrl;

    public GameParser(String baseUrl, HtmlDivision game) {
        this.baseUrl = baseUrl;
        this.game = game;
    }

    public String getTitle() {
        HtmlAnchor anchor = game.getFirstByXPath(".//a[@class='productName product1Name']");
        String name = anchor.getTextContent();

        return cleanName(name);
    }

    public String getUrl() {
        HtmlAnchor anchor = game.getFirstByXPath(".//a[@class='productName product1Name']");
        return baseUrl + anchor.getHrefAttribute();
    }

    private String cleanName(String name) {
        String result = name;

        result = result.replace("Juego PS3", "");
        result = StringUtils.trim(result);

        return result;
    }

}
