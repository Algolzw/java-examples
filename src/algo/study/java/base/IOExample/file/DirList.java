package algo.study.java.base.IOExample.file;

import java.io.File;
import java.util.Arrays;

/**
 * Created by jetluo on 16/8/7.
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File("./src/algo/study/java/base/IOExample/file");
        String[] list;
        if(args.length==0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String item:list)
            System.out.println(item);
    }

}