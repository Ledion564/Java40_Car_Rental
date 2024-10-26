package com.dunhill.car_rental.service;
import com.dunhill.car_rental.entity.*;
import com.dunhill.car_rental.dtos.CreateOrderDto;
import com.dunhill.car_rental.entity.enums.OrderStatus;
import com.dunhill.car_rental.mapper.CategoryMapper;
import com.dunhill.car_rental.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {


    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private UserCustomerRepository userCustomerRepository;
    private CustomerRepository customerRepository;
    private CarRepository carRepository;

    @Transactional
    public Order createOrder(CreateOrderDto createOrderDto, Authentication authentication) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.PROCESSING);
        List<OrderCars> orderCarsList = new ArrayList<>();

        if (authentication instanceof AnonymousAuthenticationToken || !authentication.isAuthenticated()) {
            // Create new Customer for anonymous user
            Customer customer = new Customer();
            customer.setFirstName(createOrderDto.getFirstName());
            customer.setLastName(createOrderDto.getLastName());
            customer.setPhone(createOrderDto.getPhone());
            customer.setAddress(createOrderDto.getAddress());
            customer = customerRepository.save(customer);
            order.setCustomer(customer);
        } else {
            // Retrieve the authenticated user and find their customer
            String usernameOrEmail = authentication.getName();
            User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Ensure user has a linked customer
            Customer registeredCustomer = user.getCustomer();
            if (registeredCustomer == null) {
                throw new RuntimeException("Customer not found for the authenticated user.");
            }

            order.setCustomer(registeredCustomer);
        }

        // Add cars to the order
        for (CreateOrderDto.OrderCarDto orderCarDto : createOrderDto.getOrderCars()) {
            Car car = carRepository.findById(orderCarDto.getCarId())
                    .orElseThrow(() -> new RuntimeException("Car not found"));
            OrderCars orderCar = new OrderCars();
            orderCar.setCar(car);
            orderCar.setOrder(order);
            orderCar.setQuantity(orderCarDto.getQuantity());

            orderCarsList.add(orderCar);
        }

        order.setOrderCars(orderCarsList);
        return orderRepository.save(order);
    }


    // Method to get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Method to update an order by ID
//    @Transactional
//    public Order updateOrder(Long orderId, CreateOrderDto createOrderDto) {
//        Order order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//
//        // Update customer details
//        Customer customer;
//        if (createOrderDto.getCustomerId() != null) {
//            customer = customerRepository.findById(createOrderDto.getCustomerId())
//                    .orElseThrow(() -> new RuntimeException("Customer not found"));
//        } else {
//            customer = order.getCustomer();
//            customer.setFirstName(createOrderDto.getFirstName());
//            customer.setLastName(createOrderDto.getLastName());
//            customer.setPhone(createOrderDto.getPhone());
//            customer.setAddress(createOrderDto.getAddress());
//            customer = customerRepository.save(customer);
//        }
//
//        order.setCustomer(customer);
//        order.setOrderDate(LocalDateTime.now());
//        order.setOrderStatus(createOrderDto.getOrderStatus());
//
//        // Update order cars
//        List<OrderCars> orderCarsList = new ArrayList<>();
//        for (CreateOrderDto.OrderCarDto orderCarDto : createOrderDto.getOrderCars()) {
//            Car car = carRepository.findById(orderCarDto.getCarId())
//                    .orElseThrow(() -> new RuntimeException("Car not found"));
//
//            OrderCars orderCar = new OrderCars();
//            orderCar.setCar(car);
//            orderCar.setOrder(order);
//            orderCar.setQuantity(orderCarDto.getQuantity());
//
//            orderCarsList.add(orderCar);
//        }
//        order.setOrderCars(orderCarsList);
//
//        return orderRepository.save(order);
//    }

    // Method to delete an order by ID
    @Transactional
    public void deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(orderId);
    }

}