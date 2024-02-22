package task2;

import java.util.List;

/*
Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных,
но должны иметь одинаковую длину и содержать элементы одного типа.
 */
public class main {
    public static void main(String[] args) {
        List lst = List.of(123, 458, 789, 159951);
        List lst1 = List.of(123, 456, 789, "159951");
        Compare cmp = new Compare();
        System.out.println(cmp.compareArrays(lst, lst1));
    }
}
