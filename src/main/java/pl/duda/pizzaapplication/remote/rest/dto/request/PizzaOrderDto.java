package pl.duda.pizzaapplication.remote.rest.dto.request;

import pl.duda.pizzaapplication.remote.rest.dto.response.PizzaDto;

public class PizzaOrderDto {
    private Integer id;
    private Integer sizeId;
    private Integer count;

    public PizzaOrderDto(Integer id, Integer sizeId, Integer count){
        this.id = id;
        this.sizeId = sizeId;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
