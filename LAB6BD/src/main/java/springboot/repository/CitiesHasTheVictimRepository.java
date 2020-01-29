package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.CitiesHasTheVictim;

public interface CitiesHasTheVictimRepository extends JpaRepository<CitiesHasTheVictim, Integer> {
}
