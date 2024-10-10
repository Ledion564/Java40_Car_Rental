package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.Entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    // Query with parameters
    @Query("SELECT R FROM Rental R WHERE R.name = :name AND R.internetDomain = :internetDomain")
    List<Rental> findByNameAndInternetDomain(@Param("name") String name, @Param("internetDomain") String internetDomain);

    // Query with index
    @Query("SELECT R FROM Rental R WHERE R.contactAddress = ?1 AND R.owner = ?2")
    List<Rental> findByContactAddressAndOwnerWithIndex(@Param("contactAddress") String contactAddress, @Param("owner") String owner);

    // Query native with parameters
    @Query(value = "SELECT * FROM rentals WHERE name = :name AND internet_domain = :internetDomain", nativeQuery = true)
    List<Rental> findByNameAndInternetDomainNativeQueryWithParams(@Param("name") String name, @Param("internetDomain") String internetDomain);

    @Query(value = "SELECT * FROM rentals WHERE contact_address = ?1 AND owner = ?2", nativeQuery = true)
    List<Rental> findByContactAddressAndOwnerNativeQueryWithIndex(@Param("contactAddress") String contactAddress, @Param("owner") String owner);

    @Query("SELECT R FROM Rental R WHERE R.name = :name AND R.internetDomain = :internetDomain AND R.contactAddress = :contactAddress")
    List<Rental> findByNameAndInternetDomainAndContactAddress(@Param("name") String name, @Param("internetDomain") String internetDomain, @Param("contactAddress") String contactAddress);


    @Query("SELECT r FROM Rental r WHERE " +
            "(:name IS NULL OR r.name = :name) " +
            "AND (:internetDomain IS NULL OR r.internetDomain = :internetDomain) " +
            "AND (:contactAddress IS NULL OR :contactAddress = '' OR r.contactAddress = :contactAddress) " +
            "AND (:owner IS NULL OR :owner = '' OR r.owner = :owner)")
    List<Rental> findByNameAndInternetDomainAndContactAddressAndOwner( String name,String internetDomain, String contactAddress, String owner);
}
