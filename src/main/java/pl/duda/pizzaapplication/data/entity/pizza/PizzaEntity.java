package pl.duda.pizzaapplication.data.entity.pizza;

import pl.duda.pizzaapplication.data.entity.size.SizeEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pizzas")
public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "pizza", orphanRemoval = true)
    private Set<SizeEntity> sizes;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSizes(Set<SizeEntity> sizes) {
        this.sizes = sizes;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Set<SizeEntity> getSizes(){
        return sizes;
    }
}
