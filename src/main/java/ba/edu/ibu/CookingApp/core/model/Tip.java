package ba.edu.ibu.CookingApp.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
public class Tip {

    @Id
    private String id;
    private String name;
    private String description;
    private Date reliesDate;

    public String getId() { return id;}
    public void setId(String id) { this.id = id;}

    public String getName(){ return name; }
    public void setName (String name){ this.name = name; }

    public String getDescription(){ return description; }
    public void setDescription (String description){ this.description = description; }

    public Date getReliesDate(){ return reliesDate; }
    public void setReliesDate (Date relieseDate){ this.reliesDate = relieseDate; }




}
