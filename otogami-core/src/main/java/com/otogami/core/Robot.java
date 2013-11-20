package com.otogami.core;

import java.util.Collection;

import com.otogami.core.model.Platform;
import com.otogami.core.model.Videogame;

public interface Robot {

	Collection<Videogame> getVideogamesOnPlatform(Platform platform);
	
}
