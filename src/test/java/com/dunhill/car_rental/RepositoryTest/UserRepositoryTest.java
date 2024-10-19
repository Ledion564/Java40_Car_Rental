package com.dunhill.car_rental.RepositoryTest;

import com.dunhill.car_rental.entity.User;
import com.dunhill.car_rental.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user1;
    private User user2;
    private User user3;

//    @BeforeEach
//    void setup(){
//        user1= User.builder().id(1L).username("ferit").email("gmail").password("bro").createdAt(LocalDateTime.now()).build();
//        user2= User.builder().id(2L).username("ferit").email("gmail").password("bro").createdAt(LocalDateTime.now()).build();
//        user3= User.builder().id(3L).username("ferit").email("gmail").password("bro").createdAt(LocalDateTime.now()).build();
//    }

    @Test
    public  void testSave(){
        User saved = userRepository.save(user1);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isPositive();
        assertThat(saved.getUsername()).isEqualTo("ferit");
    }

    @Test
    public void testGetAll(){

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        List<User> found = userRepository.findAll();
        assertThat(found).isNotNull();
    }

    @Test
    public void testGetById(){
        userRepository.save(user1);
        User saved = userRepository.findById(1L).get();
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isPositive();
        assertThat(saved.getId()).isEqualTo(1L);
    }

    @Test
    public void testDelete(){
        User saved = userRepository.save(user1);
        userRepository.delete(saved);
        Optional<User> found = userRepository.findById(saved.getId());
        assertThat(found).isNotPresent();
    }
}
