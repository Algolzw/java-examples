package algo.study.java.base.IOExample.directory;

import java.io.File;
import java.io.FilenameFilter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 工具类
 */
public class Directory {
    //返回dir下的文件列表
    public static File[] local(File dir,final String regex){
        return dir.listFiles(new FilenameFilter(){
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir,String name){
                return pattern.matcher(
                        new File("name").getName()
                ).matches();
            }
        });
    }

    public static File[] local(String path,final String regex){
        return local(new File(path),regex);
    }

    public static class TreeInfo implements Iterable<File>{
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString(){
            return "dirs: "+ Arrays.toString(dirs.toArray())+
                    "\nfiles: "+Arrays.toString(files.toArray());
        }

    }

    public static TreeInfo walk(String start,String regex){
        return recurseDirs(new File(start),regex);
    }

    public static TreeInfo walk(File startDir,String regex){
        return recurseDirs(startDir,regex);
    }

    public static TreeInfo walk(File start){
        return recurseDirs(start,".*");
    }

    public static TreeInfo walk(String start){
        return recurseDirs(new File(start),".*");
    }

    public static TreeInfo recurseDirs(File startDir,String regex){
        TreeInfo result = new TreeInfo();
        for(File item:startDir.listFiles())
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else {
                if (item.getName().matches(regex))
                    result.files.add(item);
            }
        return result;
    }

    public static long totalSize(File startDir,String regex){
        TreeInfo infos = walk(startDir,regex);
        long size = 0;
        for(File file:infos.files){
            size += file.length();
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(walk("."));
        System.out.println("totalSize获取文件目录大小:"+totalSize(new File("."),".*")/1000);
        System.out.println("直接length获取文件目录大小:"+new File(".").length());
        System.out.println(new File(".").length());
        System.out.println(walk("./src/algo/study/java/base/IOExample/"));

        File file = new File("./src/algo/study/java/base/IOExample/file/DirList.java");
        System.out.println("\nname :"+file.getName());
        System.out.println("can read :"+file.canRead());
        System.out.println("can write :"+file.canWrite());
        System.out.println("parent :" + file.getParent());
        System.out.println("length :" + file.length());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(file.lastModified()));
        LocalDateTime modifyDate = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
        System.out.println("last modified :" + modifyDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("is file ? :" + file.isFile());
        System.out.println("is directory ? :" + file.isDirectory());
    }

}
