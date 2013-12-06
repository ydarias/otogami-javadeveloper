package com.otogami.server;

import static org.junit.Assert.*;

import com.otogami.server.controller.VideogameController;
import com.otogami.server.model.VideogameEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext*.xml")
@ActiveProfiles("test")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UpdateGamesTestCase {

    @Autowired
    VideogameController controller;

    @Transactional
    @Test
    public void shouldStoreGames() {
        List<VideogameEntity> sourceVideogames = new ArrayList<VideogameEntity>();
        sourceVideogames.add(buildLastOfUs());
        sourceVideogames.add(buildSplinterCell());

        assertEquals(0, controller.getVideogamesByPlatform("ps3").size());

        controller.updateVideogames("1", sourceVideogames);

        assertEquals(2, controller.getVideogamesByPlatform("ps3").size());
    }

    private VideogameEntity buildLastOfUs() {
        VideogameEntity videogame = new VideogameEntity();
        videogame.setTitle("Last of us");
        videogame.setStoreGameId("5");
        videogame.setPlatform("ps3");

        return videogame;
    }

    private VideogameEntity buildSplinterCell() {
        VideogameEntity videogame = new VideogameEntity();
        videogame.setTitle("Splinter cell: Blacklist");
        videogame.setStoreGameId("7");
        videogame.setPlatform("ps3");

        return videogame;
    }

}
