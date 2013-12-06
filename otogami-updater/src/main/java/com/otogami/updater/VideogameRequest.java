package com.otogami.updater;

import com.otogami.core.model.Videogame;

import java.math.BigDecimal;

public class VideogameRequest {

    private String storeGameId;

    private String title;

    private String platform;

    private String url;

    private String availability;

    private BigDecimal price;

    private VideogameRequest() {}

    public VideogameRequest(Videogame videogame) {
        this.storeGameId = videogame.getId();
        this.title = videogame.getTitle();
        this.platform = videogame.getPlatform().name();
        this.url = videogame.getUrl();
        this.availability = videogame.getAvailability().name();
        this.price = videogame.getPrice();
    }

    public String getStoreGameId() {
        return storeGameId;
    }

    public void setStoreGameId(String storeGameId) {
        this.storeGameId = storeGameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}