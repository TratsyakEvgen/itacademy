package by.itacademy.hw8.task3.Product.Shoes;

public enum SizeOfShoes {
    XXS(35),
    XS(36),
    S(37),
    SM(38),
    M(39),
    ML(40),
    L(41),
    XL(44),
    XXL(45);

    private final int size;

    SizeOfShoes(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static SizeOfShoes find(int size) {
        SizeOfShoes sizeOfShoes = null;
        SizeOfShoes[] array = SizeOfShoes.values();
        for (SizeOfShoes obj : array) {
            if (obj.size == size) {
                sizeOfShoes = SizeOfShoes.valueOf(String.valueOf(obj));
            }
        }
        return sizeOfShoes;
    }


}
