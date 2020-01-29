package springboot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import springboot.domain.EmergencySituation;
import springboot.domain.TheVictim;
import springboot.exception.NoSuchTheVictimException;

public class EmergencySituationDTO extends ResourceSupport {
    EmergencySituation emergencySituation;
    public EmergencySituationDTO(EmergencySituation emergencySituation, Link selfLink) throws NoSuchTheVictimException {
        this.emergencySituation=emergencySituation;
        add(selfLink);
    }

    public Integer getId_emergency_situation() {
        return emergencySituation.getId_emergency_situation();
    }

    public String getType_of_emergency() {
        return emergencySituation.getType_of_emergency();
    }
    public String getDate_of_emergency() {
        return emergencySituation.getDate_of_emergency();
    }
    public String getA_brief_description_of_the_call() {
        return emergencySituation.getA_brief_description_of_the_call();
    }
    public String getExtended_call_description() {
        return emergencySituation.getExtended_call_description();
    }
    public String getReason() {
        return emergencySituation.getReason();
    }
}
