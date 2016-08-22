package algo.study.java.base.IOExample.Utils;

import java.io.*;

/**
 * Created by jetluo on 16/8/11.
 */
public class BinaryFile {
    public static byte[] read(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream in = new BufferedInputStream(fis)) {
            byte[] data = new byte[in.available()];
            in.read(data);
            return data;
        }
    }

    public static byte[] read(String filename) throws IOException {
        return read(new File(filename));
    }

    public static void write(String filename, byte[] data) throws IOException {
        BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(new File(filename))
        );
        out.write(data);
        out.close();
    }

    public static void main(String[] args) throws IOException {
        String outputFile = "./src/output/io.jpg";
        long t1 = System.currentTimeMillis();
        byte[] datas = read("./src/input/io.jpg");
        if (!new File(outputFile).exists())
            FileUtils.createFile(outputFile);
        write(outputFile, datas);
        long t2 = System.currentTimeMillis();
        System.out.println("cost time:" + (t2-t1));
    }

}
