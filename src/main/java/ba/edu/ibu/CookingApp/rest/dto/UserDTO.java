package ba.edu.ibu.CookingApp.rest.dto;


import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.model.enums.UserType;

import java.util.List;

//Data that will be only displayed to the user
public class UserDTO {

    private String email;
    private String username;
    private String name;
    private String surname;
    private UserType userType;
    private List<Recipe> recipes;

    public UserDTO(User user){

        this.email = user.getEmail();
        this.username = user.getUsername();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.userType = user.getUserType();
        this.recipes = user.getRecipes();
    }

    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}

    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username;}
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getSurname() { return surname;}
    public void setSurname(String surname) { this.surname = surname;}

    public UserType getUserType() {
        return userType;
    }
    public void setUserType(UserType userType) {this.userType = userType;}

    public List<Recipe> getRecipes() { return recipes;}
    public void setRecipes(List<Recipe> recipes) { this.recipes = recipes;}
}
