package ba.edu.ibu.CookingApp.rest.dto;

import ba.edu.ibu.CookingApp.core.model.Ingredient;
import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.model.enums.RecipeRestriction;

import java.util.List;

public class RecipeRequestDTO {
    private String name;
    private String description;
    private String steps;
    private List<String> ingredients;
    private Double cookingTime;
    private RecipeRestriction restriction;
    private String userId;

    public RecipeRequestDTO(){}

    public RecipeRequestDTO(Recipe recipe, List<String> ingredients, String user){

        this.name = recipe.getName();
        this.description = recipe.getDescription();
        this.steps = recipe.getSteps();
        this.ingredients=ingredients;
        this.cookingTime = recipe.getCookingTime();
        this.restriction = recipe.getRestriction();
        this.userId= user;
    }

    public Recipe toEntity() {

        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setDescription(description);
        recipe.setSteps(steps);
        recipe.setIngredients(ingredients);
        recipe.setCookingTime(cookingTime);
        recipe.setRestriction(restriction);
        this.setUserId(userId);
        return recipe;
    }


    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public  String getDescription() { return description;}
    public void setDescription(String description) { this.description = description;}

    public String getSteps() { return steps;}
    public void setSteps(String steps) { this.steps = steps;}

    public List<String> getIngredients() { return ingredients;}
    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients;}

    public Double getCookingTime() { return cookingTime;}
    public void setCookingTime(Double cookingTime) { this.cookingTime = cookingTime;}

    public RecipeRestriction getRestriction() { return restriction;}
    public void setRestriction(RecipeRestriction restriction) { this.restriction = restriction;}

    public String getUserId() { return userId;}
    public void setUserId(String userId) { this.userId = userId;}

}
