package algo.study.java.base.IOExample.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * 文件加锁
 */
public class NIO107FileLocking {
    public static void main(String[] args) throws Exception{
        FileOutputStream out = new FileOutputStream(new File("./src/output/filelocking.tmp"));
        //获取整个文件的filelock,tryLock是非阻塞的方法;lock方法也可以获取锁,但是阻塞式方法
        FileLock fl = out.getChannel().tryLock();
        if(fl != null){
            System.out.println("Locked File");
            out.write("locking file".getBytes());
            TimeUnit.MILLISECONDS.sleep(1000);
            //释放锁
            fl.release();
            System.out.println("Lock release");
            fl.close();
        }
    }
}
