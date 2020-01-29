package springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.domain.TheVictim;
import springboot.exception.ExistsCityForTheVictimException;
import springboot.exception.TheVictimAbsentException;
import springboot.repository.CitiesRepository;
import springboot.repository.TheVictimRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TheVictimService {

    @Autowired
    TheVictimRepository theVictimRepository;

    public TheVictim getTheVictim(Integer id_the_victim) throws TheVictimAbsentException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        TheVictim theVictim = theVictimRepository.findById(id_the_victim).get();//2.0.0.M7
        if (theVictim == null) throw new TheVictimAbsentException();
        return theVictim;
    }

    public List<TheVictim> getAllTheVictim() {
        return theVictimRepository.findAll();
    }

    @Transactional
    public void createTheVictim(TheVictim theVictim) {
        theVictimRepository.save(theVictim);
    }

    @Transactional
    public void updateTheVictim(TheVictim uTheVictim, Integer id_the_victim) throws TheVictimAbsentException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        TheVictim theVictim = theVictimRepository.findById(id_the_victim).get();//2.0.0.M7
        if (theVictim == null) throw new TheVictimAbsentException();
        //update
        theVictim.setPhone_number(uTheVictim.getPhone_number());
        theVictim.setName_of_victim(uTheVictim.getName_of_victim());
        theVictim.setAddress(uTheVictim.getAddress());
        theVictim.setId_cities(uTheVictim.getId_cities());
    }

    @Transactional
    public void deleteTheVictim(Integer id_the_victim) throws TheVictimAbsentException, ExistsCityForTheVictimException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        TheVictim theVictim = theVictimRepository.findById(id_the_victim).get();//2.0.0.M7

        if (theVictim == null) throw new TheVictimAbsentException();
        if (theVictim.getAddress().length() != 0) throw new ExistsCityForTheVictimException();
        theVictimRepository.delete(theVictim);
    }
}
