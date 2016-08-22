package algo.study.java.base.IOExample.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by jetluo on 16/8/16
 */
public class NIO107LockingMappedFiles {
    static final int LENGTH = 0x8FFFFFF; //128M
    static FileChannel fc;

    public static void main(String[] args) throws Exception {
        fc = new RandomAccessFile("./src/output/lockingmappedfiles.tmp", "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++)
            out.put((byte) 'x');
        new LockAndModify(out, 0, LENGTH / 5);
        new LockAndModify(out, LENGTH / 2, LENGTH / 2 + LENGTH / 4);
    }

    private static class LockAndModify extends Thread {
        private ByteBuffer buff;
        private int start, end;

        LockAndModify(ByteBuffer mdd, int start, int end) {
            this.start = start;
            this.end = end;
            mdd.limit(end);
            mdd.position(start);
            buff = mdd.slice();
            start();
        }

        public void run() {
            try {
                FileLock fl = fc.lock(start, end, false);
                System.out.println("locked " + start + " to " + end);
                while (buff.position() < buff.limit() - 1)
                    buff.put((byte) (buff.get() + 1));
                fl.release();
                System.out.println("release " + start + " to " + end);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
