package algo.study.java.base.IOExample.rw.writer;

import algo.study.java.base.IOExample.rw.reader.BufferedInputFile;

import java.io.*;

/**
 * Created by jetluo on 16/8/11.
 */
public class BasicFileOutputWithLineNumber {
    public static void main(String[] args) throws IOException{
        String outputFile = "./src/output/BasicFileOutputWithLineNumber.out";
        String readFilePath = "./src/algo/study/java/base/IOExample/rw/writer/BasicFileOutputWithLineNumber.java";

        LineNumberReader in = new LineNumberReader(
                new BufferedReader(new StringReader(BufferedInputFile.read(readFilePath)))

        );
        PrintWriter out = new PrintWriter(outputFile);

        String s;
        while( (s = in.readLine()) != null){
            out.println(in.getLineNumber() + " " + s);
        }
        out.close();

        System.out.println(BufferedInputFile.read(outputFile));
    }
}
