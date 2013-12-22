package com.otogami.server.facade;

import org.apache.commons.lang.StringUtils;

public class VideogameSearchSpecification {

    private String title;

    private String platform;

    private boolean available;

    private boolean minorPrice;

    public boolean hasTitle() {
        return StringUtils.isNotBlank(title);
    }
    public boolean hasPlatform() {
        return StringUtils.isNotBlank(platform);
    }

    public String getTitle() {
        if (title == null)
            return "";
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        if (platform == null)
            return "";
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isMinorPrice() {
        return minorPrice;
    }

    public void setMinorPrice(boolean minorPrice) {
        this.minorPrice = minorPrice;
    }

}
