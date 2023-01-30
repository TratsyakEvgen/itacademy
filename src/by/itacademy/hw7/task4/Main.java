package by.itacademy.hw7.task4;


public class Main {
    public static void main(String[] args) {

        Bouquet bouquet = new Bouquet();

        System.out.println("Добавим розы в букет");
        bouquet.addFlowersToBouquet("Rose");
        System.out.println("Добавим тюльпаны в букет");
        bouquet.addFlowersToBouquet("Tulip");
        System.out.println("Добавим кактусы в букет");
        bouquet.addFlowersToBouquet("Cactus");

        System.out.println(bouquet.getColorsAndDeadLine());

    }
}
