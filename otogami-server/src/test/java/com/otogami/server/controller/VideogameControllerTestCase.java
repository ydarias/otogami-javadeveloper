package com.otogami.server.controller;

import static org.mockito.Mockito.*;

import com.otogami.server.facade.VideogameFacade;
import com.otogami.server.model.VideogameEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class VideogameControllerTestCase {

    @Mock private VideogameFacade videogameFacade;

    @Test
    public void shouldCallVideogameFacadeForAllVideogames() {
        VideogameController videogameController = new VideogameController(videogameFacade);

        List<VideogameEntity> videogames = new ArrayList<VideogameEntity>();
        videogames.add(new VideogameEntity());
        videogames.add(new VideogameEntity());
        videogames.add(new VideogameEntity());

        videogameController.updateVideogames("1", videogames);

        verify(videogameFacade, times(3)).txUpdate(anyString(), (VideogameEntity) anyObject());
    }

}
