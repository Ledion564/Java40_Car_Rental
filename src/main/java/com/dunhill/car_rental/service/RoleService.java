package com.dunhill.car_rental.service;

import com.dunhill.car_rental.entity.Role;
import com.dunhill.car_rental.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final List<Role> roleList = new ArrayList<>();

    // Define roles
    private final Role roleAdmin = Role.builder().roleId(1L).role("ROLE_ADMIN").build();
    private final Role roleManager = Role.builder().roleId(2L).role("ROLE_MANAGER").build();
    private final Role roleHr = Role.builder().roleId(3L).role("ROLE_HR").build();
    private final Role roleEmployee = Role.builder().roleId(4L).role("ROLE_EMPLOYEE").build();
    private final Role roleCustomer = Role.builder().roleId(5L).role("ROLE_CUSTOMER").build();
    private final Role roleFinance = Role.builder().roleId(6L).role("ROLE_FINANCE").build();
    private final Role roleMarketing = Role.builder().roleId(7L).role("ROLE_MARKETING").build();

    @PostConstruct
    public void init() {
        roleList.add(roleAdmin);
        roleList.add(roleManager);
        roleList.add(roleHr);
        roleList.add(roleEmployee);
        roleList.add(roleCustomer);
        roleList.add(roleFinance);
        roleList.add(roleMarketing);
        saveRoles();
    }

    public void saveRoles() {
        for (Role role : roleList) {
            if (!roleRepository.existsById(role.getRoleId())) { // Check if the role already exists
                roleRepository.save(role);
            }
        }
    }
}
