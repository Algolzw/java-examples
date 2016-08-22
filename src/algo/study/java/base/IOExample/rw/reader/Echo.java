package algo.study.java.base.IOExample.rw.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 从标准输入中读取数据(system.in)
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        //对System.in进行包装
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in)
        );
        String s;
        while((s = reader.readLine()) != null && s.length() != 0)
            System.out.println(s);
    }
}
