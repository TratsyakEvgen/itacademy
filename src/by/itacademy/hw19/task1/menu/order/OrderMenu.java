package by.itacademy.hw19.task1.menu.order;

import by.itacademy.hw19.task1.entity.Order;
import by.itacademy.hw19.task1.menu.MainMenu;
import by.itacademy.hw19.task1.menu.order.action.FindOrder;
import by.itacademy.hw19.task1.repository.MapRepository;
import by.itacademy.hw19.task1.util.InputMenuUtil;

public class OrderMenu {
    private final InputMenuUtil inputMenuUtil;
    private final MapRepository<Order> orders;

    public OrderMenu() {
        this.inputMenuUtil = MainMenu.getInputMenuUtil();
        this.orders = MainMenu.getOrders();
    }

    public void show() {
        System.out.println("1. Поиск заказа\n" +
                           "2. Добавить заказ\n" +
                           "3. Закрыть заказ\n" +
                           "4. Закрыть все заказы по комнате\n" +
                           "5. Закрыть все заказы по постоялцу\n" +
                           "0. Вернуться назад");
        switch (inputMenuUtil.entryValidInt("Выбирете действие: ", 0, 5)) {
            case 1:
                new FindOrder().show(orders.read());
                show();
                break;

            case 0:
                break;
        }
    }
}
