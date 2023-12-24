package ba.edu.ibu.CookingApp.rest.dto;

import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.model.Review;
import ba.edu.ibu.CookingApp.core.model.User;

public class ReviewDTO {

    private User user;
    private Recipe recipe;
    private String comment;

    public ReviewDTO(Review review){
        this.user = review.getUser();
        this.recipe = review.getRecipe();
        this.comment = review.getComment();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
