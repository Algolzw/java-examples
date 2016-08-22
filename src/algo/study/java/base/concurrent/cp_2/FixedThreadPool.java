package algo.study.java.base.concurrent.cp_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jetluo on 16/8/17.
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++){
            exec.execute(new LiftOff(5));
            System.out.println();
        }
        exec.shutdown();
    }
}
