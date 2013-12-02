package com.otogami.server.dao;

import com.otogami.server.model.VideogameEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "videogameDao")
public class HibernateVideogameDao implements VideogameDao {
    @Override
    public VideogameEntity findById(Long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public VideogameEntity findByStoreGameId(String storeId, String storeGameId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<VideogameEntity> findByPlatform(String platform) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public VideogameEntity saveOrUpdate(VideogameEntity videogame) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
