package com.otogami.server.dao;

import java.util.List;

import com.otogami.server.model.VideogameEntity;

public interface VideogameDao {

	VideogameEntity findById(Long id);

    VideogameEntity findByStoreGameId(String storeId, String storeGameId);
	
	List<VideogameEntity> findByPlatform(String platform);

    VideogameEntity saveOrUpdate(VideogameEntity videogame);

    //TODO: Add the necessary methods to solve the problem...
	
}
