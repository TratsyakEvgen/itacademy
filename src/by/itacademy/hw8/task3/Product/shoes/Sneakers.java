package by.itacademy.hw8.task3.Product.shoes;


public class Sneakers extends Shoes {
    private final String soleMaterial;

    public Sneakers(int barcode, double price, String producer, String model, String gender, SizeOfShoes size, String soleMaterial) {
        super(barcode, price, producer, model, gender, size);
        this.soleMaterial = soleMaterial;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Материал подошвы: %s\n", soleMaterial);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Sneakers)) {
            return false;
        }

        Sneakers sneakers = (Sneakers) obj;

        return super.equals(obj) ||
                this.soleMaterial != null && this.soleMaterial.equals(sneakers.soleMaterial);
    }

}
