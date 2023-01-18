package by.itacademy.hw8.task3.Product.Clothes;

public class Jackets extends Clothes{
    private final boolean hood;

    public Jackets(int barcode, double price, String producer, String model, String gender, SizeOfClothes size, boolean hood) {
        super(barcode, price, producer, model, gender, size);
        this.hood = hood;
    }
    @Override
    public String toString() {
        return super.toString() + String.format("Наличие капюшона: %s\n", hood);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Jackets)) {
            return false;
        }

        Jackets jackets = (Jackets) obj;

        return super.equals(obj) ||
                this.hood == jackets.hood;
    }
}
