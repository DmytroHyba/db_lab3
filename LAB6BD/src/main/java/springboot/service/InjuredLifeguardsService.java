package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.domain.Hospital;
import springboot.domain.InjuredLifeguards;
import springboot.domain.TheVictim;
import springboot.exception.CityHasNotTheVictimException;
import springboot.exception.NoSuchHospitalException;
import springboot.exception.NoSuchInjuredLifeguardsException;
import springboot.repository.HospitalRepository;
import springboot.repository.InjuredLifeguardsRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InjuredLifeguardsService {

    @Autowired
    InjuredLifeguardsRepository injuredLifeguardsRepository;

    public InjuredLifeguards getInjuredLifeguards(Integer id_injured_lifeguards) throws NoSuchInjuredLifeguardsException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        InjuredLifeguards injuredLifeguards = injuredLifeguardsRepository.findById(id_injured_lifeguards).get();//2.0.0.M7
        if (injuredLifeguards == null) throw new NoSuchInjuredLifeguardsException();
        return injuredLifeguards;
    }

    public List<InjuredLifeguards> getAllInjuredLifeguards() {
        return injuredLifeguardsRepository.findAll();
    }

    @Transactional
    public void createInjuredLifeguards(InjuredLifeguards injuredLifeguards) {
        injuredLifeguardsRepository.save(injuredLifeguards);
    }

    @Transactional
    public void updateInjuredLifeguards(InjuredLifeguards uInjuredLifeguards, Integer id_injured_lifeguards) throws NoSuchHospitalException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        InjuredLifeguards injuredLifeguards = injuredLifeguardsRepository.findById(id_injured_lifeguards).get();//2.0.0.M7
        if (injuredLifeguards == null) throw new NoSuchHospitalException();
        //update
        injuredLifeguards.setDescription_of_the_injury(uInjuredLifeguards.getDescription_of_the_injury());
        injuredLifeguards.setDiagnosis(uInjuredLifeguards.getDiagnosis());

    }

    @Transactional
    public void deleteInjuredLifeguards(Integer id_injured_lifeguards) throws NoSuchInjuredLifeguardsException, CityHasNotTheVictimException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        InjuredLifeguards injuredLifeguards = injuredLifeguardsRepository.findById(id_injured_lifeguards).get();//2.0.0.M7

        if (injuredLifeguards == null) throw new NoSuchInjuredLifeguardsException();
        if (injuredLifeguards.getDescription_of_the_injury().length() != 0) throw new CityHasNotTheVictimException();
        injuredLifeguardsRepository.delete(injuredLifeguards);
    }
}