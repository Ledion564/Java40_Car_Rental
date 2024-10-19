package com.dunhill.car_rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dunhill.car_rental.entity.Role;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

//   @Modifying
//   @Transactional
//   @Query(value = "CREATE ROLE IF NOT EXISTS 'ROLE_ADMIN'", nativeQuery = true)
//   void createAdminRole();
//
//   @Modifying
//   @Transactional
//   @Query(value = "CREATE ROLE IF NOT EXISTS 'ROLE_MANAGER'", nativeQuery = true)
//   void createManagerRole();
//
//   @Modifying
//   @Transactional
//   @Query(value = "CREATE ROLE IF NOT EXISTS 'ROLE_HR'", nativeQuery = true)
//   void createHrRole();
//
//   @Modifying
//   @Transactional
//   @Query(value = "CREATE ROLE IF NOT EXISTS 'ROLE_EMPLOYEE'", nativeQuery = true)
//   void createEmployeeRole();
//
//   @Modifying
//   @Transactional
//   @Query(value = "CREATE ROLE IF NOT EXISTS 'ROLE_CUSTOMER'", nativeQuery = true)
//   void createCustomerRole();
//
//   @Modifying
//   @Transactional
//   @Query(value = "CREATE ROLE IF NOT EXISTS 'ROLE_FINANCE'", nativeQuery = true)
//   void createFinanceRole();
//
//   @Modifying
//   @Transactional
//   @Query(value = "CREATE ROLE IF NOT EXISTS 'ROLE_MARKETING'", nativeQuery = true)
//   void createMarketingRole();

//   @Modifying
//   @Transactional
//   @Query(value = "GRANT ALL PRIVILEGES ON *.* TO 'admin'", nativeQuery = true)
//   void grantAdminPrivileges();



   Optional<Role> findByRole(String name);

}
