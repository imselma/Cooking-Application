package ba.edu.ibu.CookingApp.rest.controllers;

import ba.edu.ibu.CookingApp.core.service.TipService;
import ba.edu.ibu.CookingApp.rest.dto.TipDTO;
import ba.edu.ibu.CookingApp.rest.dto.TipRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tips")
public class TipController {

    private final TipService tipService;
    public TipController (TipService tipService){
        this.tipService = tipService;
    }

    //Endpoint for getting all tips
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<TipDTO>> getTips(){
        return ResponseEntity.ok(tipService.getTips());
    }

    //Endpoint for getting tip by ID
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<TipDTO> getTipById(@PathVariable String id){
        return ResponseEntity.ok(tipService.getTipById(id));
    }

    //Endpoint for getting tip by name
    @RequestMapping(method = RequestMethod.GET, path = "/tip")
    public ResponseEntity<TipDTO> getTipByName(@RequestParam("name") String name){
        return ResponseEntity.ok(tipService.getTipByName(name));
    }

    //Endpoint for adding new tip
    @RequestMapping(method = RequestMethod.POST, path = "/addTip")
    public ResponseEntity<TipDTO> addTip (@RequestBody TipRequestDTO tip){
        return ResponseEntity.ok(tipService.addTip(tip));
    }

    //Endpoint for updating tip
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<TipDTO> updateTip (@PathVariable String id, @RequestBody TipRequestDTO tip){
        return ResponseEntity.ok(tipService.updateTip(id, tip));
    }

    //Endpoint for deleting tip
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable String id){
        tipService.deleteTip(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //Marks the operation completed
    }

}
