package ba.edu.ibu.CookingApp.rest.dto;

import ba.edu.ibu.CookingApp.core.model.Ingredient;

public class IngredientDTO {
    private String name;
    private String category;
    private String measurementUnit;

    public IngredientDTO (Ingredient ingredient){
        this.name = ingredient.getName();
        this.category = ingredient.getCategory();
        this.measurementUnit = ingredient.getMeasurementUnit();
    }

    public String getName() {return name;}
    public void setName (String name) {this.name = name;}
    public String getCategory() {return category;}
    public void setCategory (String category) {this.category = category;}

    public String getMeasurementUnit() {return measurementUnit;}
    public void setMeasurementUnit (String measurementUnit) {this.measurementUnit = measurementUnit;}
}
