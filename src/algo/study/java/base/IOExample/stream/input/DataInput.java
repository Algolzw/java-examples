package algo.study.java.base.IOExample.stream.input;

import java.io.*;

/**
 * Created by jetluo on 16/8/16.
 */
public class DataInput {
    public static void main(String[] args) throws IOException {
        String filepath = "./src/test/data/test.tmp";
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(new File(filepath))
                )
        );

        byte[] buff = new byte[in.available()];
        in.read(buff);
        System.out.printf("%s",new String(buff));

//        while(in.available() > 0){
//            System.out.print(new String(new byte[]{
//                    in.readByte()
//            }));
//        }
    }
}
