package algo.study.java.base.IOExample.nio;

import java.nio.ByteBuffer;

/**
 * Created by jetluo on 16/8/12
 */
public class NIO102GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);

        int i = 0;
        while (i++ < bb.limit()) {
            if (bb.get() != 0) {
                System.out.println("nonzero");
            }
        }
        System.out.println("i = " + i);

        bb.rewind();
        //存储和读取字符数组
        bb.asCharBuffer().put("How are you");
        char c;
        while((c = bb.getChar())!=0)
            System.out.print(c + " ");
        System.out.println();

        bb.rewind();
        bb.asShortBuffer().put((short)471142);
        System.out.println(bb.getShort());

        bb.rewind();
        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());

        bb.rewind();
        bb.asFloatBuffer().put(99471142);
        System.out.println(bb.getFloat());

    }
}
