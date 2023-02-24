package by.itacademy.hw19.task1.menu.action;

import by.itacademy.hw19.task1.entity.Client;
import by.itacademy.hw19.task1.logger.ConsoleLogger;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.service.ServiceMap;
import by.itacademy.hw19.task1.util.InputMenuUtil;
import by.itacademy.hw19.task1.util.OutputMenuUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class ClientMenuAction {
    private final InputMenuUtil inputMenuUtil;
    private final MapRepository<Client> mapRepository;
    public ClientMenuAction(InputMenuUtil inputMenuUtil, MapRepository<Client> mapRepository) {
        this.inputMenuUtil = inputMenuUtil;
        this.mapRepository = mapRepository;
    }

    public void filter(Map<Integer, Client> clientMap) {
        Scanner scanner = new Scanner(System.in);
        ServiceMap<Integer, Client> serviceMap = new ServiceMap<>(clientMap, new ConsoleLogger());
        clientMap = new HashMap<>();
        System.out.println("1. Поиск по имени\n" +
                           "2. Поиск по фамилии\n" +
                           "3. Поиск по индификационному номеру\n" +
                           "4. Поиск по возрасту\n" +
                           "5. Поиск по стране\n" +
                           "6. Поиск по номеру телефона\n" +
                           "0. Вернуться назад");

        switch (inputMenuUtil.entryVerifyInt("Выбирете действие: ", 0, 7)) {
            case 1:
                System.out.print("Имя: ");
                clientMap = serviceMap.filterByFieldValue("firstName", scanner.nextLine());
                break;
            case 2:
                System.out.print("Фамилия: ");
                clientMap = serviceMap.filterByFieldValue("lastName", scanner.nextLine());
                break;
            case 3:
                System.out.print("Номер паспорта: ");
                clientMap = serviceMap.filterByFieldValue("identification", scanner.nextLine());
                break;
            case 4:
                clientMap = serviceMap.filterByFieldValue("age",
                        inputMenuUtil.entryVerifyInt("Возраст: ", 0, 9999));
                break;
            case 5:
                System.out.print("Страна: ");
                clientMap = serviceMap.filterByFieldValue("country", scanner.nextLine());
                break;
            case 6:
                clientMap = serviceMap.filterByFieldValue("phoneNumber",
                        inputMenuUtil.entryVerifyString("Номер телефона: ", "\\+{1}[\\d]{12}"));
                break;
            case 0:
                return;
        }
        if (clientMap.isEmpty()) {
            System.out.println("По вашему запросу ничего не найдено :(");
        } else {
            OutputMenuUtil.printMap(clientMap, ": ");
            System.out.println("Продолжим поиск из найденых клиентов:");
            filter(clientMap);
        }
    }

    public void add() {
        String firstName = inputMenuUtil.entryString("Имя: ");
        String lastName = inputMenuUtil.entryString("Фамилия: ");
        String identification = inputMenuUtil.entryString("Номер паспорта: ");
        int age = inputMenuUtil.entryVerifyInt("Возраст: ", 0, 9999);
        String country = inputMenuUtil.entryString("Страна: ");
        String phoneNumber = inputMenuUtil.entryVerifyString("Номер телефона: ", "\\+{1}[\\d]{12}");
        mapRepository.add(new Client(firstName, lastName, identification, age, country, phoneNumber));
    }

    public void edit(Integer id, Client client) {
        System.out.println("1. Изменть имя\n" +
                           "2. Изменть фамилию\n" +
                           "3. Изменть индификационный номер\n" +
                           "4. Изменть возраст\n" +
                           "5. Изменть страну\n" +
                           "6. Изменть номер телефона\n" +
                           "7. Сохранить изменения\n" +
                           "0. Вернуться назад");

        switch (inputMenuUtil.entryVerifyInt("Выбирете действие: ", 0, 7)) {
            case 1:
                client.setFirstName(inputMenuUtil.entryString("Имя: "));
                break;
            case 2:
                client.setLastName(inputMenuUtil.entryString("Фамилия: "));
                break;
            case 3:
                client.setIdentification(inputMenuUtil.entryString("Номер паспорта: "));
                break;
            case 4:
                client.setAge(inputMenuUtil.entryVerifyInt("Возраст: ", 0, 9999));
                break;
            case 5:
                client.setCountry(inputMenuUtil.entryString("Страна: "));
                break;
            case 6:
                client.setPhoneNumber(inputMenuUtil.entryString("Номер телефона: "));
                break;
            case 7:
                System.out.println("Информация сохранена");
                mapRepository.update(id, client);
                break;
            case 0:
                return;
        }
        edit(id, client);
    }

    public Optional<Map.Entry<Integer, Client>> select() {
        Optional<Map.Entry<Integer, Client>> optional = Optional.empty();
        System.out.println("1. Поиск клеента" +
                           "2. Ввести id" +
                           "0. Вернуться назад");
        switch (inputMenuUtil.entryVerifyInt("Выбирете действие: ", 0, 2)) {
            case 1:
                filter(mapRepository.read());
                break;
            case 2:
                int id = inputMenuUtil.entryVerifyInt("Введите id: ", 1, 2147483647);
                optional = mapRepository.get(id);
                if (optional.isEmpty()) {
                    System.out.println("Клиент не найден");
                }
                break;
            case 0:
                break;
        }
        return optional;
    }
}
