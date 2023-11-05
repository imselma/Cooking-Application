package ba.edu.ibu.CookingApp.rest.dto;

import ba.edu.ibu.CookingApp.core.model.Tip;

import java.util.Date;

public class TipRequestDTO {

    private String name;
    private String description;

    public TipRequestDTO(){};

    public TipRequestDTO(Tip tip){
        this.name = tip.getName();
        this.description = tip.getDescription();
    }

    public Tip toEntity(){
        Tip tip = new Tip();
        tip.setName(name);
        tip.setDescription(description);
        tip.setReliesDate(new Date());

        return tip;
    }

    public String getName(){ return name; }
    public void setName (String name){ this.name = name; }

    public String getDescription(){ return description; }
    public void setDescription (String description){ this.description = description; }
}
