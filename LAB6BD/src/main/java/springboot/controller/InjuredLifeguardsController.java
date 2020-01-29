package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.DTO.InjuredLifeguardsDTO;
import springboot.DTO.TheVictimDTO;
import springboot.domain.InjuredLifeguards;
import springboot.domain.TheVictim;
import springboot.exception.*;
import springboot.service.InjuredLifeguardsService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class InjuredLifeguardsController {
    @Autowired
    InjuredLifeguardsService injuredLifeguardsService;

    @GetMapping(value = "/api/injuredLifeguards/{id_injured_lifeguards}")
    public ResponseEntity<InjuredLifeguardsDTO> getInjuredLifeguards(@PathVariable Integer id_injured_lifeguards) throws NoSuchTheVictimException, TheVictimAbsentException, NoSuchInjuredLifeguardsException {
        InjuredLifeguards injuredLifeguards = injuredLifeguardsService.getInjuredLifeguards(id_injured_lifeguards);
        Link link = linkTo(methodOn(InjuredLifeguardsController.class).getInjuredLifeguards(id_injured_lifeguards)).withSelfRel();

        InjuredLifeguardsDTO injuredLifeguardsDTO = new InjuredLifeguardsDTO(injuredLifeguards, link);

        return new ResponseEntity<>(injuredLifeguardsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/injuredLifeguards")
    public ResponseEntity<List<InjuredLifeguardsDTO>> getAllInjuredLifeguards() throws NoSuchCityException, NoSuchTheVictimException {
        List<InjuredLifeguards> injuredLifeguardsList = injuredLifeguardsService.getAllInjuredLifeguards();
        Link link = linkTo(methodOn(InjuredLifeguardsController.class).getAllInjuredLifeguards()).withSelfRel();

        List<InjuredLifeguardsDTO> injuredLifeguardsDTO = new ArrayList<>();
        for (InjuredLifeguards entity : injuredLifeguardsList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId_injured_lifeguards()).withSelfRel();
            InjuredLifeguardsDTO dto = new InjuredLifeguardsDTO(entity, selfLink);
            injuredLifeguardsDTO.add(dto);
        }

        return new ResponseEntity<>(injuredLifeguardsDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/injuredLifeguards")
    public ResponseEntity<InjuredLifeguardsDTO> addInjuredLifeguards(@RequestBody InjuredLifeguards newInjuredLifeguards) throws NoSuchTheVictimException, TheVictimAbsentException, NoSuchInjuredLifeguardsException {
        injuredLifeguardsService.createInjuredLifeguards(newInjuredLifeguards);
        Link link = linkTo(methodOn(InjuredLifeguardsController.class).getInjuredLifeguards(newInjuredLifeguards.getId_injured_lifeguards())).withSelfRel();

        InjuredLifeguardsDTO injuredLifeguardsDTO = new InjuredLifeguardsDTO(newInjuredLifeguards, link);

        return new ResponseEntity<>(injuredLifeguardsDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/injuredLifeguards/{id_injured_lifeguards}")
    public ResponseEntity<InjuredLifeguardsDTO> updateInjuredLifeguards(@RequestBody InjuredLifeguards uInjuredLifeguards, @PathVariable Integer id_injured_lifeguards) throws NoSuchTheVictimException, TheVictimAbsentException, NoSuchHospitalException, NoSuchInjuredLifeguardsException {
        injuredLifeguardsService.updateInjuredLifeguards(uInjuredLifeguards, id_injured_lifeguards);
        InjuredLifeguards injuredLifeguards = injuredLifeguardsService.getInjuredLifeguards(id_injured_lifeguards);
        Link link = linkTo(methodOn(InjuredLifeguardsController.class).getInjuredLifeguards(id_injured_lifeguards)).withSelfRel();

        InjuredLifeguardsDTO injuredLifeguardsDTO = new InjuredLifeguardsDTO(injuredLifeguards, link);

        return new ResponseEntity<>(injuredLifeguardsDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/injuredLifeguards/{id_injured_lifeguards}")
    public ResponseEntity deleteInjuredLifeguards(@PathVariable Integer id_injured_lifeguards) throws NoSuchInjuredLifeguardsException, CityHasNotTheVictimException {
        injuredLifeguardsService.deleteInjuredLifeguards(id_injured_lifeguards);
        return new ResponseEntity(HttpStatus.OK);
    }

}
