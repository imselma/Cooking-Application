package ba.edu.ibu.CookingApp.rest.dto;

import ba.edu.ibu.CookingApp.core.model.Ingredient;
import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.model.enums.RecipeRestriction;

import java.util.List;

public class RecipeDTO {

    //private String id;
    private String name;
    private String description;
    private String steps;
    private Double cookingTime;
    private RecipeRestriction restriction;
    private List<Ingredient> ingredients;
    private String username;
    private String surname;


    public RecipeDTO(Recipe recipe){

        this.name = recipe.getName();
        this.description = recipe.getDescription();
        this.steps = recipe.getSteps();
        this.ingredients = recipe.getIngredients();
        this.cookingTime = recipe.getCookingTime();
        this.restriction = recipe.getRestriction();
        this.username = recipe.getUser().getName();
        this.surname = recipe.getUser().getSurname();
    }

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getDescription() { return description;}
    public void setDescription(String description) { this.description = description;}

    public String getSteps() { return steps;}
    public void setSteps(String steps) { this.steps = steps;}

    public List<Ingredient> getIngredients() { return ingredients;}
    public void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients;}

    public Double getCookingTime() { return cookingTime;}
    public void setCookingTime(Double cookingTime) { this.cookingTime = cookingTime;}

    public RecipeRestriction getRestriction() { return restriction;}
    public void setRestriction(RecipeRestriction restriction) { this.restriction = restriction;}

    public String getUserName() { return username;}
    public void setUserName(String userName) { this.username = username;}

    public String getSurname() { return surname;}
    public void setSurname(String surname) { this.surname = surname;}


}
