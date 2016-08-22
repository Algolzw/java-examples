package algo.study.java.base.IOExample.stream.output;

import java.io.*;

/**
 * Created by jetluo on 16/8/11.
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("./src/output/data.txt")
                )
        );
        out.writeDouble(3.14159);
        out.writeUTF("我");
        out.writeDouble(3.14159);
        out.writeUTF("你");
        out.writeUTF("3.3333");
        out.close();

        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("./src/output/data.txt")
                )
        );
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readUTF());
    }
}
