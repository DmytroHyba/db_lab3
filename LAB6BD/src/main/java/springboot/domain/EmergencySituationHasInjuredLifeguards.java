package springboot.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cities_has_the_victim")
public class EmergencySituationHasInjuredLifeguards implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_emergency_situation")
    private Integer id_emergency_situation;
    @Column(name = "id_injured_lifeguards")
    private Integer id_injured_lifeguards;

    public EmergencySituationHasInjuredLifeguards() {
    }

    public EmergencySituationHasInjuredLifeguards(Integer id, Integer id_emergency_situation, Integer id_injured_lifeguards) {
        this.id = id;
        this.id_emergency_situation = id_emergency_situation;
        this.id_injured_lifeguards = id_injured_lifeguards;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_emergency_situation() {
        return id_emergency_situation;
    }

    public void setId_emergency_situation(Integer id_emergency_situation) {
        this.id_emergency_situation = id_emergency_situation;
    }

    public Integer getId_injured_lifeguards() {
        return id_injured_lifeguards;
    }

    public void setId_injured_lifeguards(Integer id_injured_lifeguards) {
        this.id_injured_lifeguards = id_injured_lifeguards;
    }

    @Override
    public String toString() {
        return "EmergencySituationHasInjuredLifeguards{" +
                "id=" + id +
                ", id_emergency_situation=" + id_emergency_situation +
                ", id_injured_lifeguards=" + id_injured_lifeguards +
                '}';
    }
}

