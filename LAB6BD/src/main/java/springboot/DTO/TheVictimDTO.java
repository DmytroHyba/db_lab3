package springboot.DTO;


import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import springboot.domain.TheVictim;
import springboot.exception.NoSuchTheVictimException;

public class TheVictimDTO extends ResourceSupport {
    TheVictim theVictim;
    public TheVictimDTO(TheVictim theVictim, Link selfLink) throws NoSuchTheVictimException {
        this.theVictim=theVictim;
        add(selfLink);
    }

    public Integer getId_the_victim() {
        return theVictim.getId_cities();
    }

    public int getPhone_number() {
        return theVictim.getPhone_number();
    }
    public String getName_of_victim() {
        return theVictim.getName_of_victim();
    }
    public String getAddress() {
        return theVictim.getAddress();
    }
    public int getId_cities() {
        return theVictim.getId_cities();
    }
}
