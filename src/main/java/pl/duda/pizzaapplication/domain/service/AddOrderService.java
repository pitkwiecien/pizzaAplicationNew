package pl.duda.pizzaapplication.domain.service;

import org.springframework.stereotype.Service;
import pl.duda.pizzaapplication.data.entity.order.OrderEntity;
import pl.duda.pizzaapplication.data.repository.OrderRepository;
import pl.duda.pizzaapplication.data.repository.SizeRepository;
import pl.duda.pizzaapplication.domain.exception.ResourceNotFoundException;
import pl.duda.pizzaapplication.domain.mapper.TokenMapper;
import pl.duda.pizzaapplication.domain.model.OrderStatusType;
import pl.duda.pizzaapplication.remote.rest.dto.request.AddOrderDto;
import pl.duda.pizzaapplication.remote.rest.dto.request.PersonOrderDto;
import pl.duda.pizzaapplication.remote.rest.dto.response.TokenDto;

import java.util.Date;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddOrderService {
    private SizeRepository sizeRepository;
    private OrderRepository orderRepository;
    private TokenMapper tokenMapper;

    public TokenDto addOrder(AddOrderDto addOrderDto){
        Set<Integer> sizeIds = addOrderDto.getPizzas()
                .stream()
                .map(basePizzaOrderDto -> basePizzaOrderDto.getSizeId())
                .collect(Collectors.toSet());
        Boolean existSizes = sizeRepository.existsAllById(sizeIds);
        if(!existSizes) {
            throw new ResourceNotFoundException("Pizze o podanym rozmiarze nie istnieją w bazie danych");
        }

        String token = UUID.randomUUID().toString();

        Date now = new Date();
        PersonOrderDto person = addOrderDto.getPerson();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setClientName(person.getName());
        orderEntity.setClientAddress(person.getAddress());
        orderEntity.setClientPhone(person.getPhone());
        orderEntity.setFloor(person.getFloor());
        orderEntity.setStatus(OrderStatusType.NEW.name());
        orderEntity.setCreatedAt(now);
        orderEntity.setUpdatedAt(now);
        orderEntity.setToken(token);
        orderRepository.save(orderEntity);

        return new TokenDto(token);
    }
}
