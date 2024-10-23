package com.dunhill.car_rental.service;
import com.dunhill.car_rental.entity.Car;
import com.dunhill.car_rental.entity.Customer;
import com.dunhill.car_rental.entity.Order;
import com.dunhill.car_rental.entity.OrderCars;
import com.dunhill.car_rental.dtos.CreateOrderDto;
import com.dunhill.car_rental.entity.enums.OrderStatus;
import com.dunhill.car_rental.repository.CarRepository;
import com.dunhill.car_rental.repository.CustomerRepository;
import com.dunhill.car_rental.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CarRepository carRepository;

    @Transactional
    public Order createOrder(CreateOrderDto createOrderDto) {

        Customer customer;
        if (createOrderDto.getCustomerId() != null) {
            customer = customerRepository.findById(createOrderDto.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
        } else {

            customer = new Customer();
            customer.setFirstName(createOrderDto.getFirstName());
            customer.setLastName(createOrderDto.getLastName());
            customer.setPhone(createOrderDto.getPhone());
            customer.setAddress(createOrderDto.getAddress());
            customer = customerRepository.save(customer);
        }


        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.PROCESSING);
        order.setCustomer(customer);


        List<OrderCars> orderCarsList = new ArrayList<>();
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
}