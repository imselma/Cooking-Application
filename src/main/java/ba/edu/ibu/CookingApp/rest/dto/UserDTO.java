package ba.edu.ibu.CookingApp.rest.dto;


import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.model.enums.UserType;

//Data that will be only displayed to the user
public class UserDTO {

    private String email;
    private String username;
    private String name;
    private UserType userType;
   // private List<Recipe> authorizedRecipes;

    public UserDTO(User user){

        this.email = user.getEmail();
        this.username = user.getUsername();
        this.name = user.getName();
        this.userType = user.getUserType();
        //this.authorizedRecipes = user.getAuthorizedRecipes();
    }

    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}

    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username;}
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {this.userType = userType;}

   // public List<Recipe> getAuthorizedRecipes() { return authorizedRecipes;}
   // public void setAuthorizedRecipes(List<Recipe> authorizedRecipes) { this.authorizedRecipes = authorizedRecipes;}
}
