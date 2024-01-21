package ba.edu.ibu.CookingApp.core.service;

import ba.edu.ibu.CookingApp.rest.websockets.MainSocketHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NotificationService {

    private final MainSocketHandler mainSocketHandler;

    public NotificationService(MainSocketHandler mainSocketHandler){
        this.mainSocketHandler = mainSocketHandler;
    }

    //Broadcasting the message to all users
    public void broadcastMessage(String message) throws IOException {
        mainSocketHandler.broadcastMessage(message);
    }

    //Sending message to single user
    public void sendMessage(String userId, String message) throws IOException {
        mainSocketHandler.sendMessage(userId, message);
    }
}
