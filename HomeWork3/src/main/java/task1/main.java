package task1;
/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа,
над которыми должна быть произведена операция.
 */

public class main {
    public static void main(String[] args) {
        int in = 1645456;
        double db = 125.54;
        System.out.println(Calculator.sum(in, db));
        System.out.println(Calculator.multiply(in, db));
        System.out.println(Calculator.divide(in, db));
        System.out.println(Calculator.subtract(in, db));

    }
}
