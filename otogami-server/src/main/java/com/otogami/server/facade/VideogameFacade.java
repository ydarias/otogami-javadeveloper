package com.otogami.server.facade;

import com.otogami.server.dao.VideogameDao;
import com.otogami.server.model.VideogameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideogameFacade {

    private VideogameDao videogameDao;

    private VideogameMapper videogameMapper;

    @Autowired
    public VideogameFacade(VideogameDao videogameDao, VideogameMapper videogameMapper) {
        this.videogameDao = videogameDao;
        this.videogameMapper = videogameMapper;
    }

    public void txUpdate(String storeId, VideogameEntity videogame) {
        VideogameEntity storedVideogame = videogameDao.findByStoreGameId(storeId, videogame.getStoreGameId());
        videogameMapper.updateFields(storedVideogame, videogame);
        videogameDao.saveOrUpdate(storedVideogame);
    }

}
