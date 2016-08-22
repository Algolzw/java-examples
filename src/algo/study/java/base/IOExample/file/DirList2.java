package algo.study.java.base.IOExample.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by jetluo on 16/8/9.
 */
public class DirList2 {
    /**
     * 若匿名内部类需要调用方法参数,则方法参数必须为final
     */
    public static void main(final String[] args) {
        File filepath = new File("./src/algo/study/java/base/IOExample/file");
        String[] list = null;
        if(args.length == 0)
            list = filepath.list();
        else
            list = filepath.list(
                    new FilenameFilter() {
                        private Pattern pattern  = Pattern.compile(args[0]);
                        @Override
                        public boolean accept(File dir, String name) {
                            return pattern.matcher(name).matches();
                        }
                    }
            );
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String s:list)
            System.out.println(s);
    }
}
