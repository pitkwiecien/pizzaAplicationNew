package pl.duda.pizzaapplication.remote.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.duda.pizzaapplication.domain.model.OrderStatusType;
import pl.duda.pizzaapplication.domain.service.AddOrderService;
import pl.duda.pizzaapplication.domain.service.GetOrderService;
import pl.duda.pizzaapplication.remote.rest.dto.request.AddOrderDto;
import pl.duda.pizzaapplication.remote.rest.dto.request.UpdateOrderDto;
import pl.duda.pizzaapplication.remote.rest.dto.response.OrderCollectionDto;
import pl.duda.pizzaapplication.remote.rest.dto.response.OrderDto;
import pl.duda.pizzaapplication.remote.rest.dto.response.OrderStatusDto;
import pl.duda.pizzaapplication.remote.rest.dto.response.TokenDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/orders", produces = APPLICATION_JSON_VALUE)

public class OrderController {
    private final AddOrderService addOrderService;
    private final GetOrderService getOrderService;


    public OrderController(AddOrderService addOrderService, GetOrderService getOrderService) {
        this.addOrderService = addOrderService;
        this.getOrderService = getOrderService;
    }

    @PostMapping
    public ResponseEntity<TokenDto> addOrder(@RequestBody AddOrderDto addOrderDto){
        TokenDto tokenDto = addOrderService.addOrder(addOrderDto);
        return ResponseEntity.ok(tokenDto);
    }

    @GetMapping("/status/{token}")
    public ResponseEntity<OrderStatusDto> getStatus(@PathVariable("token")String token){
        OrderStatusDto orderStatusDto = getOrderService.getOrderStatus(token);
        return ResponseEntity.ok(orderStatusDto);
    }

    @GetMapping
    public ResponseEntity<OrderCollectionDto> getOrders(@RequestParam("status")OrderStatusType orderStatus, @RequestHeader("Access-Token") String token){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteOrders(@PathVariable("order-id") Integer orderId, @RequestParam("Access-Token") String token){
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<OrderDto> putOrder(@RequestHeader("Access-Token") String token, @PathVariable("order-id") Integer orderId, @RequestBody UpdateOrderDto updateOrderDto){
        return ResponseEntity.ok(null);
    }
}
