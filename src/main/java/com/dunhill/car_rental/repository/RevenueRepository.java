package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.entity.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RevenueRepository extends JpaRepository<Revenue, Long> {


    //JQPL Query with parameters
    @Query("SELECT r FROM Revenue r where r.totalAmount = :totalAmount")
    List<Revenue> findByTotalAmount(@Param("totalAmount") double totalAmount);


    //JQPL Query with index
    @Query("SELECT r FROM Revenue r where r.totalAmount = ?1")
    List<Revenue> findByTotalAmountWithIndex( double totalAmount);


    //Native Query with parameters
    @Query(value = "SELECT * FROM revenues  where total_amount = :totalAmount",nativeQuery = true)
    List<Revenue> findByTotalAmountNative(@Param("totalAmount") double totalAmount);

    //Native Query with index
    @Query(value = "SELECT * FROM revenues  where total_amount = ?1",nativeQuery = true)
    List<Revenue> findByTotalAmountNativeWithIndex(double totalAmount);


    //JQPL Query with 2 parameters
    @Query("SELECT R FROM Revenue R WHERE R.totalAmount=:totalAmount and R.approvedAmount=:approvedAmount")
    List<Revenue> findByTotalAmountAndApprovedAmount(double totalAmount, double approvedAmount);

    //JQPL Query with 2 index
    @Query("SELECT R FROM Revenue R WHERE R.totalAmount=?1 and R.approvedAmount=?2")
    List<Revenue> findByTotalAmountAndApprovedAmountWithIndex(double totalAmount, double approvedAmount);

    //Native Query with 2 parameters
    @Query(value = "SELECT * FROM revenues WHERE total_amount = :totalAmount AND approved_amount = :approvedAmount", nativeQuery=true)
    List<Revenue> findByTotalAmountAndApprovedAmountNative(double totalAmount, double approvedAmount);

    //Native Query with index
    @Query(value = "SELECT * FROM revenues  where total_amount = ?1 and R.approved_amount=?2",nativeQuery = true)
    List<Revenue> findByTotalAmountNativeWithIndex(double totalAmount, double approvedAmount);


}
