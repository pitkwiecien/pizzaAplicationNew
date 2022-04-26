package pl.duda.pizzaapplication.domain.mapper;

import pl.duda.pizzaapplication.data.entity.order.OrderEntity;
import pl.duda.pizzaapplication.domain.model.OrderStatusType;
import pl.duda.pizzaapplication.remote.rest.dto.response.OrderStatusDto;

public class OrderMapper {
    public OrderStatusDto mapToOrderStatusDto(OrderEntity orderEntity) {
        OrderStatusDto orderStatusDto = new OrderStatusDto();
        orderStatusDto.setStatus(OrderStatusType.valueOf(orderEntity.getStatus()));
        orderStatusDto.setCreatedAt(orderEntity.getCreatedAt());
        orderStatusDto.setExpectedAt(orderEntity.getExpectedAt());
        orderStatusDto.setUpdatedAt(orderEntity.getUpdatedAt());

        return orderStatusDto;
    }
}
