package com.dunhill.car_rental.service;

import com.dunhill.car_rental.dtos.CreateCustomerDto;
import com.dunhill.car_rental.dtos.CreatePersonelDto;
import com.dunhill.car_rental.dtos.LoginDto;
import com.dunhill.car_rental.entity.Customer;
import com.dunhill.car_rental.entity.Personel;
import com.dunhill.car_rental.entity.Role;
import com.dunhill.car_rental.entity.User;
import com.dunhill.car_rental.repository.CustomerRepository;
import com.dunhill.car_rental.repository.PersonelRepository;
import com.dunhill.car_rental.repository.RoleRepository;
import com.dunhill.car_rental.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AccountService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private CustomerRepository customerRepository;
    private RoleRepository roleRepository;
    private PersonelRepository personelRepository;
    private AuthenticationManager authenticationManager;

    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User logged in successfully";
    }

    @Transactional
    public String register(CreateCustomerDto createCustomerDto){
        Customer customer = new Customer();
        customer.setFirstName(createCustomerDto.getFirstName());
        customer.setLastName(createCustomerDto.getLastName());
        customer.setPhone(createCustomerDto.getPhone());
        customer.setAddress( createCustomerDto.getAddress());
        Customer savedCustomer = customerRepository.save(customer);

        User user = new User();
        user.setUsername(createCustomerDto.getUsername());
        user.setPassword(passwordEncoder.encode(createCustomerDto.getPassword()));
        user.setEmail(createCustomerDto.getEmail());
        Set<Role> roles = new HashSet<>();
        Role roleCustomer = roleRepository.findByRole("ROLE_CUSTOMER")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        roles.add(roleCustomer);
        user.setRoles(roles);
        user.setCustomer(savedCustomer);
        userRepository.save(user);

        return "Customer registered successfully";
    }

    @Transactional
    public String registerPersonel(CreatePersonelDto createPersonelDto){
        Personel personel= new Personel();
        personel.setFirstName(createPersonelDto.getFirstName());
        personel.setLastName(createPersonelDto.getLastName());
        personel.setEmail(createPersonelDto.getEmail());
        personel.setAddress( createPersonelDto.getAddress());
        Personel savedPersonel = personelRepository.save(personel);

        User user = new User();
        user.setUsername(createPersonelDto.getUsername());
        user.setPassword(passwordEncoder.encode(createPersonelDto.getPassword()));
        user.setEmail(createPersonelDto.getEmail());
        user.setPersonel(savedPersonel);
        Set<Role> roleSet = new HashSet<>();
        Role personelRole = roleRepository.findByRole("ROLE_HR")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        Role clientRole = roleRepository.findByRole("ROLE_MANAGER")
                        .orElseThrow(() -> new RuntimeException("Role not found"));
        roleSet.add(personelRole);
        roleSet.add(clientRole);
        user.setRoles(roleSet);
        userRepository.save(user);
        return "Personel registered successfully";

    }


}
