package algo.study.java.base.concurrent.cp_2;

/**
 * Created by jetluo on 16/8/17
 */
public class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = ++taskCount;

    public LiftOff(){}

    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#" + this.id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ") ";
    }

    public void run(){
        while(countDown-- > 0){
            System.out.print(status());
            Thread.yield();
        }
    }
}
