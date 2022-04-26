package pl.duda.pizzaapplication.domain.mapper;

import pl.duda.pizzaapplication.data.entity.order.OrderEntity;
import pl.duda.pizzaapplication.remote.rest.dto.response.TokenDto;

public class TokenMapper {
    public TokenDto mapToTokenDto(OrderEntity orderEntity){
        return new TokenDto(orderEntity.getToken());
    }
}
