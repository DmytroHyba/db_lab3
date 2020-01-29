package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.Cities;

public interface CitiesRepository extends JpaRepository<Cities, Integer> {
}
