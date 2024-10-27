package com.dunhill.car_rental.controller;
import com.dunhill.car_rental.dtos.orderDto.CreateOrderDto;
import com.dunhill.car_rental.dtos.Invoice;
import com.dunhill.car_rental.dtos.orderDto.OrderRequest;
import com.dunhill.car_rental.entity.Order;
import com.dunhill.car_rental.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<Long> createOrder(@RequestBody OrderRequest orderRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long orderId = orderService.createOrderBasedOnAuthentication(orderRequest, authentication);
        return ResponseEntity.ok(orderId);
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

    @Operation(summary = "Update an order")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Order updated successfully"),
            @ApiResponse(responseCode = "404", description = "Order not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Long> updateOrder(
            @Parameter(description = "Order ID to update", required = true) Long id,
            @RequestBody OrderRequest orderRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long orderId = orderService.updateOrderBasedOnAuthentication(id, orderRequest, authentication);
        return ResponseEntity.ok(orderId);
    }

    @Operation(summary = "Delete Order REST API", description = "Deletes an existing order by its ID.")
    @ApiResponse(responseCode = "204", description = "Http Status 204 NO CONTENT")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
            orderService.deleteOrder(id);
            return ResponseEntity.noContent().build();
        }

    @Operation(summary = "Get invoice by order ID")
    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER','ROLE_HR')")
    @GetMapping("/invoice/{id}")
    public ResponseEntity<Invoice> getOrderInvoice(
            @Parameter(description = "Order ID") @PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(orderService.getOrderInvoice(id,authentication));
    }
}