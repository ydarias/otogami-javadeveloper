package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.otogami.core.model.Availability;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;

public abstract class GameParser {

    protected HtmlDivision game;

    protected String baseUrl;

    public GameParser(String baseUrl, HtmlDivision game) {
        this.baseUrl = baseUrl;
        this.game = game;
    }
    public boolean isGame() {
        HtmlDivision description = game.getFirstByXPath(".//div[@class='product9ShortDescription']");

        String descriptionValue = description.getTextContent();

        if(descriptionValue.toUpperCase().contains("GUÍA") || descriptionValue.toUpperCase().contains("GUIA"))
            return false;

        if(descriptionValue.toUpperCase().contains("ACCESORIO"))
            return false;

        return true;
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
        if (image == null)
            return new BigDecimal("0.00");
        String price = image.getAltAttribute().replace("€", "");

        return new BigDecimal(price);
    }

    public Availability getAvailability() {
        HtmlDivision noStock = game.getFirstByXPath(".//div[@class='categoryDSI_noStock']");
        if (noStock != null)
            return Availability.OutofStock;

        return Availability.InStock;
    }

    protected abstract String cleanName(String name); /* {
        String result = name;

        result = result.replace("Juego PS3", "");
        result = result.replace("PS3 ", "");
        result = StringUtils.trim(result);

        return result;
    }                                                   */

}
