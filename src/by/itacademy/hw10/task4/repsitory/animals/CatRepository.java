package by.itacademy.hw10.task4.repsitory.animals;

import by.itacademy.hw10.task4.entity.animals.Cat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CatRepository {
    private final List<Cat> cats = new ArrayList<>();

    public CatRepository() {
        initCats();
    }

    public List<Cat> getCats() {
        return cats;
    }

    @Override
    public String toString() {
        return cats.toString();
    }

    private void initCats() {
        Cat firstCat = new Cat("Барсик", new BigDecimal("99.99"),
                "кокое-то уникальное поле кота Барсика");
        Cat secondCat = new Cat("Гремлин", new BigDecimal("0.99"),
                "кокое-то уникальное поле кота Гремлина");
        cats.add(firstCat);
        cats.add(secondCat);
    }
}
