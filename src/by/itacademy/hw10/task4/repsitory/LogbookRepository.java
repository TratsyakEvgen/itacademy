package by.itacademy.hw10.task4.repsitory;

import by.itacademy.hw10.task4.entity.animals.Animal;
import by.itacademy.hw10.task4.repsitory.animals.CatRepository;
import by.itacademy.hw10.task4.repsitory.animals.DogRepository;
import by.itacademy.hw10.task4.repsitory.animals.ParrotRepository;
import by.itacademy.hw10.task4.util.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class LogbookRepository {
    private final List<Animal> animals = new ArrayList<>();

    public LogbookRepository() {
        initAnimals();
    }

    public List<Animal> getAnimals() {
        return animals;
    }//

    @Override
    public String toString() {
        return ListUtil.listToString(animals);
    }

    private void initAnimals() {
        CatRepository catRepository = new CatRepository();
        DogRepository dogRepository = new DogRepository();
        ParrotRepository parrotRepository = new ParrotRepository();
        animals.addAll(catRepository.getCats());
        animals.addAll(dogRepository.getDogs());
        animals.addAll(parrotRepository.getParrots());
    }
}
