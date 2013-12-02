package com.otogami.server.facade;

import com.otogami.server.dao.VideogameDao;
import com.otogami.server.model.VideogameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideogameFacade {

    private VideogameDao videogameDao;

    @Autowired
    public VideogameFacade(VideogameDao videogameDao) {
        this.videogameDao = videogameDao;
    }

    public void txUpdate(String storeId, VideogameEntity videogame) {
        VideogameEntity storedVideogame = videogameDao.findByStoreGameId(storeId, videogame.getStoreGameId());
    }

}
