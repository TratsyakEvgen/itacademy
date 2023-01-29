package by.itacademy.hw12.task4.service;

import by.itacademy.hw12.task4.entity.Person;
import by.itacademy.hw12.task4.repository.PersonRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonService {
    private PersonRepository personRepository = new PersonRepository();

    public List<Person> getPersonsSortedByFullName() {
        List<Person> persons = new ArrayList<>(personRepository.getPersons());
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                String fullNameFirst = o1.getName() + o1.getSurname();
                String fullNameSecond = o2.getName() + o2.getSurname();
                return fullNameFirst.compareTo(fullNameSecond);
            }
        });
        return persons;
    }

    public void readFromFile(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            personRepository = (PersonRepository) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }
    }

    public void writeToFile(String path) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path, false)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(personRepository);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
