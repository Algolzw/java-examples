package algo.study.java.base.concurrent.cp_2;

/**
 * Created by jetluo on 16/8/17.
 */
public class BasicThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("wait for liftoff");
    }
}
