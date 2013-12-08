package com.otogami.server.facade;

import com.otogami.server.dao.VideogameDao;
import com.otogami.server.model.VideogameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VideogameFacade {

    private VideogameDao videogameDao;

    private VideogameMapper videogameMapper;

    public VideogameFacade() {}

    @Autowired
    public VideogameFacade(VideogameDao videogameDao, VideogameMapper videogameMapper) {
        this.videogameDao = videogameDao;
        this.videogameMapper = videogameMapper;
    }

    public void txUpdate(String storeId, VideogameEntity videogame) {
        videogame.setStoreId(storeId);

        VideogameEntity storedVideogame = videogameDao.findByStoreGameId(storeId, videogame.getStoreGameId());
        if (storedVideogame == null)
            storedVideogame = videogameMapper.newInstance(videogame);
        else
            videogameMapper.updateFields(storedVideogame, videogame);

        videogameDao.saveOrUpdate(storedVideogame);
    }

    public List<VideogameEntity> getVideogames(VideogameSearchSpecification searchSpecification) {
        return videogameDao.find(searchSpecification);
    }

    public List<VideogameEntity> getVideogamesByPlatform(String platformId) {
        return videogameDao.findByPlatform(platformId);
    }

}
