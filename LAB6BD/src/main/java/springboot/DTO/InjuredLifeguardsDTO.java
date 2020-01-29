package springboot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import springboot.domain.InjuredLifeguards;
import springboot.domain.TheVictim;
import springboot.exception.NoSuchTheVictimException;

public class InjuredLifeguardsDTO extends ResourceSupport {
    InjuredLifeguards injuredLifeguards;
    public InjuredLifeguardsDTO(InjuredLifeguards injuredLifeguards, Link selfLink) throws NoSuchTheVictimException {
        this.injuredLifeguards=injuredLifeguards;
        add(selfLink);
    }

    public Integer getId_injured_lifeguards() {
        return injuredLifeguards.getId_injured_lifeguards();
    }

    public int getDescription_of_the_injury() {
        return injuredLifeguards.getId_injured_lifeguards();
    }
    public int getDiagnosis() {
        return injuredLifeguards.getId_injured_lifeguards();
    }
}