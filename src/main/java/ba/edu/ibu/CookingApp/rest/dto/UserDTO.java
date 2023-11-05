package ba.edu.ibu.CookingApp.rest.dto;


import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.model.enums.UserType;

//By displaying the instance of user model, but some of the atributes should not be shown, like password
public class UserDTO {

    private String id;
    private String email;
    private String username;
    private UserType userType;
    private String fullName;

    public UserDTO(User user){

        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.userType = user.getUserType();
        this.fullName = user.getName() + " " +user.getSurname();

    }

    public String getId() { return id;}
    public void setId(String id) { this.id = id; }

    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username; }

    public UserType getUserType() { return userType;}
    public void setUserType(UserType userType) { this.userType = userType; }

    public String getFullName() { return fullName;}
    public void setFullName(String fullName) { this.fullName = fullName; }


}
