package algo.study.java.base.concurrent.cp_2;

/**
 * Created by jetluo on 16/8/17.
 */
public class MoreBasicThread {
    public static void main(String[] args) {
        int i = 1;
        while (i < 5) {
            new Thread(new LiftOff()).start();
            System.out.println();
            i++;
        }
        System.out.println("wait for liftOff");
    }
}
