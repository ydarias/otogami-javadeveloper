package com.otogami.server.facade;

import com.otogami.server.model.VideogameEntity;

public class VideogameMapper {

    public void updateFields(VideogameEntity destinationGame, VideogameEntity sourceGame) {
        destinationGame.setAvailability(sourceGame.getAvailability());
        destinationGame.setId(sourceGame.getId());
        destinationGame.setPlatform(sourceGame.getPlatform());
        destinationGame.setPrice(sourceGame.getPrice());
        destinationGame.setStoreGameId(sourceGame.getStoreGameId());
        destinationGame.setStoreId(sourceGame.getStoreId());
        destinationGame.setTitle(sourceGame.getTitle());
        destinationGame.setUrl(sourceGame.getUrl());
    }

}
