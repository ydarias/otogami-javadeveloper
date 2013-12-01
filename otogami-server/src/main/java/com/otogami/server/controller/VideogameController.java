package com.otogami.server.controller;

import com.otogami.server.facade.VideogameFacade;
import com.otogami.server.model.VideogameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VideogameController {

    private VideogameFacade videogameFacade;

    @Autowired
    public VideogameController(VideogameFacade videogameFacade) {
        this.videogameFacade = videogameFacade;
    }

    @RequestMapping(value = "helloWorld", method = RequestMethod.GET)
    public @ResponseBody String helloWorld() {
        return "Hello world";
    }

    @RequestMapping(value = "update/{storeId}", method = RequestMethod.POST)
    public @ResponseBody String updateVideogames(Long storeId, @RequestBody List<VideogameEntity> videogames) {

        for (VideogameEntity videogame : videogames)
                videogameFacade.txUpdate(videogame);

        return "OK";
    }

}
