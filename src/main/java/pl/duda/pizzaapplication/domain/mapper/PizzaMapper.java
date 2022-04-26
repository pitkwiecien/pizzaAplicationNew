package pl.duda.pizzaapplication.domain.mapper;

import org.hibernate.engine.jdbc.Size;
import pl.duda.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.duda.pizzaapplication.data.entity.size.SizeEntity;
import pl.duda.pizzaapplication.remote.rest.dto.request.AddPizzaDto;
import pl.duda.pizzaapplication.remote.rest.dto.response.PizzaDto;
import pl.duda.pizzaapplication.remote.rest.dto.response.SizeDto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PizzaMapper {
    private final SizeMapper sizeMapper;

    public PizzaMapper(SizeMapper sizeMapper){
        this.sizeMapper=sizeMapper;
    }

    public PizzaEntity mapToPizzaEntity(AddPizzaDto addPizzaDto){
        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setName(addPizzaDto.getName());
        return pizzaEntity;
    }

    public PizzaDto mapToPizzaDto(PizzaEntity pizzaEntity, List<SizeDto> sizeDtoList){
        PizzaDto pizzaDto = new PizzaDto();
        pizzaDto.setName(pizzaEntity.getName());
        pizzaDto.setId(pizzaEntity.getId());
        pizzaDto.setSizes(sizeDtoList);
        return pizzaDto;
    }

    public PizzaDto mapToPizzaDto(PizzaEntity pizzaEntity) {
        Set<SizeEntity> sizeEntitySet = pizzaEntity.getSizes();

        List<SizeDto> sizeDtoList = sizeEntitySet
                .stream()
                .map(sizeMapper::mapToSizeDto)
                .collect(Collectors.toList());
        return mapToPizzaDto(pizzaEntity, sizeDtoList);
    }
}
