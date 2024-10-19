package com.dunhill.car_rental.security;


import com.dunhill.car_rental.entity.Role;
import com.dunhill.car_rental.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class MyUserDetails implements UserDetails {


    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> listOfAllRolesForASingleUser = user.getRoles();
        List<SimpleGrantedAuthority> listOfAllAccesses = new ArrayList<>();
        for(Role role : listOfAllRolesForASingleUser) {
            listOfAllAccesses.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return listOfAllAccesses;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
