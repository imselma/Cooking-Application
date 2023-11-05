package ba.edu.ibu.CookingApp.core.service;

import ba.edu.ibu.CookingApp.core.exceptions.repository.ResourceNotFoundException;
import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.repository.RecipeRepository;
import ba.edu.ibu.CookingApp.rest.dto.RecipeDTO;
import ba.edu.ibu.CookingApp.rest.dto.RecipeRequestDTO;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;


    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    //Get all recipes
    public List<RecipeDTO> getRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();

        return recipes
                .stream() //returns one by one
                .map(RecipeDTO::new)
                .collect(toList());
    }

    //Get recipes by id
    public RecipeDTO getRecipeById (String id){
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isEmpty()) {
            throw new ResourceNotFoundException("The recipe does not exist.");
        }

        return new RecipeDTO(recipe.get());
    }

    //Get recipes by name
    public  RecipeDTO getRecipeByName (String name){
        Optional<Recipe> recipe = recipeRepository.findByName(name);
        if (recipe.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }

        return new RecipeDTO(recipe.get());
    }

    //Add new recipe
    public RecipeDTO addRecipe (RecipeRequestDTO recipeData){
        Recipe newRecipe = recipeRepository.save(recipeData.toEntity());

        return new RecipeDTO(newRecipe);
    }

    //Update recipe
    public RecipeDTO updateRecipe (String id, RecipeRequestDTO recipeData){

        Optional<Recipe> recipe = recipeRepository.findById(id); //Finding recipe by ID
        if (recipe.isEmpty()) {
            throw new ResourceNotFoundException("The recipe does not exist.");
        }

        Recipe updatedRecipe = recipeData.toEntity(); //Creating a new instance of recipe and assigning the data
        updatedRecipe.setId(recipe.get().getId()); //Set the ID, in order just to update the instance, and not to make a new one
        updatedRecipe = recipeRepository.save(updatedRecipe); //updating the model
        return new RecipeDTO(updatedRecipe);
    }

    //Delete the recipe
    public void deleteRecipe (String id){  //Why are we here using "void" and in the controllers "Void"?
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isEmpty()) {
            throw new ResourceNotFoundException("The recipe does not exist.");
        }

        recipe.ifPresent(recipeRepository::delete);
    }

}

