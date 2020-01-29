package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.DTO.EmergencySituationDTO;
import springboot.DTO.HospitalDTO;
import springboot.domain.EmergencySituation;
import springboot.domain.Hospital;
import springboot.domain.TheVictim;
import springboot.exception.*;
import springboot.service.EmergencySituationService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class EmergencySituationController {
    @Autowired
    EmergencySituationService emergencySituationService;

    @GetMapping(value = "/api/emergencySituation/{id_emergency_situation}")
    public ResponseEntity<EmergencySituationDTO> getEmergencySituation(@PathVariable Integer id_emergency_situation) throws NoSuchTheVictimException, TheVictimAbsentException, NoSuchEmergencySituation {
        EmergencySituation emergencySituation = emergencySituationService.getEmergencySituation(id_emergency_situation);
        Link link = linkTo(methodOn(TheVictimController.class).getTheVictim(id_emergency_situation)).withSelfRel();

        EmergencySituationDTO emergencySituationDTO = new EmergencySituationDTO(emergencySituation, link);

        return new ResponseEntity<>(emergencySituationDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/emergencySituation")
    public ResponseEntity<List<EmergencySituationDTO>> getAllEmergencySituation() throws NoSuchCityException, NoSuchTheVictimException {
        List<EmergencySituation> emergencySituationList = emergencySituationService.getAllEmergencySituation();
        Link link = linkTo(methodOn(EmergencySituationController.class).getAllEmergencySituation()).withSelfRel();

        List<EmergencySituationDTO> emergencySituationDTO = new ArrayList<>();
        for (EmergencySituation entity : emergencySituationList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId_emergency_situation()).withSelfRel();
            EmergencySituationDTO dto = new EmergencySituationDTO(entity, selfLink);
            emergencySituationDTO.add(dto);
        }

        return new ResponseEntity<>(emergencySituationDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/emergencySituation")
    public ResponseEntity<EmergencySituationDTO> addEmergencySituation(@RequestBody EmergencySituation newEmergencySituation) throws NoSuchTheVictimException, TheVictimAbsentException, NoSuchHospitalException, NoSuchEmergencySituation {
        emergencySituationService.createEmergencySituation(newEmergencySituation);
        Link link = linkTo(methodOn(EmergencySituationController.class).getEmergencySituation(newEmergencySituation.getId_emergency_situation())).withSelfRel();

        EmergencySituationDTO emergencySituationDTO = new EmergencySituationDTO(newEmergencySituation, link);

        return new ResponseEntity<>(emergencySituationDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/emergencySituation/{id_emergency_situation}")
    public ResponseEntity<EmergencySituationDTO> updateEmergencySituation(@RequestBody EmergencySituation uEmergencySituation, @PathVariable Integer id_emergency_situation) throws NoSuchTheVictimException, TheVictimAbsentException, NoSuchHospitalException, NoSuchCityException, NoSuchEmergencySituation {
        emergencySituationService.updateEmergencySituation(uEmergencySituation, id_emergency_situation);
        EmergencySituation emergencySituation = emergencySituationService.getEmergencySituation(id_emergency_situation);
        Link link = linkTo(methodOn(EmergencySituationController.class).getEmergencySituation(id_emergency_situation)).withSelfRel();

        EmergencySituationDTO emergencySituationDTO = new EmergencySituationDTO(emergencySituation, link);

        return new ResponseEntity<>(emergencySituationDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/emergencySituation/{id_emergency_situation}")
    public ResponseEntity deleteEmergencySituation(@PathVariable Integer id_emergency_situation) throws ExistsCityForTheVictimException, TheVictimAbsentException, NoSuchEmergencySituation {
        emergencySituationService.deleteEmergencySituation(id_emergency_situation);
        return new ResponseEntity(HttpStatus.OK);
    }

}