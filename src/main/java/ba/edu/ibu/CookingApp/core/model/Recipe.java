package ba.edu.ibu.CookingApp.core.model;

import ba.edu.ibu.CookingApp.core.model.enums.RecipeRestriction;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Recipe {
    @Id
    private String id;
    private String name;
    private String description;
    private String steps;
    private List<Ingredient> ingredients;
    private Double cookingTime;
    private RecipeRestriction restriction;
    private User user; //To know who is the author
    private Review[] reviews; //To know all the reviews which a ceratin recipe has.

    public String getId() { return id;}
    public void setId(String id) { this.id = id;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public  String getDescription() { return description;}
    public void setDescription(String description) { this.description = description;}

    public String getSteps() { return steps;}
    public void setSteps(String steps) { this.steps = steps;}

    public List<Ingredient> getIngredients() { return ingredients;}
    public void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients;}

    public Double getCookingTime() { return cookingTime;}
    public void setCookingTime(Double cookingTime) { this.cookingTime = cookingTime;}

    public RecipeRestriction getRestriction() { return restriction;}
    public void setRestriction(RecipeRestriction restriction) { this.restriction = restriction;}

    public Review[] getReviews() { return reviews;}
    public void setReview(Review[] reviews) { this.reviews = reviews;}

    public User getUser() { return user;}
    public void setUser (User user) { this.user = user;}

}