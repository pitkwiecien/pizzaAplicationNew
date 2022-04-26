package pl.duda.pizzaapplication.remote.rest.dto.request;

import pl.duda.pizzaapplication.remote.rest.dto.response.SizeDto;

import java.util.List;

public class AddPizzaDto {
    private String name;
    private List<AddSizeDto> sizes;

    public AddPizzaDto(String name, List<AddSizeDto> sizes){
        this.name = name;
        this.sizes = sizes;
    }

    public String getName(){
        return name;
    }

    public List<AddSizeDto> getSizes(){
        return sizes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSizes(List<AddSizeDto> sizes) {
        this.sizes = sizes;
    }
}
