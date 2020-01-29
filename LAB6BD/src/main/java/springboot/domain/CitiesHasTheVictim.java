package springboot.domain;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cities_has_the_victim")
public class CitiesHasTheVictim implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_cities")
    private Integer id_cities;
    @Column(name = "id_the_victim")
    private Integer id_the_victim;

    public CitiesHasTheVictim() {
    }

    public CitiesHasTheVictim(Integer id, Integer id_cities, Integer id_the_victim) {
        this.id = id;
        this.id_cities = id_cities;
        this.id_the_victim = id_the_victim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_cities() {
        return id_cities;
    }

    public void setId_cities(Integer id_cities) {
        this.id_cities = id_cities;
    }

    public Integer getId_the_victim() {
        return id_the_victim;
    }

    public void setId_the_victim(Integer id_the_victim) {
        this.id_the_victim = id_the_victim;
    }

    @Override
    public String toString() {
        return "CitiesHasTheVictimEntity{" +
                "id_cities=" + id_cities +
                ", id_the_victim=" + id_the_victim +
                '}';
    }
}
