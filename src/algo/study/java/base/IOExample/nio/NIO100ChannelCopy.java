package algo.study.java.base.IOExample.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jetluo on 16/8/11.
 */
public class NIO100ChannelCopy {
    private static final int BSIZE = 1024;

    public static void copy(String file1,String file2) throws Exception{
        FileChannel
                in = new FileInputStream(file1).getChannel(),
                out = new FileOutputStream(file2).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        while(in.read(buff)!=-1){
            buff.flip();
            out.write(buff);
            buff.clear();
        }
    }

    public static void main(String[] args) throws Exception{
        long t1 = System.currentTimeMillis();
        copy("./src/input/jobs.json","./src/output/jobs.json");
        long t2 = System.currentTimeMillis();
        System.out.println("cost time:" + (t2-t1));
    }
}
