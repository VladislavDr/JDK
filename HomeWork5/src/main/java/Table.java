import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Table extends Thread{
    CountDownLatch count = new CountDownLatch(7);
    Fhilosophers oneFhilosophers = new Fhilosophers("Fhilosopher N1", count);
    Fhilosophers twoFhilosophers = new Fhilosophers("Fhilosopher N2", count);
    Fhilosophers treeFhilosophers = new Fhilosophers("Fhilosopher N3", count);
    Fhilosophers fourFhilosophers = new Fhilosophers("Fhilosopher N4", count);
    Fhilosophers fiveFhilosophers = new Fhilosophers("Fhilosopher N5", count);
    Fhilosophers sixFhilosophers = new Fhilosophers("Fhilosopher N6", count);

//    {
//        Fork forkOne = new Fork(1);
//        Fork forkTwo = new Fork(2);
//        Fork forkTree = new Fork(3);
//        Fork forkFour = new Fork(4);
//        Fork forkFive = new Fork(5);
//    }

    @Override
    public void start() {
        oneFhilosophers.start();
        twoFhilosophers.start();
        treeFhilosophers.start();
        fourFhilosophers.start();
        fiveFhilosophers.start();
        sixFhilosophers.start();

        while (count.getCount() != 1){
            try {
                sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        count.countDown();
        System.out.println(Fhilosophers.getList());
    }
}
