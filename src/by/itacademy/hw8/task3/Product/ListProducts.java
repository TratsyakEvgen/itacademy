package by.itacademy.hw8.task3.Product;

public enum ListProducts {
    PRODUCT("Все товары", true),
    SHOES("Обувь", true),
    CLOTHES("Одежда", true),
    BOOTS("Ботинки", false),
    SLIPPERS("Тапки", false),
    SNEAKERS("Кроссовки", false),
    JACKETS("Куртки", false),
    SHIRTS("Рубашки", false),
    TROUSERS("Брюки", false);

    private final String title;
    private final boolean isAbstract;

    ListProducts(String title, boolean isAbstract) {
        this.title = title;
        this.isAbstract = isAbstract;
    }

    public static ListProducts find(String string) {
        ListProducts listProducts = null;
        ListProducts[] array = ListProducts.values();
        for (ListProducts obj : array) {
            if (obj.title.equalsIgnoreCase(string)) {
                listProducts = ListProducts.valueOf(String.valueOf(obj));
            }
        }
        return listProducts;
    }

    public static void printTitles(boolean bool) {
        ListProducts[] array = ListProducts.values();
        for (ListProducts obj : array) {
            if (obj.isAbstract == bool) {
                System.out.print(obj.title + " ");
            }
        }
    }
}
