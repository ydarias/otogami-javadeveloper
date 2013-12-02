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
    public void shouldTryToGetVideogameFromDAO() {
        VideogameEntity splinterCell = buildSplinterCell();

        videogameFacade.txUpdate("1", splinterCell);

        verify(videogameDao, times(1)).findByStoreGameId("1", "2");
    }

    @Test
    public void shouldMapNewDataToVideogameBeforeSaveOrUpdate() {
        VideogameEntity splinterCell = buildSplinterCell();
        VideogameEntity storedGame = new VideogameEntity();

        when(videogameDao.findByStoreGameId("1", "2")).thenReturn(storedGame);

        videogameFacade.txUpdate("1", splinterCell);

        InOrder inOrder = inOrder(videogameDao, videogameMapper);

        inOrder.verify(videogameMapper).updateFields(storedGame, splinterCell);
        inOrder.verify(videogameDao).saveOrUpdate(storedGame);
    }

    private VideogameEntity buildSplinterCell() {
        VideogameEntity splinterCell = new VideogameEntity();
        splinterCell.setStoreGameId("2");

        return splinterCell;
    }

}
