package com.otogami.server.controller;

import com.otogami.server.facade.VideogameFacade;
import com.otogami.server.model.VideogameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VideogameController {

    private VideogameFacade videogameFacade;

    @Autowired
    public VideogameController(VideogameFacade videogameFacade) {
        this.videogameFacade = videogameFacade;
    }

    @RequestMapping(value = "update/{storeId}", method = RequestMethod.POST)
    public @ResponseBody String updateVideogames(@PathVariable String storeId, @RequestBody List<VideogameEntity> videogames) {
        for (VideogameEntity videogame : videogames)
            videogameFacade.txUpdate(storeId, videogame);

        return "OK";
    }

    @RequestMapping(value = "platform/{platformId}/games")
    public @ResponseBody List<VideogameEntity> getVideogamesByPlatform(@PathVariable String platformId) {
        return videogameFacade.getVideogamesByPlatform(platformId);
    }

}
