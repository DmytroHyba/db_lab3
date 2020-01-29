package springboot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import springboot.domain.Hospital;
import springboot.exception.NoSuchTheVictimException;

public class HospitalDTO extends ResourceSupport {
    Hospital hospital;
    public HospitalDTO(Hospital hospital, Link selfLink) throws NoSuchTheVictimException {
        this.hospital=hospital;
        add(selfLink);
    }

    public Integer getId_hospital() {
        return hospital.getId_hospital();
    }

    public String getName_of_hospital() {
        return hospital.getName_of_hospital();
    }
    public int getId_injured_lifeguards() {
        return hospital.getId_injured_lifeguards();
    }
}
