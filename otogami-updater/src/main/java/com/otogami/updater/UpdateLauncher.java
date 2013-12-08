package com.otogami.updater;


import com.otogami.core.model.Platform;
import com.otogami.core.model.Videogame;
import com.otogami.mediamarkt.MediamarktRobot;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

public class UpdateLauncher {

	public static void main(String[] args) {
        MediamarktRobot robot = new MediamarktRobot();

        Collection<Videogame> videogames = new ArrayList<Videogame>();
        videogames.addAll(robot.getVideogamesOnPlatform(Platform.ps3));
        videogames.addAll(robot.getVideogamesOnPlatform(Platform.ps4));
        videogames.addAll(robot.getVideogamesOnPlatform(Platform.psvita));
        videogames.addAll(robot.getVideogamesOnPlatform(Platform.xbox360));
        videogames.addAll(robot.getVideogamesOnPlatform(Platform.xboxone));
        videogames.addAll(robot.getVideogamesOnPlatform(Platform.n3ds));
        videogames.addAll(robot.getVideogamesOnPlatform(Platform.pc));
        videogames.addAll(robot.getVideogamesOnPlatform(Platform.wii));
        videogames.addAll(robot.getVideogamesOnPlatform(Platform.wiiu));

        String videogamesRequestJSON = transformToVideogamesRequestJSON(videogames);

        sendVideogamesToServer(videogamesRequestJSON);
    }

    private static void sendVideogamesToServer(String videogamesRequestJSON) {
        HttpClient client = new DefaultHttpClient();
        try {
            HttpPost post = new HttpPost("http://localhost:8080/otogami/api/update/1");
            post.setHeader("Content-Type", "application/json");
            post.setEntity(new StringEntity(videogamesRequestJSON, "UTF-8"));

            client.execute(post);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClientProtocolException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private static String transformToVideogamesRequestJSON(Collection<Videogame> videogames) {
        ObjectMapper mapper = new ObjectMapper();

        ArrayList<VideogameRequest> requestBody = new ArrayList<VideogameRequest>();
        for (Videogame videogame : videogames)
            requestBody.add(new VideogameRequest(videogame));

        try {
            return mapper.writeValueAsString(requestBody);
        } catch (IOException e) {
            return "[]";
        }
    }

}

