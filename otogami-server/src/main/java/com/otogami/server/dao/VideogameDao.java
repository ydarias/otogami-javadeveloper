package com.otogami.server.dao;

import java.util.List;

import com.otogami.server.model.VideogameEntity;

public interface VideogameDao {

	VideogameEntity findById(Long id);
	
	VideogameEntity findByStoreGameId(String id);
	
	List<VideogameEntity> findByPlatform(String platform);
	
	//TODO: Add the necessary methods to solve the problem...
	
}
