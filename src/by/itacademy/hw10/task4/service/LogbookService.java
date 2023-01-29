package by.itacademy.hw10.task4.service;

import by.itacademy.hw10.task4.entity.animals.Animal;
import by.itacademy.hw10.task4.repsitory.LogbookRepository;
import by.itacademy.hw10.task4.util.ListUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LogbookService {
    private final LogbookRepository logbookRepository = new LogbookRepository();

    @Override
    public String toString() {
        return ListUtil.listToString(logbookRepository.getAnimals());
    }

    public List<Animal> getAnimalsSortedByName() {
        List<Animal> animals = logbookRepository.getAnimals();
        animals.sort(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.getNickname().compareTo(o2.getNickname());
            }
        });
        return animals;
    }

    public List<Animal> getAnimalsSortedByPrice() {
        List<Animal> animals = logbookRepository.getAnimals();
        animals.sort(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });
        return animals;
    }

    public List<Animal> getPriceRange(BigDecimal low, BigDecimal high) {
        List<Animal> animals = logbookRepository.getAnimals();
        List<Animal> priceRange = new ArrayList<>();
        for (Animal animal : animals) {
            BigDecimal price = animal.getPrice();
            if (price.compareTo(low) > -1 & price.compareTo(high) < 1) {
                priceRange.add(animal);
            }
        }
        return priceRange;
    }

    public String buyAnimal(String nickname) {
        List<Animal> animals = logbookRepository.getAnimals();
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getNickname().equals(nickname)) {
                animals.remove(i);
                return "Вы купили " + nickname;
            }
        }
        return "Нет такого питомца";
    }


}
