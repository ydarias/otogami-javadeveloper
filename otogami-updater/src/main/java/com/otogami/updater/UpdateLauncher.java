package com.otogami.updater;


import com.otogami.core.model.Platform;
import com.otogami.core.model.Videogame;
import com.otogami.mediamarkt.MediamarktRobot;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Collection;

public class UpdateLauncher {

	public static void main(String[] args) {
        MediamarktRobot robot = new MediamarktRobot();
        Collection<Videogame> videogames = robot.getVideogamesOnPlatform(Platform.xboxone);

        ObjectMapper mapper = new ObjectMapper();

        try {
            System.out.println(mapper.writeValueAsString(videogames));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
