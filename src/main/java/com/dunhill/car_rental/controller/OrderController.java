package com.dunhill.car_rental.controller;
import com.dunhill.car_rental.dtos.CreateOrderDto;
import com.dunhill.car_rental.entity.Order;
import com.dunhill.car_rental.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "CRUD REST APIs for Order Resource")
public class OrderController {


    private OrderService orderService;

    @SecurityRequirement(name = "basicAuth")
    @Operation(summary = "Create Order REST API", description = "Creates a new order based on the provided order details.")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    @SecurityRequirement(name = "basicAuth")
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderDto createOrderDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Order order = orderService.createOrder(createOrderDTO,authentication);
        return ResponseEntity.ok(order);
}

    @Operation(summary = "Retrieve All Orders REST API", description = "Fetches a list of all existing orders.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @Operation(summary = "Get Order by ID REST API", description = "Fetches a specific order by its ID.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @ApiResponse(responseCode = "404", description = "Order not found")
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

    @Operation(summary = "Delete Order REST API", description = "Deletes an existing order by its ID.")
    @ApiResponse(responseCode = "204", description = "Http Status 204 NO CONTENT")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
            orderService.deleteOrder(id);
            return ResponseEntity.noContent().build();
        }
}