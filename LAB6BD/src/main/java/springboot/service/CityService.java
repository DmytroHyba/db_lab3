package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.domain.Cities;
import springboot.exception.ExistsCityForTheVictimException;
import springboot.exception.NoSuchCityException;
import springboot.repository.CitiesRepository;
import springboot.repository.TheVictimRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityService {

    @Autowired
    CitiesRepository citiesRepository;

    public Cities getCity(Integer id_cities) throws NoSuchCityException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        Cities cities = citiesRepository.findById(id_cities).get();//2.0.0.M7
        if (cities == null) throw new NoSuchCityException();
        return cities;
    }

    public List<Cities> getAllCities() {
        return citiesRepository.findAll();
    }

    @Transactional
    public void createCity(Cities cities) {
        citiesRepository.save(cities);
    }

    @Transactional
    public void updateCity(Cities uCity, Integer id_cities) throws NoSuchCityException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        Cities cities = citiesRepository.findById(id_cities).get();//2.0.0.M7
        if (cities == null) throw new NoSuchCityException();
        //update
        cities.setName_of_city(uCity.getName_of_city());
    }

    @Transactional
    public void deleteCity(Integer id_cities) throws NoSuchCityException, ExistsCityForTheVictimException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        Cities cities = citiesRepository.findById(id_cities).get();//2.0.0.M7

        if (cities == null) throw new NoSuchCityException();
        if (cities.getName_of_city().length() != 0)
        citiesRepository.delete(cities);
    }
}
