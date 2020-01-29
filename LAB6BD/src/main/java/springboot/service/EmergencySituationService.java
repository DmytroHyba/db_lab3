package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.domain.Cities;
import springboot.domain.EmergencySituation;
import springboot.domain.TheVictim;
import springboot.exception.ExistsCityForTheVictimException;
import springboot.exception.NoSuchCityException;
import springboot.exception.NoSuchEmergencySituation;
import springboot.repository.CitiesRepository;
import springboot.repository.EmergencySituationRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmergencySituationService {

    @Autowired
    EmergencySituationRepository emergencySituationRepository;

    public EmergencySituation getEmergencySituation(Integer id_emergency_situation) throws NoSuchEmergencySituation  {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        EmergencySituation emergencySituation = emergencySituationRepository.findById(id_emergency_situation).get();//2.0.0.M7
        if (emergencySituation == null) throw new NoSuchEmergencySituation();
        return emergencySituation;
    }

    public List<EmergencySituation> getAllEmergencySituation() {
        return emergencySituationRepository.findAll();
    }

    @Transactional
    public void createEmergencySituation(EmergencySituation emergencySituation) {
        emergencySituationRepository.save(emergencySituation);
    }

    @Transactional
    public void updateEmergencySituation(EmergencySituation uEmergencySituation, Integer id_emergency_situation) throws NoSuchCityException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        EmergencySituation emergencySituation = emergencySituationRepository.findById(id_emergency_situation).get();//2.0.0.M7
        if (emergencySituation == null) throw new NoSuchCityException();
        //update
        emergencySituation.setType_of_emergency(uEmergencySituation.getType_of_emergency());
        emergencySituation.setDate_of_emergency(uEmergencySituation.getDate_of_emergency());
        emergencySituation.setA_brief_description_of_the_call(uEmergencySituation.getA_brief_description_of_the_call());
        emergencySituation.setExtended_call_description(uEmergencySituation.getExtended_call_description());
        emergencySituation.setReason(uEmergencySituation.getReason());
    }

    @Transactional
    public void deleteEmergencySituation(Integer id_emergency_situation) throws NoSuchEmergencySituation, ExistsCityForTheVictimException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        EmergencySituation emergencySituation = emergencySituationRepository.findById(id_emergency_situation).get();//2.0.0.M7

        if (emergencySituation == null) throw new NoSuchEmergencySituation();
        if (emergencySituation.getA_brief_description_of_the_call().length() != 0) throw new ExistsCityForTheVictimException();
        emergencySituationRepository.delete(emergencySituation);
    }
}
