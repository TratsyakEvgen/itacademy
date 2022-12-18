package by.itacademy.hw2;
public class Task6 {
    public static void main(String[] args) {
        double firstNumber = 2.4;
        double secondNumber = -2.22;
        double thirdNumber = 2.5;
        double min;

        firstNumber = takeModule(firstNumber);
        secondNumber=takeModule(secondNumber);
        thirdNumber=takeModule(thirdNumber);
        min=firstNumber;
        min=secondNumber<min?secondNumber:min;
        min=thirdNumber<min?thirdNumber:min;

        System.out.println("Из чисел: "+firstNumber+"; "+secondNumber+"; "+thirdNumber+"; наименьшим по модулю явяляется "+min);
    }
    public static double takeModule (double number){
        number = number<0?number*-1:number;
        return number;
    }
}
