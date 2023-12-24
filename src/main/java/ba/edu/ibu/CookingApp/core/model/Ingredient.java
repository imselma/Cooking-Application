package ba.edu.ibu.CookingApp.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ingredient {
    @Id
    private String id;
    private String name;
    private String category;
    private String measurementUnit;

    public String getId() {return id;}
    public void setId (String id) {this.id = id;}

    public String getName() {return name;}
    public void setName (String name) {this.name = name;}

    public String getCategory() {return category;}
    public void setCategory (String category) {this.category = category;}

    public String getMeasurementUnit() {return measurementUnit;}
    public void setMeasurementUnit (String measurementUnit) {this.measurementUnit = measurementUnit;}

}

