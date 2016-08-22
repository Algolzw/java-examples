package algo.study.java.base.IOExample.stream.input;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException{
        DataInputStream in = new DataInputStream(
                new ByteArrayInputStream(
                        BufferedInputFile.read("./src/algo/study/java/base/IOExample/file/DirList.java").getBytes()
                )
        );
        while(in.available() != 0)
            System.out.print((char)in.readByte());
    }
}
