package algo.study.java.base.IOExample.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jetluo on 16/8/11
 */
public class NIO100GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        String filename = "./src/output/data.txt";
        FileChannel fc = new FileOutputStream(filename).getChannel();
        fc.write(ByteBuffer.wrap("some text".getBytes()));
        fc.close();

        fc = new RandomAccessFile(filename,"rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("\nmore text".getBytes()));
        fc.close();

        fc = new FileInputStream(filename).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while(buff.hasRemaining())
            System.out.print((char)buff.get());
    }
}
