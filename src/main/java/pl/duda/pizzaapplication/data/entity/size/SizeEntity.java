package pl.duda.pizzaapplication.data.entity.size;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

import pl.duda.pizzaapplication.data.entity.ordersize.OrderSizeEntity;
import pl.duda.pizzaapplication.data.entity.pizza.PizzaEntity;

@Entity
@Table(name = "sizes")
public class SizeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "size_type")
    private String sizeType;

    @Column(name = "price_base")
    private BigDecimal priceBase;

    @Column(name = "pizza_id")
    private Integer pizzaId;

    @OneToMany(mappedBy = "size")
    private Set<OrderSizeEntity> orderSizes;

    @ManyToOne
    @JoinColumn(name = "pizza_id", insertable = false, updatable = false)
    private PizzaEntity pizza;


}
