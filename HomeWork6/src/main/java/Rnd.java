import java.util.Random;

public class Rnd {
    public static int rnd(){
        Random rnd = new Random();
        return rnd.nextInt(0, 3);
    }
}
