package by.itacademy.hw8.Task3.Product.Shoes;


public class Slippers extends Shoes {
    private final String type;

    public Slippers(int barcode, double price, String producer, String model, String gender, SizeOfShoes size, String type) {
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

        if (!(obj instanceof Slippers)) {
            return false;
        }

        Slippers slippers = (Slippers) obj;

        return super.equals(obj) ||
                this.type != null && this.type.equals(slippers.type);
    }

}
