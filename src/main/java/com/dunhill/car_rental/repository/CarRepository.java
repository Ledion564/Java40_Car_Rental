package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.Entity.Car;
import com.dunhill.car_rental.Entity.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {

    //JQPL Query with parameters
//    @Query("SELECT c FROM Car c WHERE c.brand=:brand AND c.model=:model AND c.bodyType=:bodyType AND c.manufactureYear=:manufactureYear AND c.colour=:colour AND c.mileAge=:mileage AND c.amount=:amount")
    @Query("SELECT c FROM Car c WHERE " +
            "(:brand IS NULL OR :brand = '' OR c.brand = :brand) " +
            "AND (:model IS NULL OR :model = '' OR c.model = :model) " +
            "AND (:bodyType IS NULL OR :bodyType = '' OR c.bodyType = :bodyType) " +
            "AND (:manufactureYear IS NULL OR c.manufactureYear = :manufactureYear) " +
            "AND (:colour IS NULL OR :colour = '' OR c.colour = :colour) " +
            "AND (:mileage IS NULL OR c.mileAge = :mileage) " +
            "AND (:amount IS NULL OR c.amount = :amount)")
    List<Car> findByBrandAndModelAndBodyTypeAndManufactureYearAndColourAndMileAgeAndAmount(String brand, String model, String bodyType, LocalDate manufactureYear, String colour, Long mileage, Long amount);

    //JQPL Query with index
    @Query("SELECT c FROM Car c WHERE c.brand=?1 AND c.model=?2 AND c.bodyType=?3 AND c.manufactureYear=?4 AND c.colour=?5 AND c.mileAge=?6 AND c.amount=?7")
    List<Car> findByBrandAndModelAndBodyTypeAndManufactureYearAndColourAndMileAgeAndAmountWithIndex(String brand, String model, String bodyType, LocalDate manufactureYear, String colour, Long mileage, Long amount);

    //JQPL query with param
//    @Query(value = "SELECT * FROM cars WHERE brand=:brand AND model=:model AND bodyType=:bodyType AND manufactureYear=:manufactureYear AND colour=:colour AND mileAge=:mileage AND amount=:amount",nativeQuery = true)
//    List<Car> findByBrandAndModelAndBodyTypeAndManufactureYearAndColourAndMileAgeAndAmountWithParam(@Param("brand") String brand, @Param("model") String model,
//                                                                                                    @Param("bodytype")String bodyType,
//                                                                                                    @Param("manufactureYear") LocalDate manufactureYear,
//                                                                                                    @Param("colour") String colour,@Param("mileage") Long mileage,
//                                                                                                    @Param("amount") Long amount);
    //manufactureYear search
    @Query("SELECT c FROM Car c WHERE c.manufactureYear=: manufactureYear")
    List<Car> findByManufactureYear(LocalDate manufactureYear);

    //brand
    @Query("SELECT c FROM Car c WHERE c.brand=:brand")
    List<Car> findByBrand(String brand);

    //colour search
    @Query("SELECT c from Car c WHERE c.colour=:colour")
    List<Car> findByColour(String colour);

    //mileage
    @Query("SELECT c from Car c WHERE c.mileAge=:mileage")
    List<Car> findByMileAge(Long mileage);

    //body_type search
    @Query("SELECT c FROM Car c WHERE c.bodyType=:bodyType")
    List<Car> findByBodyType(String bodyType);

    //amount search
//    @Query("SELECT c FROM Car c WHERE c.amount=:amount")
//    List<Car> findByAmount(Long amount);

    //JQPL Query with parameters
    @Query("SELECT c FROM Car c WHERE c.model=:model")
    List<Car> findByModel(@Param("model") String model);

    @Query("SELECT C FROM Car C WHERE C.brand=:brand and C.bodyType=:bodyType")
    List<Car> findByBrandAndBodyType(String brand, String bodyType);

    @Query("SELECT c FROM Car c where c.colour=:colour and c.manufactureYear=:manufactureYear and c.amount=:amount")
    List<Car> findByColourAndManufactureYearAndAmount(String colour, LocalDate manufactureYear, Long amount);


    //JQPL Query with index
    @Query("SELECT c FROM Car c WHERE c.model=?1")
    List<Car> findByModelIndex(@Param("model") String model);

    @Query("SELECT c FROM Car c WHERE c.brand=?1 and c.bodyType=?2")
    List<Car> findByBrandAndBodyTypeIndex(@Param("brand") String brand, @Param("bodyType") String bodyType);


    //Native Query with paramters
    @Query(value = "SELECT * FROM  cars  WHERE model =:model", nativeQuery = true)
    List<Car> findByModelNativeQueryWithParams(@Param("model") String model);

    @Query(value = "SELECT * FROM cars WHERE brand=:brand and bodyType=:bodyType", nativeQuery = true)
    List<Car> findByBrandAndBodyTypeWithParams(String brand, String bodyType);


    //Native Query with index
    @Query(value = "SELECT * FROM cars WHERE model =?1", nativeQuery = true)
    List<Car> findByModelNativeQueryWithIndex(@Param("model") String model);

    @Query(value = "SELECT * FROM cars WHERE brand=?1 and body_type=?2", nativeQuery = true)
    List<Car> findByBrandAndBodyTypeWithIndex(@Param("brand") String brand, @Param("body_type") String body_type);


}
