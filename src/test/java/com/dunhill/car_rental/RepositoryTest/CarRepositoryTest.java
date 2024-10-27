package com.dunhill.car_rental.RepositoryTest;
import com.dunhill.car_rental.entity.Car;
import com.dunhill.car_rental.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    private Car car;
    private Car car1;
    private Car car2;

    @BeforeEach
    void setup(){
        car = Car.builder().model("benz").bodyType("hatchback").manufactureYear(LocalDate.of(1997,10,10)).colour("black").mileAge(220L).brand("bclass").amount(100D).build();
        car1 = Car.builder().model("volkswagen").bodyType("hatchback").manufactureYear(LocalDate.of(1997,10,10)).colour("blue").mileAge(200L).brand("golf").amount(200D).id(4L).build();
        car2 = Car.builder().model("volkswagen").bodyType("van").colour("blue").manufactureYear(LocalDate.of(1997,10,10)).mileAge(200L).brand("golf").amount(300D).id(5L).build();
    }


    @Test
    public  void testSave(){
       //given
//        Car car = Car.builder().model("benz").colour("black").mileAge(220L).amount(100L).build();

        //action
        Car savedCar = carRepository.save(car);

        //then
        assertThat(savedCar).isNotNull();
        assertThat(savedCar.getId()).isPositive();
        assertThat(savedCar.getModel()).isEqualTo("benz");

    }
    @Test
    public void testGetAll(){
        //given
        Car car = Car.builder().model("volkswagen").colour("blue").mileAge(100L).brand("golf").id(3L).build();
        carRepository.save(car);
        carRepository.save(car1);
        carRepository.save(car2);

        List<Car> found = carRepository.findAll();
        assertThat(found).isNotNull();

    }

    @Test
    public void testGetById(){
//        Car car = Car.builder().id(2L).build();
        carRepository.save(car);
        Car savedCar = carRepository.findById(2L).get();
        assertThat(savedCar).isNotNull();
        assertThat(savedCar.getId()).isPositive();
        assertThat(savedCar.getId()).isEqualTo(2L);
    }

    @Test
    public void testDelete(){
//        Car car = Car.builder().id(6L).build();
        Car savedCar = carRepository.save(car);
        carRepository.delete(savedCar);
        Optional<Car> found = carRepository.findById(savedCar.getId());
        assertThat(found).isNotPresent();
    }

    @Test
    public void testGetModel(){
        carRepository.save(car);
        List<Car> listCar = carRepository.findByModel("benz");
        assertThat(listCar).isNotNull();
        assertThat(listCar.get(0).getModel()).isEqualTo("benz");
    }

    @Test
    public void testGetBrandAndBodyType(){
        carRepository.save(car);
        carRepository.save(car1);
        List<Car> listCar = carRepository.findByBrandAndBodyType("golf","van");
        assertThat(listCar).isNotNull();
        assertThat(listCar.get(0).getBrand()).isEqualTo("golf");
    }

    @Test
    public void testGetModelParams(){
        carRepository.save(car1);
        List<Car> found = carRepository.findByModelIndex("volkswagen");
        assertThat(found).isNotNull();
        assertThat(found.get(0).getColour()).isEqualTo("blue");
    }

    @Test
    public void testThreeParams(){
        carRepository.save(car);
        carRepository.save(car1);
        carRepository.save(car2);
        List<Car> listCar = carRepository.findByColourAndManufactureYearAndAmount("blue",LocalDate.of(1997,10,10),200L);
        System.out.println(listCar.size());
        assertThat(listCar).isNotNull();
        assertThat(listCar.get(0).getColour()).isEqualTo("blue");
        assertThat(listCar.get(0).getManufactureYear()).isEqualTo(LocalDate.of(1997,10,10));
        assertThat(listCar.get(0).getAmount()).isEqualTo(200L);

    }




}
