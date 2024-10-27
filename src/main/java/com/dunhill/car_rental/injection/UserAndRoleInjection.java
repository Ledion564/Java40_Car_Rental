//package com.dunhill.car_rental.injection;
//
//import com.dunhill.car_rental.entity.Customer;
//import com.dunhill.car_rental.entity.Personel;
//import com.dunhill.car_rental.entity.Role;
//import com.dunhill.car_rental.entity.User;
//import com.dunhill.car_rental.repository.CustomerRepository;
//import com.dunhill.car_rental.repository.PersonelRepository;
//import com.dunhill.car_rental.repository.RoleRepository;
//import com.dunhill.car_rental.repository.UserRepository;
//import jakarta.annotation.PostConstruct;
//import lombok.AllArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.crypto.password.PasswordEncoder;
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
//public class UserAndRoleInjection {
//    private static final Logger logger = LoggerFactory.getLogger(UserAndRoleInjection.class);
//
//    private final RoleRepository roleRepository;
//    private final UserRepository userRepository;
//    private final PersonelRepository personelRepository;
//    private final CustomerRepository customerRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @PostConstruct
//    @Transactional
//    public void init() {
//        // Save roles first
//        saveRoles();
//
//        // Create and save personnel
//        List<Personel> personels = Arrays.asList(
//                createPersonel("Michael", "Clark", "michael@example.com", "100 Central St"),
//                createPersonel("Sarah", "Connor", "sarah@example.com", "200 Central St"),
//                createPersonel("James", "Bond", "james@example.com", "300 Central St"),
//                createPersonel("Lara", "Croft", "lara@example.com", "400 Central St")
//        );
//
//        for (Personel personel : personels) {
//            if (!personelRepository.existsByEmail(personel.getEmail())) {
//                Personel savedPersonel = personelRepository.save(personel);
//                createUserForPersonel(savedPersonel);
//            }
//        }
//
//        // Create and save customers
//        List<Customer> customers = Arrays.asList(
//                createCustomer("John", "Doe", "1234567890", "123 Elm St"),
//                createCustomer("Jane", "Smith", "0987654321", "456 Oak St"),
//                createCustomer("Alice", "Johnson", "1122334455", "789 Pine St"),
//                createCustomer("Bob", "Brown", "5566778899", "321 Maple St")
//        );
//
//        for (Customer customer : customers) {
//            if (!customerRepository.existsByPhone(customer.getPhone())) {
//                Customer savedCustomer = customerRepository.save(customer);
//                createUserForCustomer(savedCustomer);
//            }
//        }
//    }
//
//    private void saveRoles() {
//        String[] roles = {"ROLE_ADMIN", "ROLE_HR", "ROLE_CUSTOMER", "ROLE_MANAGER", "ROLE_SUPPORT", "ROLE_DRIVER", "ROLE_EXECUTIVE"};
//
//        for (String roleName : roles) {
//            if (!roleRepository.existsByRole(roleName)) {
//                Role role = new Role();
//                role.setRole(roleName);
//                roleRepository.save(role);
//            }
//        }
//    }
//
//    private Personel createPersonel(String firstName, String lastName, String email, String address) {
//        return Personel.builder()
//                .firstName(firstName)
//                .lastName(lastName)
//                .email(email)
//                .address(address)
//                .build();
//    }
//
//    private void createUserForPersonel(Personel personel) {
//        try {
//            User user = new User();
//            user.setUsername(personel.getEmail()); // Use email as username
//            user.setPassword(passwordEncoder.encode("password123")); // Hash the password
//            user.setEmail(personel.getEmail()); // Correct email format
//
//            Set<Role> roles = new HashSet<>();
//            Role personelRole = roleRepository.findByRole("ROLE_HR")
//                    .orElseThrow(() -> new RuntimeException("Role not found"));
//            roles.add(personelRole);
//            user.setRoles(roles);
//            user.setPersonel(personel); // Associate user with the personnel
//
//            userRepository.save(user); // Save the user
//
//            logger.info("User created for personnel: {}", user.getUsername());
//        } catch (Exception e) {
//            logger.error("Error saving user for personnel {}: {}", personel.getEmail(), e.getMessage(), e);
//        }
//    }
//
//    private Customer createCustomer(String firstName, String lastName, String phone, String address) {
//        return Customer.builder()
//                .firstName(firstName)
//                .lastName(lastName)
//                .phone(phone)
//                .address(address)
//                .build();
//    }
//
//    private void createUserForCustomer(Customer customer) {
//        try {
//            User user = new User();
//            user.setUsername(customer.getPhone()); // Unique identifier for username
//            user.setPassword(passwordEncoder.encode("password123")); // Hash the password
//            user.setEmail(customer.getPhone() + "@example.com"); // Generate a valid email
//
//            Set<Role> roles = new HashSet<>();
//            Role roleCustomer = roleRepository.findByRole("ROLE_CUSTOMER")
//                    .orElseThrow(() -> new RuntimeException("Role not found"));
//            roles.add(roleCustomer);
//            user.setRoles(roles);
//            user.setCustomer(customer); // Associate user with the customer
//
//            userRepository.save(user); // Save the user
//
//            logger.info("User created for customer: {}", user.getUsername());
//        } catch (Exception e) {
//            logger.error("Error saving user for customer {}: {}", customer.getPhone(), e.getMessage(), e);
//        }
//    }
//}
