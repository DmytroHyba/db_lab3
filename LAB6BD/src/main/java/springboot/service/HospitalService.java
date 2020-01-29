package springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.domain.Hospital;
import springboot.exception.CityHasNotTheVictimException;
import springboot.exception.NoSuchHospitalException;
import springboot.repository.HospitalRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;

    public Hospital getHospital(Integer id_hospital) throws NoSuchHospitalException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        Hospital hospital = hospitalRepository.findById(id_hospital).get();//2.0.0.M7
        if (hospital == null) throw new NoSuchHospitalException();
        return hospital;
    }

    public List<Hospital> getAllHospital() {
        return hospitalRepository.findAll();
    }

    @Transactional
    public void createHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Transactional
    public void updateHospital(Hospital uHospital, Integer id_hospital) throws NoSuchHospitalException {
//        Book book = bookRepository.findOne(book_id);//1.5.9
        Hospital hospital = hospitalRepository.findById(id_hospital).get();//2.0.0.M7
        if (hospital == null) throw new NoSuchHospitalException();
        //update
        hospital.setName_of_hospital(uHospital.getName_of_hospital());
        hospital.setId_injured_lifeguards(uHospital.getId_injured_lifeguards());

    }

    @Transactional
    public void deleteHospital(Integer id_hospital) throws NoSuchHospitalException, CityHasNotTheVictimException {
//        Hospital hospital = hospitalRepository.findById(id_hospital);//1.5.9
        Hospital hospital = hospitalRepository.findById(id_hospital).get();//2.0.0.M7

        if (hospital == null) throw new NoSuchHospitalException();
        if (hospital.getName_of_hospital().length() != 0) throw new CityHasNotTheVictimException();
        hospitalRepository.delete(hospital);
    }
}
