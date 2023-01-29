package by.itacademy.hw10.task4.repsitory.animals;

import by.itacademy.hw10.task4.entity.animals.Dog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DogRepository {
    private final List<Dog> dogs = new ArrayList<>();

    public DogRepository() {
        initDogs();
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    @Override
    public String toString() {
        return dogs.toString();
    }


    private void initDogs() {
        Dog firstDog = new Dog("Шарик", new BigDecimal("40.0"),
                "кокое-то уникальное поле пса Шарика");
        Dog secondDog = new Dog("Вольт", new BigDecimal("50.99"),
                "кокое-то уникальное поле пса Вольта");
        Dog thirdDog = new Dog("Вуди", new BigDecimal("60.99"),
                "кокое-то уникальное поле пса Вуди");
        dogs.add(firstDog);
        dogs.add(secondDog);
        dogs.add(thirdDog);
    }
}
