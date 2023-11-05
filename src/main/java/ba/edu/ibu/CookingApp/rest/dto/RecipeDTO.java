package ba.edu.ibu.CookingApp.rest.dto;

import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.model.enums.RecipeRestriction;

public class RecipeDTO {

    private String id;
    private String recipe;
    private String steps;
    private String ingredients;
    private Double cookingTime;
    private RecipeRestriction restriction;


    public RecipeDTO(Recipe recipe){

        this.id = recipe.getId();
        this.recipe = "Name: " + recipe.getName() + " Description: " + recipe.getDescription();
        this.steps = recipe.getSteps();
        this.ingredients = recipe.getIngredients();
        this.cookingTime = recipe.getCookingTime();
        this.restriction = recipe.getRestriction();
    }

    public String getId() { return id;}
    public void setId(String id) { this.id = id;}

    public String getRecipe() { return recipe;}
    public void setRecipe(String recipe) { this.recipe = recipe;}


    public String getSteps() { return steps;}
    public void setSteps(String steps) { this.steps = steps;}

    public String getIngredients() { return ingredients;}
    public void setIngredients(String ingredients) { this.ingredients = ingredients;}

    public Double getCookingTime() { return cookingTime;}
    public void setCookingTime(Double cookingTime) { this.cookingTime = cookingTime;}

    public RecipeRestriction getRestriction() { return restriction;}
    public void setRestriction(RecipeRestriction restriction) { this.restriction = restriction;}

}
