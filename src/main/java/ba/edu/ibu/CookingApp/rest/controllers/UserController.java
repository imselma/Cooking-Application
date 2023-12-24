package ba.edu.ibu.CookingApp.rest.controllers;


import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.service.UserService;
import ba.edu.ibu.CookingApp.rest.dto.UserDTO;
import ba.edu.ibu.CookingApp.rest.dto.UserRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@SecurityRequirement(name = "JWT Security")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    //Endpoint for getting all users
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    //Endpoint for getting users by Id
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    //Endpoint for getting users by full name
    @RequestMapping(method = RequestMethod.GET, path = "/byname")
    @PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<UserDTO> getUserByFullName(@RequestParam("name") String name, @RequestParam("surname") String surname){ //I used @RequestParam to access data from query parameters
        return ResponseEntity.ok(userService.getUserByName(name));
    }

    /*//Endpoint for adding user
    @RequestMapping(method = RequestMethod.POST, path = "/addUser")
    public ResponseEntity<UserDTO> register(@RequestBody UserRequestDTO user){
        return ResponseEntity.ok(userService.addUser(user));
    }*/

    //Endpoint for updating user
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserRequestDTO user){ //For updating I have to proceed the id and userRequestDTO parameter
        return ResponseEntity.ok(userService.updateUser(id,user));
    }

    //Endpoint for deleting user
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //When deleted, this occures to indicate that the operation is completed.

    }
}
