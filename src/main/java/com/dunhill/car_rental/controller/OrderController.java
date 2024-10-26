package com.dunhill.car_rental.controller;
import com.dunhill.car_rental.dtos.CreateOrderDto;
import com.dunhill.car_rental.entity.Order;
import com.dunhill.car_rental.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {


    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderDto createOrderDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Order order = orderService.createOrder(createOrderDTO,authentication);
        return ResponseEntity.ok(order);
}


    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderService.getAllOrders().stream()
                .filter(order -> order.getOrderId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody CreateOrderDto createOrderDto) {
//            Order updatedOrder = orderService.updateOrder(id, createOrderDto);
//            return ResponseEntity.ok(updatedOrder);
//        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
            orderService.deleteOrder(id);
            return ResponseEntity.noContent().build();
        }
}