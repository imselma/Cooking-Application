package ba.edu.ibu.CookingApp.rest.controllers;


import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recipes")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    /*@GetMapping
    public List<User> findAll(){ return userService.findAll();}

    @GetMapping("/{id")
    public User findById(@PathVariable int id){ return userService.findById(id);}*/

    @GetMapping("/send-to-all")
    public String sendEmailToAllUsers(@RequestParam String message) {
        return userService.sendEmailToAllUsers(message);
    }

}
