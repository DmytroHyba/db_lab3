package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.InjuredLifeguards;

public interface InjuredLifeguardsRepository extends JpaRepository<InjuredLifeguards, Integer> {
}
