package ba.edu.ibu.CookingApp.core.service;

import ba.edu.ibu.CookingApp.core.exceptions.repository.ResourceNotFoundException;
import ba.edu.ibu.CookingApp.core.model.Tip;
import ba.edu.ibu.CookingApp.core.repository.TipRepository;
import ba.edu.ibu.CookingApp.rest.dto.TipDTO;
import ba.edu.ibu.CookingApp.rest.dto.TipRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class TipService {

    private final TipRepository tipRepository;
    public TipService(TipRepository tipRepository) {
        this.tipRepository = tipRepository;
    }


    //Get all tips
    public List<TipDTO> getTips() {
        List<Tip> tips = tipRepository.findAll();

        return tips
                .stream() //returns one by one
                .map(TipDTO::new)
                .collect(toList());
    }

    //Get tip by id
    public TipDTO getTipById (String id){
        Optional<Tip> tip = tipRepository.findById(id);
        if (tip.isEmpty()) {
            throw new ResourceNotFoundException("The tip does not exist.");
        }

        return new TipDTO(tip.get());
    }

    //Get tip by name
    public  TipDTO getTipByName (String name){
        Optional<Tip> tip = tipRepository.findByName(name);
        if (tip.isEmpty()) {
            throw new ResourceNotFoundException("The tip does not exist.");
        }

        return new TipDTO(tip.get());
    }

    //Add new tip
    public TipDTO addTip (TipRequestDTO tipData){
        Tip newTip = tipRepository.save(tipData.toEntity());

        return new TipDTO(newTip);
    }

    //Update tip
    public TipDTO updateTip (String id, TipRequestDTO tipData){
        Optional<Tip> tip = tipRepository.findById(id);
        if (tip.isEmpty()) {
            throw new ResourceNotFoundException("The tip does not exist.");
        }

        Tip updatedTip = tipData.toEntity();
        updatedTip.setId(tip.get().getId());
        updatedTip = tipRepository.save(updatedTip); //updating the model
        return new TipDTO(updatedTip);
    }

    //Delete the tip
    public void deleteTip (String id){
        Optional<Tip> tip = tipRepository.findById(id);
        if (tip.isEmpty()) {
            throw new ResourceNotFoundException("The tip does not exist.");
        }

        tip.ifPresent(tipRepository::delete);
    }
}
