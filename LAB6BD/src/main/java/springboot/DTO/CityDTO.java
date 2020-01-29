package springboot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import springboot.domain.Cities;
import springboot.exception.NoSuchTheVictimException;
import springboot.exception.NoSuchInjuredLifeguardsException;


public class CityDTO extends ResourceSupport {
    Cities cities;
    public CityDTO(Cities cities, Link selfLink) throws NoSuchTheVictimException {
        this.cities=cities;
        add(selfLink);
    }

    public Integer getId_cities() {
        return cities.getId_cities();
    }

    public String getName_of_city() {
        return cities.getName_of_city();
    }
}

