package pl.duda.pizzaapplication.domain.mapper;

import io.swagger.models.auth.In;
import org.springframework.stereotype.Component;
import pl.duda.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.duda.pizzaapplication.data.entity.size.SizeEntity;
import pl.duda.pizzaapplication.domain.model.SizeType;
import pl.duda.pizzaapplication.remote.rest.dto.request.AddSizeDto;
import pl.duda.pizzaapplication.remote.rest.dto.response.SizeDto;

@Component
public class SizeMapper {
    public SizeEntity mapToSizeEntity(AddSizeDto addSizeDto, Integer pizzaId){
        SizeEntity sizeEntity = new SizeEntity();
        sizeEntity.setSizeType(addSizeDto.getSize().name());
        sizeEntity.setPriceBase(addSizeDto.getPrice());
        sizeEntity.setPizzaId(pizzaId);
        return sizeEntity;
    }

    public SizeDto mapToSizeDto(SizeEntity sizeEntity){
        SizeDto sizeDto = new SizeDto(null,null,null);
        sizeDto.setSize(SizeType.valueOf(sizeEntity.getSizeType()));
        sizeDto.setPrice(sizeEntity.getPriceBase());
        sizeDto.setId(sizeEntity.getId());
        return sizeDto;
    }
}
