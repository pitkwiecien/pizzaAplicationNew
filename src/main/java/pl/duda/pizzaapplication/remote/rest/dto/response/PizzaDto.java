package pl.duda.pizzaapplication.remote.rest.dto.response;

import java.util.List;

public class PizzaDto{
	private Integer id;
	private String name;
	private List<SizeDto> sizes;

	public PizzaDto(Integer id, String name, List<SizeDto> sizes){
		this.id = id;
		this.name = name;
		this.sizes = sizes;
	}
	
	public Integer getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public List<SizeDto> getSizes(){
		return sizes;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSizes(List<SizeDto> sizes) {
		this.sizes = sizes;
	}
}