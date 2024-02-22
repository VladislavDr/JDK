package task1;

public class Calculator {
    private Number t1;
    private Number t2;
    private Number num;

    public static <T extends Number> float sum(T t1, T t2) {
        return t1.floatValue() + t2.floatValue();
    }
    public static <T extends Number> float multiply(T t1, T t2){
        return t1.floatValue() * t2.floatValue();
    }
    public static <T extends Number> float divide(T t1, T t2){
        return t1.floatValue() / t2.floatValue();
    }
    public static <T extends Number> float subtract(T t1, T t2){
        return t1.floatValue() - t2.floatValue();
    }

}
