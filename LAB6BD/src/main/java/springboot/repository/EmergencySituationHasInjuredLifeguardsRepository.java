package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.EmergencySituationHasInjuredLifeguards;

public interface EmergencySituationHasInjuredLifeguardsRepository extends JpaRepository<EmergencySituationHasInjuredLifeguards, Integer> {
}
