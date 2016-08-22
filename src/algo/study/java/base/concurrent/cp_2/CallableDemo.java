package algo.study.java.base.concurrent.cp_2;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by jetluo on 16/8/17.
 */

class TaskResult implements Callable<String>{
    private int id;
    public TaskResult(int id){
        this.id = id;
    }

    public String call(){
        return "result is " + id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> res = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            res.add(exec.submit(new TaskResult(i)));
        }
        for (Future<String> ft : res) {
            try{
                System.out.println(ft.get());
            }catch(Exception e){
                System.out.println(e);
            }finally{
                exec.shutdown();
            }
        }
    }
}
