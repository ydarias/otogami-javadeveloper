package com.otogami.server.facade;

import static org.mockito.Mockito.*;

import com.otogami.server.dao.VideogameDao;
import com.otogami.server.model.VideogameEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VideogameFacadeTestCase {

    @Mock private VideogameDao videogameDao;

    @Test
    public void shouldTryToGetVideogameFromDAO() {
        VideogameFacade videogameFacade = new VideogameFacade(videogameDao);

        VideogameEntity assassinsCreed = new VideogameEntity();
        assassinsCreed.setStoreGameId("2");

        videogameFacade.txUpdate("1", assassinsCreed);

        verify(videogameDao, times(1)).findByStoreGameId("1", "2");
    }

}
