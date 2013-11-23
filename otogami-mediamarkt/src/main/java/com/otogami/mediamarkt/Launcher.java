package com.otogami.mediamarkt;

import com.otogami.core.Robot;
import com.otogami.core.model.Platform;
import com.otogami.core.model.Videogame;

import java.util.Collection;

public class Launcher {

    public static void main(String [] args) {
        Robot robot = new MediamarktRobot();
        Collection<Videogame> videogames = robot.getVideogamesOnPlatform(Platform.xboxone);
        for (Videogame videogame : videogames)
            System.out.println(print(videogame));
    }

    private static String print(Videogame videogame) {
        StringBuffer buffer = new StringBuffer();

        buffer.append("Videogame {\n");
        buffer.append("\tTitle: " + videogame.getTitle() + "\n");
        buffer.append("\tPlatform: " + videogame.getPlatform() + "\n");
        buffer.append("\tWeb: " + videogame.getUrl() + "\n");
        buffer.append("\tPrice: " + videogame.getPrice() + " €\n");
        buffer.append("\tAvailability: " + videogame.getAvailability() + "\n}");

        return buffer.toString();
    };

}
