package ba.edu.ibu.CookingApp.core.model;

import ba.edu.ibu.CookingApp.core.model.enums.UserType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document  // Class is related to a MongoDb collection of the same type.
public class User {

    @Id //Defining the primary key.
    private String id;
    private String email;
    private String password;
    private String username;
    private UserType userType;
    private String name;
    private String surname;


    public String getId() { return id;}
    public void setId(String id) { this.id = id; }

    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password;}
    public void setPassword(String password) { this.password = password; }

    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username; }

    public UserType getUserType() { return userType;}
    public void setUserType(UserType userType) { this.userType = userType; }

    public String getName() { return name;}
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname;}
    public void setSurname(String surname) { this.surname = surname; }

}