import java.util.Arrays;
import java.util.List;

public class ChoiceHappyDoor {
    private List<Integer> lstChoice = Arrays.asList(0, 0, 0);
    private int firstChoice;
    private int openingEmptyDoor;

    private void doorToWin() {
        int num = Rnd.rnd();
        lstChoice.set(num, 1);
    }

    public List<Integer> getList() {
        doorToWin();
        return lstChoice;
    }

    public int choiceDoor() {
        return firstChoice = Rnd.rnd();
    }

    public int secondaryChoiceDoors() {
        int choiceWin = 0;
        boolean bool = true;
        while (bool) {
            int rndNum = Rnd.rnd();
            int choice = lstChoice.get(rndNum);
            if (choice == 0 && rndNum != firstChoice) {
                bool = false;
                openingEmptyDoor = choiceWin = rndNum;
            }
        }
        return choiceWin;
    }

    public int choiceOfWwoRemainingDoors() {
        int choice = 0;
        boolean bool = true;
        while (bool) {
            int rnd = Rnd.rnd();
            if (rnd != openingEmptyDoor) {
                bool = false;
                choice = rnd;
            }
        }
        return choice;
    }

    public int result() {
        for (Integer num : lstChoice) {
            if(num == firstChoice){
                return 1;
            }
        }
        return 0;
    }
}
