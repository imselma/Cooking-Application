package ba.edu.ibu.CookingApp.rest.websockets;

import ba.edu.ibu.CookingApp.core.exceptions.GeneralException;
import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.service.JwtService;
import ba.edu.ibu.CookingApp.core.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Component
public class MainSocketHandler implements WebSocketHandler {

    private final JwtService jwtService; //Only authenticated users will use the socket
    private final UserService userService;
    public Map<String, WebSocketSession> sessions = new HashMap<>(); //hash map of sessions( users that opened session)

    public MainSocketHandler(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        User user = getUser(session); //Extracts logged user from the session and adds him to the hash map
        if (user == null) {
            return;
        }

        sessions.put(user.getId(), session);
        System.out.println("Session created for the user " + user.getId() + " where the session id is " + session.getId());
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("Error happened " + session.getId() + " with reason ### " + exception.getMessage());
    } //Handles the errors if any occur in socket messaging


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("Connection closed for session " + session.getId() + " with status ### " + closeStatus.getReason());
    } //this method is called when the session is terminated


    @Override
    public boolean supportsPartialMessages() { //spliting large payload messages into smaller chunks (false by default)
        return false;
    }


    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String messageReceived = (String) message.getPayload();
        System.out.println("Message received: " + messageReceived);
    } //called every time a new message is recieved by the websocket


    private User getUser(WebSocketSession session) throws IOException {
        List<String> headers = session.getHandshakeHeaders().getOrEmpty("authorization"); //checking up for session headers in Authorization header that holds the JWT
        if (headers.size() == 0) {
            session.close();
            return null;
        }
        String jwt = headers.get(0).substring(7); //extracting the portion of JWT
        String userEmail = jwtService.extractUserName(jwt); //extracting the email using jwtService

        UserDetails userDetails = userService.userDetailsService().loadUserByUsername(userEmail);
        return (User) userDetails; //extracting the details about the user
    }

    public void broadcastMessage(String message) throws IOException {
        sessions.forEach((key, session) -> { //iterates to the hash map and sends the parameter message to all the users that are establishing a connection ( have a session)
            try {
                if (session.isOpen()) {
                    session.sendMessage(new TextMessage(message));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void sendMessage(String userId, String message) {
        WebSocketSession session = sessions.get(userId); //sending message to single user, after extracting him from the hash map by userId
        if (session == null) {
            return;
        }
        try {
            session.sendMessage(new TextMessage(message));
        } catch (IOException e) {
            throw new GeneralException(e);
        }
    }

}
