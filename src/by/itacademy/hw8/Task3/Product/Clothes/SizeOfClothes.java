package by.itacademy.hw8.Task3.Product.Clothes;

public enum SizeOfClothes {
    XXS(38),
    XS(40),
    S(42),
    SM(44),
    M(46),
    ML(48),
    L(50),
    XL(52),
    XXL(54);
    private final int size;

    SizeOfClothes(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static SizeOfClothes find(int size) {
        SizeOfClothes sizeOfClothes = null;
        SizeOfClothes[] array = SizeOfClothes.values();
        for (SizeOfClothes obj : array) {
            if (obj.size == size) {
                sizeOfClothes = SizeOfClothes.valueOf(String.valueOf(obj));
            }
        }
        return sizeOfClothes;
    }
}
