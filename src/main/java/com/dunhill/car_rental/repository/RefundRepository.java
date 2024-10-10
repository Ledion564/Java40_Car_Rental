package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.Entity.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface RefundRepository extends JpaRepository<Refund, Long> {

    //query  with param
    @Query("SELECT R from Refund R WHERE R.comments =:comments AND R.surcharge =:surcharge ")
    List<Refund> findByCommentsAndSurcharge (String comments , BigDecimal surcharge);


    //Query with index
    @Query("SELECT R from Refund R WHERE R.comments =?1 AND R.surcharge =?2")
    List<Refund> findByCommentsAndSurchargeWithIndex(@Param("comments") String comments, @Param("surcharge") BigDecimal surcharge);

    // query native with param
    @Query( value = "SELECT * from refunds  WHERE comments =:comments AND surcharge =:surcharge " , nativeQuery=true)
    List<Refund> findByCommentsAndSurchargeNativeQueryWithParams (@Param("comments") String comments ,@Param("surcharge") BigDecimal surcharge);

    @Query( value = "SELECT * from refunds  WHERE comments =?1 AND surcharge =?2 " , nativeQuery=true)
    List<Refund> findByCommentsAndSurchargeNativeQueryWithIndex (@Param("comments") String comments ,@Param("surcharge") BigDecimal surcharge);

    @Query("SELECT r FROM Refund r WHERE " +
            "(:dateOfReturn IS NULL OR r.dateOfReturn = :dateOfReturn) " +
            "AND (:surcharge IS NULL OR r.surcharge = :surcharge) " +
            "AND (:comments IS NULL OR :comments = '' OR r.comments = :comments)")
    List<Refund> findByDateOfReturnAndSurchargeAndComments(LocalDate dateOfReturn, BigDecimal surcharge, String comments);


}
