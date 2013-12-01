package com.otogami.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VideogameController {

    @RequestMapping(value = "helloWorld", method = RequestMethod.GET)
    public @ResponseBody String helloWorld() {
        return "Hello world";
    }

}
