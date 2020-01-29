package springboot.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "injured_lifeguards")
public class Hospital implements Serializable {
    @Column(name = "id_hospital")
    @Id
    private Integer id_hospital;
    @Column(name = "name_of_hospital")
    private String name_of_hospital;
    @Column(name = "id_injured_lifeguards")
    private int id_injured_lifeguards;

    public Hospital() {
    }

    public Hospital(Integer id_hospital, String name_of_hospital, int id_injured_lifeguards) {
        this.id_hospital = id_hospital;
        this.name_of_hospital = name_of_hospital;
        this.id_injured_lifeguards = id_injured_lifeguards;
    }

    public Integer getId_hospital() {
        return id_hospital;
    }

    public void setId_hospital(Integer id_hospital) {
        this.id_hospital = id_hospital;
    }

    public String getName_of_hospital() {
        return name_of_hospital;
    }

    public void setName_of_hospital(String name_of_hospital) {
        this.name_of_hospital = name_of_hospital;
    }

    public int getId_injured_lifeguards() {
        return id_injured_lifeguards;
    }

    public void setId_injured_lifeguards(int id_injured_lifeguards) {
        this.id_injured_lifeguards = id_injured_lifeguards;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id_hospital=" + id_hospital +
                ", name_of_hospital='" + name_of_hospital + '\'' +
                ", id_injured_lifeguards=" + id_injured_lifeguards +
                '}';
    }
}
