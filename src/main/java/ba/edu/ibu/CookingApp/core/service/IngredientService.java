package ba.edu.ibu.CookingApp.core.service;

import ba.edu.ibu.CookingApp.core.exceptions.repository.ResourceNotFoundException;
import ba.edu.ibu.CookingApp.core.model.Ingredient;
import ba.edu.ibu.CookingApp.core.repository.IngredientRepository;
import ba.edu.ibu.CookingApp.rest.dto.IngredientDTO;
import ba.edu.ibu.CookingApp.rest.dto.IngredientRequestDTO;
import ba.edu.ibu.CookingApp.rest.dto.UserDTO;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    public IngredientService (IngredientRepository ingredientRepository)
    {
        this.ingredientRepository = ingredientRepository;
    }

    //Add a new ingredient
    public IngredientDTO addIngredient (IngredientRequestDTO ingredientData){
        Ingredient newIngredient = ingredientRepository.save(ingredientData.toEntity());

        return new IngredientDTO(newIngredient);
    }

    //Get ingredients by id
    public Ingredient getIngredientById(String id){
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isEmpty()) {
            throw new ResourceNotFoundException("The ingredient does not exist.");
        }
        return ingredient.get();
    }

    //Get all ingredients
    public List<IngredientDTO> getAllIngredients(){
        List<Ingredient> ingredients = ingredientRepository.findAll();

        return ingredients
                .stream()
                .map(IngredientDTO::new)
                .collect(toList());
    }

    //Get ingredients by name
    public Ingredient getIngredientByName(String name){
        Optional<Ingredient> ingredient = ingredientRepository.findByName(name);
        if(ingredient.isEmpty()){
            throw new ResourceNotFoundException("Ingredient not found!");
        }

        return ingredient.get();
    }

    //Update/Edit ingredients
    public IngredientDTO updateIngredients (String id, IngredientRequestDTO ingredientData){
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isEmpty()) {
            throw new ResourceNotFoundException("The ingredient does not exist.");
        }

        Ingredient updatedIngredient = ingredientData.toEntity();
        updatedIngredient.setId((ingredient.get().getId()));
        updatedIngredient = ingredientRepository.save(updatedIngredient);

        return new IngredientDTO(updatedIngredient);
    }

    //Delete ingredient
    public void deleteIngredient (String id){
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isEmpty()) {
            throw new ResourceNotFoundException("The ingredient does not exist.");
        }
        ingredient.ifPresent(ingredientRepository :: delete);
    }

    //Get all ingredients not DTO
    public List<Ingredient> getAllIngredientsNotDTO(){
        List<Ingredient> ingredients = ingredientRepository.findAll();

        return ingredients;
    }

    //Get ingredients by name not DTO
    public Ingredient getIngredientByNameNotDTO(String name){
        Optional<Ingredient> ingredient = ingredientRepository.findByName(name);
        if(ingredient.isEmpty()){
            throw new ResourceNotFoundException("Ingredient not found!");
        }

        return ingredient.get();
    }
}
