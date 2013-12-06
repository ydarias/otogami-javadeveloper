package com.otogami.server.facade;

import static org.mockito.Mockito.*;

import com.otogami.server.dao.VideogameDao;
import com.otogami.server.model.VideogameEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VideogameFacadeTestCase {

    @Mock private VideogameDao videogameDao;

    @Mock private VideogameMapper videogameMapper;

    private VideogameFacade videogameFacade;

    @Before
    public void setup() {
        videogameFacade = new VideogameFacade(videogameDao, videogameMapper);
    }

    @Test
    public void shouldMapNewDataToVideogameBeforeSaveOrUpdate() {
        VideogameEntity sourceGame = buildMockGame();
        VideogameEntity storedGame = new VideogameEntity();

        when(videogameDao.findByStoreGameId("1", "2")).thenReturn(storedGame);

        videogameFacade.txUpdate("1", sourceGame);

        InOrder inOrder = inOrder(videogameDao, videogameMapper);

        inOrder.verify(videogameMapper).updateFields(storedGame, sourceGame);
        inOrder.verify(videogameDao).saveOrUpdate(storedGame);
    }

    @Test
    public void shouldCreateNewInstanceWithVideogameDoesNotExists() {
        VideogameEntity sourceGame = buildMockGame();

        when(videogameDao.findByStoreGameId("1", "2")).thenReturn(null);

        videogameFacade.txUpdate("1", sourceGame);

        verify(videogameMapper).newInstance(sourceGame);
    }

    private VideogameEntity buildMockGame() {
        VideogameEntity game = new VideogameEntity();
        game.setStoreGameId("2");

        return game;
    }

}
