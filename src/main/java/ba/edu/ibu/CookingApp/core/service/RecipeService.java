package ba.edu.ibu.CookingApp.core.service;

import ba.edu.ibu.CookingApp.core.exceptions.repository.ResourceNotFoundException;
import ba.edu.ibu.CookingApp.core.model.Ingredient;
import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.model.User;
import ba.edu.ibu.CookingApp.core.repository.IngredientRepository;
import ba.edu.ibu.CookingApp.core.repository.RecipeRepository;
import ba.edu.ibu.CookingApp.core.repository.UserRepository;
import ba.edu.ibu.CookingApp.rest.dto.RecipeDTO;
import ba.edu.ibu.CookingApp.rest.dto.RecipeRequestDTO;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final IngredientRepository ingredientRepository;
    private final IngredientService ingredientService;


    public RecipeService(RecipeRepository recipeRepository, UserRepository userRepository, UserService userService, IngredientRepository ingredientRepository, IngredientService ingredientService) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.userService= userService;
        this.ingredientRepository = ingredientRepository;
        this.ingredientService = ingredientService;
    }

    //Create/add new recipe
    public RecipeDTO addRecipe (RecipeRequestDTO recipeData){

        String userId = recipeData.getUserId();
        User user = userService.getUserByIdNoDTO(userId);

        Recipe newRecipe = recipeData.toEntity();
        newRecipe.setUser(user);
        recipeRepository.save(newRecipe);

        return new RecipeDTO(newRecipe);
    }

    //Getall recipes
    public List<Recipe> getRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();

        return recipes;
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
            throw new ResourceNotFoundException("The recipe does not exist.");
        }

        User  user = recipe.get().getUser();
        String userName = user.getName();

        RecipeDTO recipeDTO =  new RecipeDTO(recipe.get());
        recipeDTO.setUserName(userName);
        return recipeDTO;
    }

    //Updat recipe
    public RecipeDTO updateRecipe (String id, RecipeRequestDTO recipeData){

        Optional<Recipe> recipe = recipeRepository.findById(id); //Finding recipe by ID
        if (recipe.isEmpty()) {
            throw new ResourceNotFoundException("The recipe does not exist.");
        }

        String userId = recipeData.getUserId();
        User user = userService.getUserByIdNoDTO(userId);

        Recipe updatedRecipe = recipeData.toEntity(); //Creating a new instance of recipe and assigning the data
        updatedRecipe.setId(recipe.get().getId()); //Set the ID, in order just to update the instance, and not to make a new one
        updatedRecipe.setUser(user);
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


    //Geting all recipes but not as DTO
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();

        return recipes;
    }

    // Get by Id but not as DTO
    public Recipe getRecipeByIdNoDTO (String id){
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isEmpty()) {
            throw new ResourceNotFoundException("The user does not exist.");
        }
        System.out.println(recipe.get());

        return recipe.get();
    }

}

