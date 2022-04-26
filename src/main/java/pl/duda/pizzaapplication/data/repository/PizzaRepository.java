package pl.duda.pizzaapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.duda.pizzaapplication.data.entity.pizza.PizzaEntity;

public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer> {
    
}
