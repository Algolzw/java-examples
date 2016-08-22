package algo.study.java.base.IOExample.stream.input;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * bufferedInputStream缓冲输入文件
 */
public class BufferedInputFile {
    public static String read(String path) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));

        byte[] buffer = new byte[1];
        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        while ((tmp = in.read(buffer)) > 0) {
            sb.append(new String(buffer));
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("./src/algo/study/java/base/IOExample/file/DirList.java"));
    }
}
