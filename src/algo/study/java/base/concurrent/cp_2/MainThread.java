package algo.study.java.base.concurrent.cp_2;

/**
 * Created by jetluo on 16/8/17.
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
        System.out.println("start");
    }
}
