package ba.edu.ibu.CookingApp.rest.dto;

import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.model.enums.UserType;


//Data that will be requested to input from the user.
public class UserRequestDTO {

    private String email;
    private String password;
    private String username;
    private String name;
    private String surname;
    private UserType userType;

    public UserRequestDTO() {}

    public UserRequestDTO(User user){

        this.email = user.getEmail();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.userType = user.getUserType();

    }

    public User toEntity() {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        user.setName(name);
        user.setSurname(surname);
        user.setUserType(userType);

        return user;
    }
    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password;}
    public void setPassword(String password) { this.password = password; }

    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username; }

    public String getName() { return name;}
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname;}
    public void setSurname(String surname) { this.surname = surname; }

    public UserType getUserType() {
        return userType;
    }
    public void setUserType(UserType userType) {this.userType = userType; }
}
