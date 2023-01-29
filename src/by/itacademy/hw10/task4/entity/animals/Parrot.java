package by.itacademy.hw10.task4.entity.animals;

import java.math.BigDecimal;

public class Parrot extends Animal {
    private final String someUniqueParameterClassParrot;

    public Parrot(String nickname, BigDecimal price, String someUniqueParameterClassParrot) {
        super(nickname, price);
        this.someUniqueParameterClassParrot = someUniqueParameterClassParrot;
    }

    @Override
    public String toString() {
        return super.toString() + this.someUniqueParameterClassParrot + "\n";
    }
}
