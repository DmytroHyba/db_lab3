package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.DTO.TheVictimDTO;
import springboot.domain.TheVictim;
import springboot.exception.ExistsCityForTheVictimException;
import springboot.exception.NoSuchCityException;
import springboot.exception.NoSuchTheVictimException;
import springboot.exception.TheVictimAbsentException;
import springboot.service.TheVictimService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class TheVictimController {
    @Autowired
    TheVictimService theVictimService;

    @GetMapping(value = "/api/victim/{id_the_victim}")
    public ResponseEntity<TheVictimDTO> getTheVictim(@PathVariable Integer id_the_victim) throws NoSuchTheVictimException, TheVictimAbsentException {
        TheVictim theVictim = theVictimService.getTheVictim(id_the_victim);
        Link link = linkTo(methodOn(TheVictimController.class).getTheVictim(id_the_victim)).withSelfRel();

        TheVictimDTO theVictimDTO = new TheVictimDTO(theVictim, link);

        return new ResponseEntity<>(theVictimDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/victim")
    public ResponseEntity<List<TheVictimDTO>> getAllTheVictim() throws NoSuchCityException, NoSuchTheVictimException {
        List<TheVictim> theVictimList = theVictimService.getAllTheVictim();
        Link link = linkTo(methodOn(TheVictimController.class).getAllTheVictim()).withSelfRel();

        List<TheVictimDTO> theVictimDTO = new ArrayList<>();
        for (TheVictim entity : theVictimList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId_the_victim()).withSelfRel();
            TheVictimDTO dto = new TheVictimDTO(entity, selfLink);
            theVictimDTO.add(dto);
        }

        return new ResponseEntity<>(theVictimDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/victim")
    public ResponseEntity<TheVictimDTO> addTheVictim(@RequestBody TheVictim newTheVictim) throws NoSuchTheVictimException, TheVictimAbsentException {
        theVictimService.createTheVictim(newTheVictim);
        Link link = linkTo(methodOn(TheVictimController.class).getTheVictim(newTheVictim.getId_the_victim())).withSelfRel();

        TheVictimDTO theVictimDTO = new TheVictimDTO(newTheVictim, link);

        return new ResponseEntity<>(theVictimDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/victim/{id_the_victim}")
    public ResponseEntity<TheVictimDTO> updateTheVictim(@RequestBody TheVictim uTheVictim, @PathVariable Integer id_the_victim) throws NoSuchTheVictimException, TheVictimAbsentException {
        theVictimService.updateTheVictim(uTheVictim, id_the_victim);
        TheVictim theVictim = theVictimService.getTheVictim(id_the_victim);
        Link link = linkTo(methodOn(TheVictimController.class).getTheVictim(id_the_victim)).withSelfRel();

        TheVictimDTO theVictimDTO = new TheVictimDTO(theVictim, link);

        return new ResponseEntity<>(theVictimDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/victim/{id_the_victim}")
    public ResponseEntity deleteTheVictim(@PathVariable Integer id_the_victim) throws ExistsCityForTheVictimException, TheVictimAbsentException {
        theVictimService.deleteTheVictim(id_the_victim);
        return new ResponseEntity(HttpStatus.OK);
    }

}
