package com.dunhill.car_rental.security;


import com.dunhill.car_rental.entity.User;
import com.dunhill.car_rental.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User existingUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));


//        Set<GrantedAuthority> authorities = existingUser.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toSet());

        return new MyUserDetails(existingUser);

//        return new  org.springframework.security.core.userdetails.User(existingUser.getUsername(),existingUser.getPassword(),authorities);
    }
}
