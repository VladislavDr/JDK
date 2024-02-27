import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args){

        List<Integer> listGame = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            ChoiceHappyDoor choise = new ChoiceHappyDoor();
            choise.getList();
            choise.choiceDoor();
            choise.secondaryChoiceDoors();
            choise.choiceOfWwoRemainingDoors();
            listGame.add(choise.result());
        }

        int summ = 0;

        for (Integer num : listGame) {
            summ += num;
        }

        int size = listGame.size();
        double result = (double) summ /size * 100;
        System.out.println(result + " %");
    }

}
