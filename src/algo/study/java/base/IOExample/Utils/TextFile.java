package algo.study.java.base.IOExample.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 文本文件操作工具类
 */
public class TextFile extends ArrayList<String> {

    //将文件读取到String
    public static String read(String filename) {
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(new File(filename));
             BufferedReader reader = new BufferedReader(fileReader)
        ) {
            String s;
            while ((s = reader.readLine()) != null) {
                sb.append(s).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return sb.toString();
    }

    public static void write(String filename,String text){
        try(PrintWriter writer = new PrintWriter(new File(filename).getAbsoluteFile())){
            writer.print(text);
        }catch(IOException e){
            throw new RuntimeException();
        }
    }

    public TextFile(){
        super();
    }

    public TextFile(String filename){
        this(filename,"\n");
    }

    public TextFile(String filename,String splitter){
        super(Arrays.asList(read(filename).split(splitter)));
        if("".equals(get(0))) remove(0);
    }

    public void write(String filename){
        try(PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile())){
            this.forEach(out::println);
        }catch(IOException e){
            throw new RuntimeException();
        }
    }

    public static void main(String[] args){
        String file = read("./src/input/jobs.json");
        write("./src/output/testFile.json",file);

        TextFile textFile = new TextFile("./src/output/testFile.json");
        textFile.write("./src/output/testFile2.json");
        TreeSet<String> words = new TreeSet<>(
                new TextFile("./src/output/BasicFileOutput.out","\\W+")
        );
        System.out.println(words.headSet("a"));
    }

}

