package by.itacademy.hw10.task4.entity.animals;

import java.math.BigDecimal;

public class Dog extends Animal {
    private final String someUniqueParameterClassDog;

    public Dog(String nickname, BigDecimal price, String someUniqueParameterClassDog) {
        super(nickname, price);
        this.someUniqueParameterClassDog = someUniqueParameterClassDog;
    }

    @Override
    public String toString() {
        return super.toString() + this.someUniqueParameterClassDog + "\n";
    }
}
