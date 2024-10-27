//package com.dunhill.car_rental.injection;
//
//import com.dunhill.car_rental.entity.Customer;
//import com.dunhill.car_rental.entity.Role;
//import com.dunhill.car_rental.entity.User;
//import com.dunhill.car_rental.repository.CustomerRepository;
//import com.dunhill.car_rental.repository.RoleRepository;
//import com.dunhill.car_rental.repository.UserRepository;
//import jakarta.annotation.PostConstruct;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Component
//@AllArgsConstructor
//public class CustomerInjection {
//
//    private final CustomerRepository customerRepository;
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//
//    @PostConstruct
//    @Transactional
//    public void init() {
//        List<Customer> customers = Arrays.asList(
//                createCustomer("John", "Doe", "1234567890", "123 Elm St", "john_doe", "password123"),
//                createCustomer("Jane", "Smith", "0987654321", "456 Oak St", "jane_smith", "password123"),
//                createCustomer("Alice", "Johnson", "1122334455", "789 Pine St", "alice_johnson", "password123"),
//                createCustomer("Bob", "Brown", "5566778899", "321 Maple St", "bob_brown", "password123")
//        );
//
//        for (Customer customer : customers) {
//            // Check if a customer with the same phone number already exists
//            if (!customerRepository.existsByPhone(customer.getPhone())) {
//                Customer savedCustomer = customerRepository.save(customer);
//                User user = new User();
//                user.setUsername(customer.getFirstName()); // Or use another unique identifier
//                user.setPassword("password123"); // In a real application, you would hash the password
//                user.setEmail(customer.getFirstName() + "@example.com"); // Use a valid email format
//                Set<Role> roles = new HashSet<>();
//                Role roleCustomer = roleRepository.findByRole("ROLE_CUSTOMER")
//                        .orElseThrow(() -> new RuntimeException("Role not found"));
//                roles.add(roleCustomer);
//                user.setRoles(roles);
//                user.setCustomer(savedCustomer); // Associate user with the customer
//
//                userRepository.save(user);
//            }
//        }
//    }
//
//    private Customer createCustomer(String firstName, String lastName, String phone, String address, String username, String password) {
//        return Customer.builder()
//                .firstName(firstName)
//                .lastName(lastName)
//                .phone(phone)
//                .address(address)
//                .build();
//    }
//
////    private void createUserForCustomer(Customer customer) {
////        User user = new User();
////        user.setUsername(customer.getPhone()); // Or use another unique identifier
////        user.setPassword("password123"); // In a real application, you would hash the password
////        user.setEmail(customer.getPhone() + "@example.com"); // Use a valid email format
////        Set<Role> roles = new HashSet<>();
////        Role roleCustomer = roleRepository.findByRole("ROLE_CUSTOMER")
////                .orElseThrow(() -> new RuntimeException("Role not found"));
////        roles.add(roleCustomer);
////        user.setRoles(roles);
////        user.setCustomer(customer); // Associate user with the customer
////
////        userRepository.save(user);
////    }
//}
