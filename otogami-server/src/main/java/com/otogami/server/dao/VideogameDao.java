package com.otogami.server.dao;

import java.util.List;

import com.otogami.server.facade.VideogameSearchSpecification;
import com.otogami.server.model.VideogameEntity;

public interface VideogameDao {

    List<VideogameEntity> find(VideogameSearchSpecification searchSpecification);

    VideogameEntity findById(Long id);

    VideogameEntity findByStoreGameId(String storeId, String storeGameId);
	
	List<VideogameEntity> findByPlatform(String platform);

    VideogameEntity saveOrUpdate(VideogameEntity videogame);

}
