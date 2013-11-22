package com.otogami.mediamarkt;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;

public class GameParser {

    private HtmlDivision game;

    private String baseUrl;

    public GameParser(String baseUrl, HtmlDivision game) {
        this.baseUrl = baseUrl;
        this.game = game;
    }
    public boolean isGame() {
        HtmlDivision description = game.getFirstByXPath(".//div[@class='product9ShortDescription']");
        String cleanDescription = StringUtils.upperCase(description.getTextContent());

        return cleanDescription.contains("JUEGO PS3");
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

    public BigDecimal getPrice() {
        HtmlImage image = game.getFirstByXPath(".//div[@class='productPrices']/img");
        String price = image.getAltAttribute().replace("€", "");

        return new BigDecimal(price);
    }

    private String cleanName(String name) {
        String result = name;

        result = result.replace("Juego PS3", "");
        result = StringUtils.trim(result);

        return result;
    }

}
