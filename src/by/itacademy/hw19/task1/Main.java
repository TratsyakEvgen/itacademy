package by.itacademy.hw19.task1;

import by.itacademy.hw19.task1.interfaces.Logger;
import by.itacademy.hw19.task1.logger.ConsoleLogger;
import by.itacademy.hw19.task1.menu.ClientMenu;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.util.InputMenuUtil;


public class Main {
    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        ClientMenu clientMenu = new ClientMenu(
                new InputMenuUtil(logger),
                new MapRepository<>("src/by/itacademy/hw19/task1/data/clients.data", logger));
        clientMenu.showClientMenu();

    }
}
