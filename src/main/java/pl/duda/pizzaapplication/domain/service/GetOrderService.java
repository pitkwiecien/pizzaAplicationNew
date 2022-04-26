package pl.duda.pizzaapplication.domain.service;

import org.springframework.stereotype.Service;
import pl.duda.pizzaapplication.data.entity.order.OrderEntity;
import pl.duda.pizzaapplication.data.repository.OrderRepository;
import pl.duda.pizzaapplication.domain.exception.UnauthorizedException;
import pl.duda.pizzaapplication.domain.mapper.OrderMapper;
import pl.duda.pizzaapplication.remote.rest.dto.response.OrderStatusDto;

@Service
public class GetOrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public GetOrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public OrderStatusDto getOrderStatus(String token) {
        OrderEntity orderEntity = orderRepository.findByToken(token);
        if(orderEntity == null){
            throw new UnauthorizedException("Brak dostepu");
        }
        return  orderMapper.mapToOrderStatusDto(orderEntity);
    }
}
