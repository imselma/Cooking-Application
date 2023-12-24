package ba.edu.ibu.CookingApp.rest.dto;

import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.model.Review;

public class ReviewRequestDTO {
    private String userName;
    private String userSurname;
    private Recipe recipe;
    private String comment;

    public ReviewRequestDTO(){}
    public ReviewRequestDTO(Review review, String userName, String userSurname){
        this.userName = userName;
        this.userSurname = userSurname;
        this.recipe = review.getRecipe();
        this.comment = review.getComment();
    }

    public Review toEntity(){
        Review review = new Review();
        this.setUserName(userName);
        review.setRecipe(recipe);
        review.setComment(comment);

        return review;
    }

    public String getUserName() {return userName;}
    public void setUserName (String userName) {this.userName = userName;}

    public String getUserSurname() {return userSurname;}
    public void setUserSurname (String userSurname) {this.userSurname = userSurname;}

    public Recipe getRecipe() {return recipe;}
    public void setRecipe (Recipe recipe) {this.recipe = recipe;}

    public String getComment() {return comment;}
    public void setComment (String comment) {this.comment = comment;}


}
