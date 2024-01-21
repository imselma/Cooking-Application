package ba.edu.ibu.CookingApp.rest.dto;

public class MessageDTO {
    private String message;  //Payload for the message that will be sent
    public MessageDTO(){}
    public MessageDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
