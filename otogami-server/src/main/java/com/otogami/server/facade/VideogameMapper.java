package com.otogami.server.facade;

import com.otogami.server.model.VideogameEntity;
import org.springframework.stereotype.Component;

@Component
public class VideogameMapper {

    public void updateFields(VideogameEntity destinationGame, VideogameEntity sourceGame) {
        destinationGame.setAvailability(sourceGame.getAvailability());
        destinationGame.setPlatform(sourceGame.getPlatform());
        destinationGame.setPrice(sourceGame.getPrice());
        destinationGame.setStoreGameId(sourceGame.getStoreGameId());
        destinationGame.setStoreId(sourceGame.getStoreId());
        destinationGame.setTitle(sourceGame.getTitle());
        destinationGame.setUrl(sourceGame.getUrl());
    }

    public VideogameEntity newInstance(VideogameEntity sourceGame) {
        VideogameEntity destinationGame = new VideogameEntity();
        updateFields(destinationGame, sourceGame);

        return destinationGame;
    }
}
