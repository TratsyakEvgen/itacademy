package by.itacademy.hw7.task3;

public class Main {
    public static void main(String[] args) {

        Basket basket = new Basket();


        basket.addFruitsToBasket(new Apple());
        basket.addFruitsToBasket(new Pear());
        basket.addFruitsToBasket(new Apricot());


        System.out.println("Стоимость корзины фруктов: "
                + basket.getSumPriceInBasket());
        System.out.println("Стоимость яблок в корзине: "
                + basket.getSumPriceInBasket(Apple.class.getSimpleName()));
        System.out.println("Стоимость груш в корзине: "
                + basket.getSumPriceInBasket(Pear.class.getSimpleName()));
        System.out.println("Стоимость абрикосов в корзине: "
                + basket.getSumPriceInBasket(Apricot.class.getSimpleName()));
    }
}
