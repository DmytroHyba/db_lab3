package springboot.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "injured_lifeguards")
public class InjuredLifeguards implements Serializable {
    @Column(name = "id_injured_lifeguards")
    @Id
    private Integer id_injured_lifeguards;
    @Column(name = "description_of_the_injury")
    private String description_of_the_injury;
    @Column(name = "diagnosis")
    private String diagnosis;

    public InjuredLifeguards() {
    }

    public InjuredLifeguards(Integer id_injured_lifeguards, String description_of_the_injury, String diagnosis) {
        this.id_injured_lifeguards = id_injured_lifeguards;
        this.description_of_the_injury = description_of_the_injury;
        this.diagnosis = diagnosis;
    }

    public Integer getId_injured_lifeguards() {
        return id_injured_lifeguards;
    }

    public void setId_injured_lifeguards(Integer id_injured_lifeguards) {
        this.id_injured_lifeguards = id_injured_lifeguards;
    }

    public String getDescription_of_the_injury() {
        return description_of_the_injury;
    }

    public void setDescription_of_the_injury(String description_of_the_injury) {
        this.description_of_the_injury = description_of_the_injury;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "InjuredLifeguards{" +
                "id_injured_lifeguards=" + id_injured_lifeguards +
                ", description_of_the_injury='" + description_of_the_injury + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
