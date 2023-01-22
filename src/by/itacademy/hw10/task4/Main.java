package by.itacademy.hw10.task4;

import by.itacademy.hw10.task4.repsitory.LogbookRepository;
import by.itacademy.hw10.task4.service.LogbookService;
import by.itacademy.hw10.task4.util.ListUtil;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        LogbookService logbookService = new LogbookService();
        LogbookRepository logbookRepository = new LogbookRepository();

        System.out.println("Все питомцы:");
        System.out.println(logbookRepository);

        System.out.println("Сортировка по кличке:");
        System.out.println(ListUtil.ListToString(logbookService.getAnimalsSortedByName()));

        System.out.println("Сортировка по цене:");
        System.out.println(ListUtil.ListToString(logbookService.getAnimalsSortedByPrice()));

        System.out.println("Диапозон цены от 20 до 40:");
        BigDecimal low = BigDecimal.valueOf(20);
        BigDecimal high = BigDecimal.valueOf(40);
        System.out.println(ListUtil.ListToString(logbookService.getPriceRange(low, high)));

        System.out.println("Купим Валеру:");
        System.out.println(logbookService.buyAnimal("Валера", logbookRepository));

        System.out.println("Все питомцы после покупки:");
        System.out.println(logbookRepository);
    }
}
