package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.TheVictim;

public interface TheVictimRepository extends JpaRepository<TheVictim, Integer> {
}
