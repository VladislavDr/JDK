package task2;

import java.util.List;

public class Compare<T> {
    private boolean bool;

    public boolean compareArrays(List<T> lst1, List<T> lst2){
        if(!(lst2.size() == lst1.size()) || (lst1.isEmpty() || lst2.isEmpty())){
            System.out.println("Массивы не равны по длине, или один или два массива нулевые");
            return false;
        } else {
            for (int i = 0; i < lst1.size(); i++) {
                if(lst1.get(i).equals(lst2.get(i))){
                    bool = true;
                } else bool = false;
            }
        }
        return bool;
    }
}
