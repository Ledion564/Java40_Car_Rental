package com.dunhill.car_rental.RepositoryTest;

import com.dunhill.car_rental.entity.Rental;
import com.dunhill.car_rental.repository.RentalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RentalRepositoryTest {

    @Autowired
    private RentalRepository rentalRepository;
    private Rental rental;

    @BeforeEach
    void setUp() {
        rental = Rental.builder().id(1L).name("Test Rental").internetDomain("test.com").contactAddress("123 Test St.").owner("Test Owner").logotype("test_logo.png").build();
    }

    @Test
    public void testGetAll() {
        rentalRepository.save(rental);
        List<Rental> rentals = rentalRepository.findAll();
        assertThat(rentals).isNotNull();
        assertThat(rentals).contains(rental);
    }

    @Test
    void testSaveRental() {
        rentalRepository.save(rental);
        assertThat(rental.getId()).isNotNull();
    }

    @Test
    void testDeleteRental() {
        rentalRepository.save(rental);
        rentalRepository.deleteById(rental.getId());
        assertThat(rentalRepository.findById(rental.getId())).isEmpty();
    }

    @Test
    void testUpdateRental() {
        rentalRepository.save(rental);
        rental.setName("Updated Rental");
        rentalRepository.save(rental);
        assertThat(rentalRepository.findById(rental.getId())).isPresent();
        assertThat(rentalRepository.findById(rental.getId()).get().getName()).isEqualTo("Updated Rental");
    }

    @Test
    void testFindByNameAndInternetDomain() {
        rentalRepository.save(rental);
        List<Rental> rentalList = rentalRepository.findByNameAndInternetDomain(rental.getName(), rental.getInternetDomain());
        assertThat(rentalList).isNotNull();
        assertThat(rentalList).contains(rental);
    }

    @Test
    void testFindByContactAddressAndOwner() {
        rentalRepository.save(rental);
        List<Rental> rentalList = rentalRepository.findByContactAddressAndOwnerWithIndex(rental.getContactAddress(), rental.getOwner());
        assertThat(rentalList).isNotNull();
        assertThat(rentalList).contains(rental);
    }
}