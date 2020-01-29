package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.EmergencySituation;

public interface EmergencySituationRepository extends JpaRepository<EmergencySituation, Integer> {
}
