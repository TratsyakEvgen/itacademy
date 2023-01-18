package by.itacademy.hw8.task3.Product.Clothes;

public class Shirts extends Clothes{
    private final String type;

    public Shirts(int barcode, double price, String producer, String model, String gender, SizeOfClothes size, String type) {
        super(barcode, price, producer, model, gender, size);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Тип: %s\n", type);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Shirts)) {
            return false;
        }

        Shirts shirts = (Shirts) obj;

        return super.equals(obj) ||
                this.type != null && this.type.equals(shirts.type);
    }
}
