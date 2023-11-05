package ba.edu.ibu.CookingApp.rest.dto;

import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.model.enums.RecipeRestriction;

public class RecipeRequestDTO {
    private String name;
    private String description;
    private String steps;
    private String ingredients;
    private Double cookingTime;
    private RecipeRestriction restriction;

    public RecipeRequestDTO(){}

    public RecipeRequestDTO(Recipe recipe){

        this.name = recipe.getName();
        this.description = recipe.getDescription();
        this.steps = recipe.getSteps();
        this.ingredients = recipe.getIngredients();
        this.cookingTime = recipe.getCookingTime();
        this.restriction = recipe.getRestriction();
    }

    public Recipe toEntity() {

        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setDescription(description);
        recipe.setSteps(steps);
        recipe.setIngredients(ingredients);
        recipe.setCookingTime(cookingTime);
        recipe.setRestriction(restriction);

        return recipe;
    }


    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public  String getDescription() { return description;}
    public void setDescription(String description) { this.description = description;}

    public String getSteps() { return steps;}
    public void setSteps(String steps) { this.steps = steps;}

    public String getIngredients() { return ingredients;}
    public void setIngredients(String ingredients) { this.ingredients = ingredients;}

    public Double getCookingTime() { return cookingTime;}
    public void setCookingTime(Double cookingTime) { this.cookingTime = cookingTime;}

    public RecipeRestriction getRestriction() { return restriction;}
    public void setRestriction(RecipeRestriction restriction) { this.restriction = restriction;}


}
