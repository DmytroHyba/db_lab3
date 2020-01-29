package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
