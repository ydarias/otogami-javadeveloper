package com.otogami.server.facade;

import com.otogami.server.model.VideogameEntity;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VideogameMapperTestCase {

    @Test
    public void shouldCopyFromSourceToDestinatio() {
        VideogameEntity destinationGame = new VideogameEntity();
        VideogameEntity sourceGame = buildMockGame();
        VideogameMapper videogameMapper = new VideogameMapper();

        videogameMapper.updateFields(destinationGame, sourceGame);

        assertCorrectMapping(destinationGame, sourceGame);
    }

    @Test
    public void shouldCreateNewInstance() {
        VideogameEntity sourceGame = buildMockGame();
        VideogameMapper videogameMapper = new VideogameMapper();

        VideogameEntity destinationGame = videogameMapper.newInstance(sourceGame);

        assertCorrectMapping(destinationGame, sourceGame);
    }

    private VideogameEntity buildMockGame() {
        VideogameEntity sourceGame = new VideogameEntity();
        sourceGame.setAvailability("available");
        sourceGame.setId(1L);
        sourceGame.setPlatform("ps4");
        sourceGame.setPrice(new BigDecimal("12.75"));
        sourceGame.setStoreGameId("34");
        sourceGame.setTitle("Metal Gear Solid 4");
        sourceGame.setUrl("www.google.com");

        return sourceGame;
    }

    private void assertCorrectMapping(VideogameEntity destinationGame, VideogameEntity sourceGame) {
        assertEquals(sourceGame.getAvailability(), destinationGame.getAvailability());
        assertEquals(sourceGame.getPlatform(), destinationGame.getPlatform());
        assertEquals(sourceGame.getPrice(), destinationGame.getPrice());
        assertEquals(sourceGame.getStoreGameId(), destinationGame.getStoreGameId());
        assertEquals(sourceGame.getTitle(), destinationGame.getTitle());
        assertEquals(sourceGame.getUrl(), destinationGame.getUrl());
    }

}
