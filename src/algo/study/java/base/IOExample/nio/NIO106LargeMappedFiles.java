package algo.study.java.base.IOExample.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jetluo on 16/8/15
 */
public class NIO106LargeMappedFiles {
    static int length = 0x8FFFFFF;

    public static void main(String[] args) throws Exception {
        long t1 = System.currentTimeMillis();
        MappedByteBuffer out = new RandomAccessFile("./src/output/mappedfile.dat","rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE,0,length);
        for (int i=0;i<length;i++)
            out.put((byte)'x');
        long t2 = System.currentTimeMillis();
        System.out.println("cast " + (t2-t1)+" millis");
        System.out.println("finish");
        for(int i=length/2;i<length/2+6;i++)
            System.out.println((char)out.get(i));
        System.out.println(out.limit());
    }
}
