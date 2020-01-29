package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.DTO.HospitalDTO;
import springboot.domain.Hospital;
import springboot.exception.*;
import springboot.service.HospitalService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @GetMapping(value = "/api/hospital/{id_hospital}")
    public ResponseEntity<HospitalDTO> getHospital(@PathVariable Integer id_hospital) throws NoSuchTheVictimException, TheVictimAbsentException, NoSuchHospitalException {
        Hospital hospital = hospitalService.getHospital(id_hospital);
        Link link = linkTo(methodOn(HospitalController.class).getHospital(id_hospital)).withSelfRel();

        HospitalDTO hospitalDTO = new HospitalDTO(hospital, link);

        return new ResponseEntity<>(hospitalDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/hospital")
    public ResponseEntity<List<HospitalDTO>> getAllHospital() throws NoSuchCityException, NoSuchTheVictimException {
        List<Hospital> hospitalList = hospitalService.getAllHospital();
        Link link = linkTo(methodOn(HospitalController.class).getAllHospital()).withSelfRel();

        List<HospitalDTO> hospitalDTO = new ArrayList<>();
        for (Hospital entity : hospitalList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId_hospital()).withSelfRel();
            HospitalDTO dto = new HospitalDTO(entity, selfLink);
            hospitalDTO.add(dto);
        }

        return new ResponseEntity<>(hospitalDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/hospital")
    public ResponseEntity<HospitalDTO> addHospital(@RequestBody Hospital newHospital) throws NoSuchTheVictimException, TheVictimAbsentException, NoSuchHospitalException {
        hospitalService.createHospital(newHospital);
        Link link = linkTo(methodOn(HospitalController.class).getHospital(newHospital.getId_hospital())).withSelfRel();

        HospitalDTO hospitalDTO = new HospitalDTO(newHospital, link);

        return new ResponseEntity<>(hospitalDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/hospital/{id_hospital}")
    public ResponseEntity<HospitalDTO> updateHospital(@RequestBody Hospital uHospital, @PathVariable Integer id_hospital) throws NoSuchTheVictimException, TheVictimAbsentException, NoSuchHospitalException {
        hospitalService.updateHospital(uHospital, id_hospital);
        Hospital hospital = hospitalService.getHospital(id_hospital);
        Link link = linkTo(methodOn(HospitalController.class).getHospital(id_hospital)).withSelfRel();

        HospitalDTO hospitalDTO = new HospitalDTO(hospital, link);

        return new ResponseEntity<>(hospitalDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/hospital/{id_hospital}")
    public ResponseEntity deleteHospital(@PathVariable Integer id_hospital) throws  NoSuchHospitalException, CityHasNotTheVictimException {
        hospitalService.deleteHospital(id_hospital);
        return new ResponseEntity(HttpStatus.OK);
    }

}
