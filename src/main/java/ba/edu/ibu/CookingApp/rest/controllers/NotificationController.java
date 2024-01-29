package ba.edu.ibu.CookingApp.rest.controllers;

import ba.edu.ibu.CookingApp.core.service.NotificationService;
import ba.edu.ibu.CookingApp.rest.dto.MessageDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api/notifications")
@SecurityRequirement(name = "JWT Security")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController( NotificationService notificationService){
        this.notificationService = notificationService;
    }

    //Endpoint for sending the message to all users
    @RequestMapping(path = "/broadcast", method = RequestMethod.POST)
    //@PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<Void> sendBroadcastMessage(@RequestBody MessageDTO message) throws IOException {

        System.out.println("The message is: " + message.getMessage());
        notificationService.broadcastMessage(message.getMessage());
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    //Endpoint for sending the message to single user
    @RequestMapping(path = "/send-to/{userId}", method = RequestMethod.POST)
    //@PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<Void> sendMessageToSingleUser(@PathVariable String userId, @RequestBody MessageDTO message) throws IOException {
        System.out.println("The message is: " + message.getMessage());
        notificationService.sendMessage(userId, message.getMessage());
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
