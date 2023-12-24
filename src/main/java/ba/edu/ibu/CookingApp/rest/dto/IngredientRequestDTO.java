package ba.edu.ibu.CookingApp.rest.dto;

import ba.edu.ibu.CookingApp.core.model.Ingredient;

public class IngredientRequestDTO {

    private String name;
    private String category;
    private String measurementUnit;

    public IngredientRequestDTO(){}
    public IngredientRequestDTO(Ingredient ingredient){
        this.name = ingredient.getName();
        this.category = ingredient.getCategory();
        this.measurementUnit = ingredient.getMeasurementUnit();
    }

    public Ingredient toEntity(){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredient.setCategory(category);
        ingredient.setMeasurementUnit(measurementUnit);

        return ingredient;
    }

    public String getName() {return name;}
    public void setName (String name) {this.name = name;}

    public String getCategory() {return category;}
    public void setCategory (String category) {this.category = category;}

    public String getMeasurementUnit() {return measurementUnit;}
    public void setMeasurementUnit (String measurementUnit) {this.measurementUnit = measurementUnit;}


}
