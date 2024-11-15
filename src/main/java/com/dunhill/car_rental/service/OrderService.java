package com.dunhill.car_rental.service;
import com.dunhill.car_rental.dtos.carDto.CarDetails;
import com.dunhill.car_rental.dtos.Invoice;
import com.dunhill.car_rental.dtos.orderDto.OrderRequest;
import com.dunhill.car_rental.entity.*;
import com.dunhill.car_rental.dtos.orderDto.CreateOrderDto;
import com.dunhill.car_rental.entity.enums.OrderStatus;
import com.dunhill.car_rental.repository.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class OrderService {


    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private OrderCarRepository orderCarRepository;
    private CustomerRepository customerRepository;
    private CarRepository carRepository;
    private final TransactionalService transactionalService;


    public Long createOrderBasedOnAuthentication(@Valid OrderRequest orderRequest, Authentication authentication) {
        if (authentication instanceof AnonymousAuthenticationToken || !authentication.isAuthenticated()) {
            // Guest order creation
            return transactionalService.createOrderForGuest(
                    orderRequest.getCars(),
                    orderRequest.getCustomerName(),
                    orderRequest.getCustomerAddress(),
                    orderRequest.getCustomerPhone()
            ).getOrderId();
        }

        // Authenticated user order creation
        String email = authentication.getName();
        return transactionalService.createOrderForPrincipalCustomer(
                orderRequest.getCars(),
                orderRequest.getCustomerName(),
                orderRequest.getCustomerAddress(),
                orderRequest.getCustomerPhone(),
                email
        ).getOrderId();
    }


    public OrderStatus getOrderStatus(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"))
                .getOrderStatus();
    }


    public Map<Long, String> getAllOrdersAndStatuses() {
        List<Order> orders = orderRepository.findAll();
        Map<Long, String> ordersAndStatuses = new HashMap<>();

        for (Order order : orders) {
            ordersAndStatuses.put(order.getOrderId(), order.getOrderStatus().name());
        }
        return ordersAndStatuses;
    }

    private BigDecimal calculateTotal(List<CarDetails> carDetails) {
        BigDecimal total = BigDecimal.ZERO;

        for (CarDetails carDetail : carDetails) {
            total = total.add(BigDecimal.valueOf(carDetail.getPrice()).multiply(BigDecimal.valueOf(carDetail.getQuantity())));
        }
        return total;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    private List<CarDetails> getCarsDetails(Order order) {
        List<CarDetails> carsDetails = new ArrayList<>();
        List<OrderCars> cars = orderCarRepository.findByOrderOrderId(order.getOrderId());

        for (OrderCars orderCar : cars) {
            CarDetails carDetails = new CarDetails();
            carDetails.setName(orderCar.getCar().getBrand() + " " + orderCar.getCar().getModel());
            carDetails.setPrice(orderCar.getCar().getAmount());
            carDetails.setQuantity(orderCar.getQuantity());
            carsDetails.add(carDetails);
        }
        return carsDetails;
    }

    public Invoice getOrderInvoice(Long orderId,Authentication authentication) {
        if(authentication.isAuthenticated()) {
            String usernameOrEmail = authentication.getName();
            User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            Order order = orderRepository.findById(orderId)
                    .orElseThrow(() -> new RuntimeException("Order not found"));
            Set<Role> roleSet = user.getRoles();
            for (Role role : roleSet) {
                if (role.getRole().equals("ROLE_CUSTOMER")) {
                    if (order.getCustomer().getId() == user.getCustomer().getId()) {
                        return createInvoiceFromOrder(order);
                    }
                } else if (role.getRole().equals("ROLE_HR")) {
                    return createInvoiceFromOrder(order);
                }
                else {
                    throw new RuntimeException("Dear customer this does not belong to your order");
                }
            }
            throw new RuntimeException("Your role does not have access to this endpoint");
//            Order order = getOrderById(orderId);
//            return createInvoiceFromOrder(order);
        }
        throw new RuntimeException("Please authenticate in order to process your request");

    }


//    public Invoice getOrderInvoice(Long orderId, Authentication authentication) {
//        if (!authentication.isAuthenticated()) {
//            throw new RuntimeException("Unauthenticated access");
//        }
//
//        String usernameOrEmail = authentication.getName();
//        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Set<Role> roleSet = user.getRoles();
//        boolean isCustomer = roleSet.stream().anyMatch(role -> role.getRole().equals("ROLE_CUSTOMER"));
//        boolean isPersonnel = roleSet.stream().anyMatch(role -> role.getRole().equals("ROLE_PERSONEL"));
//
//        Order order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//
//        if (isCustomer) {
//            if (user.getCustomer() != null && user.getCustomer().getId().equals(order.getCustomer().getId())) {
//                return createInvoiceFromOrder(order);
//            } else {
//                throw new RuntimeException("Dear customer, this order does not belong to you.");
//            }
//        }
//
//        if (isPersonnel) {
//            return createInvoiceFromOrder(order);
//        }
//
//        // Default case: if not a customer or personnel, proceed based on other roles or throw error
//        throw new RuntimeException("Dear personnel, this order does not belong to you.");
//    }


    private Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    private Invoice createInvoiceFromOrder(Order order) {
        Invoice invoice = new Invoice();
        invoice.setOrderId(order.getOrderId());
        invoice.setCars(getCarsDetails(order));
        invoice.setSubTotal(calculateTotal(invoice.getCars()));
        invoice.setTax(invoice.getSubTotal().multiply(BigDecimal.valueOf(0.2)));
        invoice.setTips(invoice.getSubTotal().multiply(BigDecimal.valueOf(0.2)));
        invoice.setGrandTotal(invoice.getSubTotal().add(invoice.getTax()).add(invoice.getTips()));
        invoice.setStatus(order.getOrderStatus());
        return invoice;
    }

    public Long updateOrderBasedOnAuthentication(Long orderId, @Valid OrderRequest orderRequest, Authentication authentication) {
        if (authentication instanceof AnonymousAuthenticationToken || !authentication.isAuthenticated()) {
            // Update order for a guest
            return transactionalService.updateOrderForGuest(
                    orderId,
                    orderRequest.getCars(),
                    orderRequest.getCustomerName(),
                    orderRequest.getCustomerAddress(),
                    orderRequest.getCustomerPhone()
            ).getOrderId();
        }

        // Update order for an authenticated user
        String email = authentication.getName();
        return transactionalService.updateOrderForPrincipalClient(
                orderId,
                orderRequest.getCars(),
                orderRequest.getCustomerName(),
                orderRequest.getCustomerAddress(),
                orderRequest.getCustomerPhone(),
                email
        ).getOrderId();
    }





    // Method to delete an order by ID
    @Transactional
    public void deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(orderId);
    }

}