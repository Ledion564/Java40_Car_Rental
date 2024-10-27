package com.dunhill.car_rental.service;
import com.dunhill.car_rental.entity.*;
import com.dunhill.car_rental.entity.enums.OrderStatus;
import com.dunhill.car_rental.repository.CustomerRepository;
import com.dunhill.car_rental.repository.OrderRepository;
import com.dunhill.car_rental.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.ArrayList;
import com.dunhill.car_rental.repository.CarRepository;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@AllArgsConstructor
public class TransactionalService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final Lock lock = new ReentrantLock();

    @Transactional
    public Order createOrderForGuest(Map<Long, Integer> cars, String customerName, String customerAddress, String customerPhone) {
        Customer customer = createCustomer(customerName, customerAddress, customerPhone);
        Order order = createOrderWithCars(cars);
        order.setCustomer(customer);
        customerRepository.save(customer);
        return orderRepository.save(order);
    }

    @Transactional
    public Order createOrderForPrincipalCustomer(Map<Long, Integer> cars, String customerName, String customerAddress, String customerPhone, String email) {
        Customer customer = findClientByEmail(email);

        if (customerName != null && !customerName.isEmpty() && !customerName.equals(customer.getFirstName())) {
            customer.setFirstName(customerName);
        }
        if (customerAddress != null && !customerAddress.isEmpty() && !customerAddress.equals(customer.getAddress())) {
            customer.setAddress(customerAddress);
        }
        if (customerPhone != null && !customerPhone.isEmpty() && !customerPhone.equals(customer.getPhone())) {
            customer.setPhone(customerPhone);
        }

        Order order = createOrderWithCars(cars);
        order.setCustomer(customer);
        return orderRepository.save(order);
    }

    private Customer createCustomer(String customerName, String customerAddress, String customerPhone) {
        Customer customer = new Customer();
        customer.setFirstName(customerName);
        customer.setAddress(customerAddress);
        customer.setPhone(customerPhone);
        return customer;
    }

    private Order createOrderWithCars(Map<Long, Integer> cars) {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.RECEIVED);
        order.setOrderDate(LocalDateTime.now());

        List<OrderCars> orderCarsList = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : cars.entrySet()) {
            Car car = carRepository.findById(entry.getKey())
                    .orElseThrow(() -> new RuntimeException("Car not found"));

            OrderCars orderCar = new OrderCars();
            orderCar.setOrder(order);
            orderCar.setCar(car);
            orderCar.setQuantity(entry.getValue());
            orderCarsList.add(orderCar);
        }

        order.setOrderCars(orderCarsList);
        return order;
    }

    private Customer findClientByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email " + email));
        return customerRepository.findById(user.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Transactional
    public Order updateOrderForGuest(Long orderId, Map<Long, Integer> cars, String customerName, String customerAddress, String customerPhone) {
        // Retrieve the existing order
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Update customer information or create a new one if not found
        Customer customer = order.getCustomer();
        if (customer == null) {
            customer = createCustomer(customerName, customerAddress, customerPhone);
            customerRepository.save(customer);
        } else {
            customer.setFirstName(customerName);
            customer.setAddress(customerAddress);
            customer.setPhone(customerPhone);
            customerRepository.save(customer);
        }
        order.setCustomer(customer);

        // Update cars in the order
        updateOrderWithCars(order, cars);

        return orderRepository.save(order);
    }

    @Transactional
    public Order updateOrderForPrincipalClient(Long orderId, Map<Long, Integer> cars, String customerName, String customerAddress, String customerPhone, String email) {
        // Retrieve the existing order
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Retrieve the customer by email and update their information
        Customer customer = findClientByEmail(email);

        if (customerName != null && !customerName.isEmpty() && !customerName.equals(customer.getFirstName())) {
            customer.setFirstName(customerName);
        }
        if (customerAddress != null && !customerAddress.isEmpty() && !customerAddress.equals(customer.getAddress())) {
            customer.setAddress(customerAddress);
        }
        if (customerPhone != null && !customerPhone.isEmpty() && !customerPhone.equals(customer.getPhone())) {
            customer.setPhone(customerPhone);
        }
        customerRepository.save(customer);

        order.setCustomer(customer);

        // Update cars in the order
        updateOrderWithCars(order, cars);

        return orderRepository.save(order);
    }

    // Helper method to update cars in the order
    private void updateOrderWithCars(Order order, Map<Long, Integer> cars) {
        order.getOrderCars().clear();
        for (Map.Entry<Long, Integer> entry : cars.entrySet()) {
            Car car = carRepository.findById(entry.getKey())
                    .orElseThrow(() -> new RuntimeException("Car not found"));
            OrderCars orderCar = new OrderCars();
            orderCar.setOrder(order);
            orderCar.setCar(car);
            orderCar.setQuantity(entry.getValue());
            order.getOrderCars().add(orderCar);
        }
    }



}
