package test;

import algo.study.java.base.IOExample.Utils.BinaryFile;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jetluo on 16/8/
 */
public class WriteBytes {

    public static void writeBytes(String file) throws Exception{
        int size = 1000;
        FileChannel fc = new FileOutputStream(new File(file)).getChannel();
//        MappedByteBuffer map = fc.map(FileChannel.MapMode.READ_WRITE,0,size * 4);
        ByteBuffer buff;
        for(int i =0;i<size;i++) {
            buff = ByteBuffer.wrap(("" + i + "").getBytes());
            fc.write(buff);
        }
        fc.close();
    }

    public static void writeBytesByStream(String file) throws Exception{
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(new File(file))
                )
        );
        for(int i=0;i<1000;i++){
            out.writeBytes(String.valueOf(i));
        }
        out.close();
    }

    public static void main(String[] args) throws Exception{
        String file = "./src/test/data/test.tmp";
//        writeBytes(file);
        writeBytesByStream(file);
    }
}
