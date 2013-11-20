package com.otogami.mediamarkt;

import com.otogami.core.Robot;
import com.otogami.core.model.Platform;

public class Launcher {

    public static void main(String [] args) {
        Robot robot = new MediamarktRobot();
        robot.getVideogamesOnPlatform(Platform.ps3);
    }

}
