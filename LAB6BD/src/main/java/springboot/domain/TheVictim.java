package springboot.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "the_victim")
public class TheVictim implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_the_victim")
    @Id
    private Integer id_the_victim;
    @Column(name = "phone_number")
    private Integer phone_number;
    @Column(name = "name_of_victim")
    private String name_of_victim;
    @Column(name = "address")
    private String address;
    @Column(name = "id_cities")
    private Integer id_cities;

    public TheVictim() {
    }

    public TheVictim(Integer phone_number, String name_of_victim, String address, Integer id_cities) {
        this.phone_number = phone_number;
        this.name_of_victim = name_of_victim;
        this.address = address;
        this.id_cities = id_cities;
    }

    public Integer getId_the_victim() {
        return id_the_victim;
    }

    public void setId_the_victim(Integer id_the_victim) {
        this.id_the_victim = id_the_victim;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public String getName_of_victim() {
        return name_of_victim;
    }

    public void setName_of_victim(String name_of_victim) {
        this.name_of_victim = name_of_victim;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId_cities() {
        return id_cities;
    }

    public void setId_cities(Integer id_cities) {
        this.id_cities = id_cities;
    }

    @Override
    public String toString() {
        return "TheVictim{" +
                "id_the_victim=" + id_the_victim +
                ", phone_number=" + phone_number +
                ", name_of_victim='" + name_of_victim + '\'' +
                ", address='" + address + '\'' +
                ", id_cities=" + id_cities +
                '}';
    }
}
