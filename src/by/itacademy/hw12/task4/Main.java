package by.itacademy.hw12.task4;

import by.itacademy.hw12.task4.service.PersonService;
import by.itacademy.hw12.task4.utils.ListUtils;

public class Main {
    public static void main(String[] args) {
        String path = "src/by/itacademy/hw12/task4/Persons.data";
        PersonService personService = new PersonService();
        personService.writeToFile(path);

        personService.readFromFile(path);
        ListUtils.printList(personService.getPersonsSortedByFullName());
    }
}
