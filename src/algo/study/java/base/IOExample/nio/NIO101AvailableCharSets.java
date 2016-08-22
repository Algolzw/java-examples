package algo.study.java.base.IOExample.nio;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * Created by jetluo on 16/8/12.
 */
public class NIO101AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String,Charset> charsets = Charset.availableCharsets();
        charsets.forEach((n,v)->{
            System.out.print(n+" : ");
            v.aliases().forEach(a->System.out.print(a+", "));
            System.out.println();
        });
//        System.out.println(System.getProperty("file.encoding"));
    }
}
