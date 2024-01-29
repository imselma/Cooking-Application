package ba.edu.ibu.CookingApp.rest.dto;

import ba.edu.ibu.CookingApp.core.model.enums.UserType;

public class LoginDTO {
    private String jwt;
    private UserType userType;

    public LoginDTO(String jwt ) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
