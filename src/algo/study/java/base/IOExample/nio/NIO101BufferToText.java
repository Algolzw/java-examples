package algo.study.java.base.IOExample.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by jetluo on 16/8/12
 */
public class NIO101BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        String filename = "./src/output/data.text";
        FileChannel fc = new FileOutputStream(filename).getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new FileInputStream(filename).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();

        System.out.println(buff.asCharBuffer()); // 显示乱码

        //decode使用系统默认编码解码
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("decoding using " + encoding + ": " + Charset.forName(encoding).decode(buff));

        fc = new FileOutputStream(filename).getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();

        fc = new FileInputStream(filename).getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();

        System.out.println(buff.asCharBuffer()); //正常显示

        fc = new FileOutputStream(filename).getChannel();
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();

        fc = new FileInputStream(filename).getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();

        System.out.println(buff.asCharBuffer());

    }

}
