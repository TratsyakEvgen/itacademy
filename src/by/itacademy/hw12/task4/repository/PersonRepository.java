package by.itacademy.hw12.task4.repository;

import by.itacademy.hw12.task4.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private final List<Person> persons = new ArrayList<>();

    public PersonRepository() {
        initPersons();
    }

    public List<Person> getPersons() {
        return persons;
    }

    private void initPersons() {
        persons.add(new Person("Иван", "Иванов", 21));
        persons.add(new Person("Петр", "Петров", 22));
        persons.add(new Person("Николай", "Николаев", 20));
        persons.add(new Person("Олег", "Олегов", 28));
        persons.add(new Person("Тут должно быть имя", "а тут фамилия - законилась фантазия", 24));
    }

}
