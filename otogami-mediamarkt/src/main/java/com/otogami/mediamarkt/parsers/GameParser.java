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
        HtmlDivision descriptionDiv = game.getFirstByXPath(".//div[@class='product9ShortDescription']");
        String descriptionValue = descriptionDiv.getTextContent();

        if(descriptionValue.toUpperCase().contains("GUÍA") || descriptionValue.toUpperCase().contains("GUIA"))
            return false;

        if(descriptionValue.toUpperCase().contains("ACCESORIO"))
            return false;

        return true;
    }

    public String getTitle() {
        HtmlAnchor titleAnchor = game.getFirstByXPath(".//a[@class='productName product1Name']");
        String name = titleAnchor.getTextContent();
        name = name.replace("Pre-Order", "");

        return cleanName(name);
    }

    public String getUrl() {
        HtmlAnchor urlAnchor = game.getFirstByXPath(".//a[@class='productName product1Name']");

        return baseUrl + urlAnchor.getHrefAttribute();
    }

    public BigDecimal getPrice() {
        HtmlImage priceImage = game.getFirstByXPath(".//div[@class='productPrices']/img");
        if (priceImage == null)
            return new BigDecimal("0.00");
        String price = priceImage.getAltAttribute().replace("€", "");

        return new BigDecimal(price);
    }

    public Availability getAvailability() {
        HtmlDivision noStockDiv = game.getFirstByXPath(".//div[@class='categoryDSI_noStock']");
        if (noStockDiv != null)
            return Availability.OutofStock;

        HtmlDivision descriptionDiv = game.getFirstByXPath(".//div[@class='product9ShortDescription']");
        if (descriptionDiv.getTextContent().toUpperCase().contains("FECHA DE LANZAMIENTO"))
            return Availability.Preorder;

        HtmlAnchor titleAnchor = game.getFirstByXPath(".//a[@class='productName product1Name']");
        if (titleAnchor.getTextContent().toUpperCase().contains("PRE-ORDER"))
            return Availability.Preorder;

        return Availability.InStock;
    }

    protected abstract String cleanName(String name);

}
