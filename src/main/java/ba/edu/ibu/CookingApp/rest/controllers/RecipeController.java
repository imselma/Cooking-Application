package ba.edu.ibu.CookingApp.rest.controllers;

import ba.edu.ibu.CookingApp.core.model.Ingredient;
import ba.edu.ibu.CookingApp.core.model.Recipe;
import ba.edu.ibu.CookingApp.core.service.RecipeService;
import ba.edu.ibu.CookingApp.rest.dto.RecipeDTO;
import ba.edu.ibu.CookingApp.rest.dto.RecipeRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recipes")
@SecurityRequirement(name = "JWT Security")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController (RecipeService recipeService){
        this.recipeService = recipeService;
    }

    //Endpoint for getting all recipes
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<Recipe>> getRecipes(){
        return ResponseEntity.ok(recipeService.getRecipes());
    }

    //Endpoint for adding new recipe
    @RequestMapping(method = RequestMethod.POST, path = "/addRecipe")
    //@PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<RecipeDTO> addRecipe (@RequestBody RecipeRequestDTO recipe){
        System.out.println(recipe.getIngredients());
        return ResponseEntity.ok(recipeService.addRecipe(recipe));
    }

    //Endpoint for getting recipe by ID
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
   // @PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable String id){
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    //Endpoint for getting recipe by name
     @RequestMapping(method = RequestMethod.GET, path = "/byname")
     //@PreAuthorize("hasAnyAuthority('MEMBER')")
     public ResponseEntity<RecipeDTO> getRecipeByName(@RequestParam("name") String name){
        return ResponseEntity.ok(recipeService.getRecipeByName(name));
    }


    //Endpoint for updating recipe
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    //@PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<RecipeDTO> updateRecipe (@PathVariable String id, @RequestBody RecipeRequestDTO recipe){
        return ResponseEntity.ok(recipeService.updateRecipe(id, recipe));
    }

    //Endpoint for deleting recipe
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    //@PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<Void> deleteRecipe(@PathVariable String id){
        recipeService.deleteRecipe(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //Marks the operation completed
    }

    //Endpoint for getting a recipe by id but not DTO
    @RequestMapping(method = RequestMethod.GET, path= "notDTO/{id}")
    public ResponseEntity<Recipe> getRecipeByIdNoDTO(@PathVariable String id){
        return ResponseEntity.ok(recipeService.getRecipeByIdNoDTO(id));
    }
}
