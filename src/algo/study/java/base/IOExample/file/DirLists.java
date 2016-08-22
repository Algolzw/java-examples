package algo.study.java.base.IOExample.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by jetluo on 16/8/9
 */
public class DirLists {

    //获取path下的所有目录和文件列表
    public static String[] getList(String path){
        File filePath = new File(path);
        String[] list = filePath.list();
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        return list;
    }

    //获取匹配的文件列表子集
    public static String[] getList(String path,String filterFormat){
        File filepath = new File(path);
        String[] list = null;
        if(filterFormat != null && filterFormat.length()>0){
            list = filepath.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(filterFormat);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        else
            list = filepath.list();
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        return list;
    }

    public static void main(String[] args) {
        String path = "./src/algo/study/java/base/IOExample/file";
        String[] list = getList(path);
        System.out.println("All files : "+Arrays.toString(list));

        String filterFormat = ".*List.*";
        list = getList(path,filterFormat);
        System.out.println("\nfilteredFiles : "+Arrays.toString(list));
    }
}
