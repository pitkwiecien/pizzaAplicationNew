package pl.duda.pizzaapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.duda.pizzaapplication.data.entity.ordersize.OrderSizeEntity;

public interface OrderSizeRepository extends JpaRepository<OrderSizeEntity, Integer> {
}
