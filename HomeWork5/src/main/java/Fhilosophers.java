import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Fhilosophers extends Thread {
    private final String name;
    private final int eat = 3;
    private final CountDownLatch cdlEat = new CountDownLatch(eat);
    private CountDownLatch cdtCompleted;
    private static List<String> lst = new ArrayList<>();
    private volatile boolean bool = true;

    public Fhilosophers(String name, CountDownLatch cdtCompleted) {
        this.name = name;
        this.cdtCompleted = cdtCompleted;
    }

    @Override
    public void run() {
        try {
            eats();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void eats() throws InterruptedException {
        while (cdlEat.getCount() != 0) {
            int fork1 = Fork.rndNum();
            int fork2 = Fork.rndNum();
            isBool(fork1, fork2);
            sleep(1000);
            if (bool) {
                cdlEat.countDown();
                System.out.println(this.getNamePhilosophers() + " покушал " + (eat - cdlEat.getCount()) + " раза вилками " + fork1 + " и " + fork2);
                Thread.sleep(500);
            } else thinks();
        }
        if (cdlEat.getCount() == 0) {
            lst.add(this.getNamePhilosophers());
            cdtCompleted.countDown();
        }
    }

    public void thinks() {

    }

    public String getNamePhilosophers() {
        return name;
    }

    public static List<String> getList() {
        return lst;
    }

    public void isBool(int num1, int num2) {
        bool = (Math.abs(num1 - num2) == 1) || (Math.abs(num1 - num2) == 5);
    }
}
