package algo.study.java.base.IOExample.rw.writer;

import algo.study.java.base.IOExample.stream.input.BufferedInputFile;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by jetluo on 16/8/11.
 */
public class BasicFileOutput {
    public static void main(String[] args) throws IOException {
        String path = "./src/output/BasicFileOutput.out";
        //使用java.io.File创建输出文件
        File file = new File(path);

        if(!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        //使用java.nio.file创建输出文件
//        Path p = Paths.get(path);
//        if(!Files.exists(p)) {
//            Files.createDirectories(p.getParent());
//            Files.createFile(p);
//        }

        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read("./src/algo/study/java/base/IOExample/file/DirList.java"))
        );
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(path))
        );
        int lineCount = 0;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(++lineCount + " " + s);
        }
        out.close();
        in.close();
        System.out.println(BufferedInputFile.read(path));
    }
}
