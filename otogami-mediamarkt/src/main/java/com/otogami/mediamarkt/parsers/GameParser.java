package com.otogami.mediamarkt.parsers;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.otogami.core.model.Availability;
import com.otogami.core.model.Platform;
import com.otogami.core.model.Videogame;
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
        String description = descriptionDiv.getTextContent();

        if(containsString(description.toUpperCase(), "GUÍA", "GUIA", "ACCESORIO"))
            return false;

        if (hasSpecificPlatformErrors(description))
            return false;

        return true;
    }

    public Videogame buildVideogameInstance() {
        Videogame videogame = new Videogame();

        videogame.setPlatform(getPlatform());
        videogame.setTitle(getTitle());
        videogame.setUrl(getUrl());
        videogame.setPrice(getPrice());
        videogame.setAvailability(getAvailability());

        return videogame;
    }

    protected abstract boolean hasSpecificPlatformErrors(String description);

    protected abstract String cleanName(String name);

    protected abstract Platform getPlatform();

    protected String getTitle() {
        HtmlAnchor titleAnchor = game.getFirstByXPath(".//a[@class='productName product1Name']");
        String name = titleAnchor.getTextContent().replace("Pre-Order", "");

        return cleanName(name);
    }

    protected String getUrl() {
        HtmlAnchor urlAnchor = game.getFirstByXPath(".//a[@class='productName product1Name']");

        return baseUrl + urlAnchor.getHrefAttribute();
    }

    protected BigDecimal getPrice() {
        HtmlImage priceImage = game.getFirstByXPath(".//div[@class='productPrices']/img");
        if (priceImage == null)
            return new BigDecimal("0.00");
        String price = priceImage.getAltAttribute().replace("€", "");

        return new BigDecimal(price);
    }

    protected Availability getAvailability() {
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

    protected String cleanString(String input, String... targets) {
        String result = input;
        for (String target : targets)
            result = result.replace(target, "");

        return result;
    }

    protected boolean containsString(String input, String... targets) {
        for (String target : targets)
            if (input.contains(target))
                return true;

        return false;
    }

}
