package pl.duda.pizzaapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.duda.pizzaapplication.data.entity.size.SizeEntity;

import java.util.Set;

public interface SizeRepository extends JpaRepository<SizeEntity, Integer> {
    void deleteAllByPizzaId(Integer pizzaId);
    boolean existsAllById(Set<Integer> ids);
}
