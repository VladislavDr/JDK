import java.util.Random;

public class Fork extends Thread{
    private static Random rnd = new Random();
    public static int rndNum(){
        return rnd.nextInt(1, 6);
    }
}
