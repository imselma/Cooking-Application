package ba.edu.ibu.CookingApp.rest.dto;

import ba.edu.ibu.CookingApp.core.model.Tip;

public class TipDTO {

    private String id;
    private String tip;

    public TipDTO(Tip tip){
        this.id = tip.getId();
        this.tip = "Name: " + tip.getName() + " Description: " + tip.getDescription();
    }

    public String getId() { return id;}
    public void setId(String id) { this.id = id;}

    public String getTip() {return tip;}
    public void setTip(String tip){ this.tip = tip;}
}
