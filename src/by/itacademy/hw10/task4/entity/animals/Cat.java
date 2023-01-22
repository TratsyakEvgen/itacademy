package by.itacademy.hw10.task4.entity.animals;

import java.math.BigDecimal;

public class Cat extends Animal {
    private final String someUniqueParameterClassCat;

    public Cat(String nickname, BigDecimal price, String someUniqueParameterClassCat) {
        super(nickname, price);
        this.someUniqueParameterClassCat = someUniqueParameterClassCat;
    }

    @Override
    public String toString() {
        return super.toString() + this.someUniqueParameterClassCat + "\n";
    }

}
