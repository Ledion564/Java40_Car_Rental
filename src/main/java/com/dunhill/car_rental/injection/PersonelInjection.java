//package com.dunhill.car_rental.injection;
//
//import com.dunhill.car_rental.entity.Personel;
//import com.dunhill.car_rental.entity.Role;
//import com.dunhill.car_rental.entity.User;
//import com.dunhill.car_rental.repository.PersonelRepository;
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
//public class PersonelInjection {
//
//    private final PersonelRepository personelRepository;
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//
//    @PostConstruct
//    @Transactional
//    public void init() {
//        List<Personel> personels = Arrays.asList(
//                createPersonel("Michael", "Clark", "michael@example.com", "100 Central St", "michael_clark", "password123"),
//                createPersonel("Sarah", "Connor", "sarah@example.com", "200 Central St", "sarah_connor", "password123"),
//                createPersonel("James", "Bond", "james@example.com", "300 Central St", "james_bond", "password123"),
//                createPersonel("Lara", "Croft", "lara@example.com", "400 Central St", "lara_croft", "password123")
//        );
//
//        for (Personel personel : personels) {
//            // Check if a personnel with the same email already exists
//            if (!personelRepository.existsByEmail(personel.getEmail())) {
//                Personel savedPersonel = personelRepository.save(personel);
//                createUserForPersonel(savedPersonel);
//            }
//        }
//    }
//
//    private Personel createPersonel(String firstName, String lastName, String email, String address, String username, String password) {
//        return Personel.builder()
//                .firstName(firstName)
//                .lastName(lastName)
//                .email(email)
//                .address(address)
//                .build();
//    }
//
//    private void createUserForPersonel(Personel personel) {
//        User user = new User();
//        user.setUsername(personel.getEmail()); // Use email as username
//        user.setPassword("password123"); // In a real application, you would hash the password
//        user.setEmail(personel.getEmail());
//        Set<Role> roles = new HashSet<>();
//        Role personelRole = roleRepository.findByRole("ROLE_HR")
//                .orElseThrow(() -> new RuntimeException("Role not found"));
//        roles.add(personelRole);
//        user.setRoles(roles);
//        user.setPersonel(personel); // Associate user with the personnel
//
//        userRepository.save(user);
//    }
//}
