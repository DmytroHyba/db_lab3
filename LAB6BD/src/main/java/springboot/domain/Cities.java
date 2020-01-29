package springboot.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cities")
public class Cities implements Serializable {
    @Column(name = "id_cities")
    @Id
    private Integer id_cities;
    @Column(name = "name_of_city")
    private String name_of_city;

    public Cities() {

    }

    public Cities(Integer id_cities, String name_of_city) {
        this.id_cities = id_cities;
        this.name_of_city = name_of_city;
    }

    public Integer getId_cities() {
        return id_cities;
    }

    public void setId_cities(Integer id_cities) {
        this.id_cities = id_cities;
    }

    public String getName_of_city() {
        return name_of_city;
    }

    public void setName_of_city(String name_of_city) {
        this.name_of_city = name_of_city;
    }

    @Override
    public String toString() {
        return "CitiesEntity{" +
                "id_cities=" + id_cities +
                ", name_of_city=" + name_of_city +
                '}';
    }
}
