package by.itacademy.hw10.task4.repsitory.animals;

import by.itacademy.hw10.task4.entity.animals.Parrot;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParrotRepository {
    private final List<Parrot> parrots = new ArrayList<>();

    public ParrotRepository() {
        initParrots();
    }

    public List<Parrot> getParrots() {
        return parrots;
    }

    @Override
    public String toString() {
        return parrots.toString();
    }

    private void initParrots() {
        Parrot firstParrot = new Parrot("Валера", new BigDecimal("39.99"),
                "кокое-то уникальное поле попугая Валеры");
        Parrot secondParrot = new Parrot("Аркаша", new BigDecimal("20.99"),
                "кокое-то уникальное поле попугая Аркаши");
        parrots.add(firstParrot);
        parrots.add(secondParrot);
    }
}

