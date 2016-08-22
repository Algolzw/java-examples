package algo.study.java.base.IOExample.rw.writer;

import algo.study.java.base.IOExample.Utils.FileUtils;
import algo.study.java.base.IOExample.rw.reader.BufferedInputFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by jetluo on 16/8/11.
 */
public class BasicFileOutputShortcut {
    public static void main(String[] args) throws IOException {
        String data = BufferedInputFile.read("./src/algo/study/java/base/IOExample/file/DirList.java");
        String file = "./src/output/BasicFileShortcut.out";
        FileUtils.createFile(file);
        try(StringReader reader = new StringReader(data);
            BufferedReader in = new BufferedReader(reader);
            PrintWriter out = new PrintWriter(file)){
            int lineCount = 0;
            String s;
            while((s = in.readLine())!=null){
                out.println(++lineCount + " " + s);
            }
        }
        System.out.println(BufferedInputFile.read(file));
    }
}
