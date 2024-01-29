package ba.edu.ibu.CookingApp.rest.controllers;

import ba.edu.ibu.CookingApp.core.model.Ingredient;
import ba.edu.ibu.CookingApp.core.service.IngredientService;
import ba.edu.ibu.CookingApp.rest.dto.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ingredients")
@SecurityRequirement(name = "JWT Security")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController (IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    //Endpoint for getting all ingredients
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<IngredientDTO>> getAllIngredients (){
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }

    //Endpoint for getting ingredients by id
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    //@PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<Ingredient> getIngredientById (@PathVariable String id){
        return ResponseEntity.ok(ingredientService.getIngredientById(id));
    }

    //Get by name
    @RequestMapping(method = RequestMethod.GET, path = "/byname")
    //@PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<Ingredient> getIngredientByName(@RequestParam("name") String name){
        return ResponseEntity.ok(ingredientService.getIngredientByName(name));
    }


    //Endpoint for adding a new ingredient
    @RequestMapping(method = RequestMethod.POST, path = "/addIngredient")
    //@PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<IngredientDTO> addIngredient (@RequestBody IngredientRequestDTO ingredient){
        return ResponseEntity.ok(ingredientService.addIngredient(ingredient));
    }

    //Endpoint for updating an ingredient
    @RequestMapping(method = RequestMethod.POST, path = "/updateIngredient{id}")
    //@PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<IngredientDTO> updateIngredient(@PathVariable String id, @RequestBody IngredientRequestDTO ingredient){
        return ResponseEntity.ok(ingredientService.updateIngredients(id, ingredient));
    }

    //Endpoint for deleting an ingredient
    @RequestMapping(method = RequestMethod.DELETE, path="/{id}")
    //@PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<Void> deleteIngredient(@PathVariable String id){
        ingredientService.deleteIngredient(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}