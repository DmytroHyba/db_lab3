package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.DTO.CityDTO;
import springboot.domain.Cities;
import springboot.exception.ExistsCityForTheVictimException;
import springboot.exception.NoSuchCityException;
import springboot.exception.NoSuchTheVictimException;
import springboot.service.CityService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping(value = "/api/city/{id_cities}")
    public ResponseEntity<CityDTO> getCity(@PathVariable Integer id_cities) throws NoSuchCityException, NoSuchTheVictimException {
        Cities cities = cityService.getCity(id_cities);
        Link link = linkTo(methodOn(CityController.class).getCity(id_cities)).withSelfRel();

        CityDTO cityDTO = new CityDTO(cities, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/city")
    public ResponseEntity<List<CityDTO>> getAllCity() throws NoSuchCityException, NoSuchTheVictimException {
        List<Cities> citiesList = cityService.getAllCities();
        Link link = linkTo(methodOn(CityController.class).getAllCity()).withSelfRel();

        List<CityDTO> cityDTO = new ArrayList<>();
        for (Cities entity : citiesList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId_cities()).withSelfRel();
            CityDTO dto = new CityDTO(entity, selfLink);
            cityDTO.add(dto);
        }

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/city")
    public ResponseEntity<CityDTO> addCity(@RequestBody Cities newCity) throws NoSuchCityException, NoSuchTheVictimException {
        cityService.createCity(newCity);
        Link link = linkTo(methodOn(CityController.class).getCity(newCity.getId_cities())).withSelfRel();

        CityDTO cityDTO = new CityDTO(newCity, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/city/{id_cities}")
    public ResponseEntity<CityDTO> updateCity(@RequestBody Cities uCity, @PathVariable Integer id_cities) throws NoSuchCityException, NoSuchTheVictimException {
        cityService.updateCity(uCity, id_cities);
        Cities cities = cityService.getCity(id_cities);
        Link link = linkTo(methodOn(CityController.class).getCity(id_cities)).withSelfRel();

        CityDTO cityDTO = new CityDTO(cities, link);

        return new ResponseEntity<>(cityDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/city/{id_cities}")
    public ResponseEntity deleteCity(@PathVariable Integer id_cities) throws ExistsCityForTheVictimException, NoSuchCityException {
        cityService.deleteCity(id_cities);
        return new ResponseEntity(HttpStatus.OK);
    }

}
