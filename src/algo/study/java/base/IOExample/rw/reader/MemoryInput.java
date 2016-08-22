package algo.study.java.base.IOExample.rw.reader;

import java.io.IOException;
import java.io.StringReader;

/**
 * 从内存输入
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader(
                BufferedInputFile.read("./src/algo/study/java/base/IOExample/file/DirList.java"));
        int c;
        while((c=reader.read())!=-1){
            System.out.print((char)c);
        }
    }
}
