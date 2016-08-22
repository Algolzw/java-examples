package algo.study.java.base.IOExample.rw.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 缓冲输入文件
 */
public class BufferedInputFile {
    public static String read(String path) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(path));
        String buffer;
        StringBuilder sb = new StringBuilder();
        while((buffer = in.readLine()) != null){
            sb.append(buffer + "\n");
        }
        in.close();
        return sb.toString();
    }

    //文件内容倒序输出
    public static void reverseFile(String path) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        LinkedList<String> lines = new LinkedList<>();
//        ArrayList<String> lines = new ArrayList<>();

        String buffer;
        while((buffer = reader.readLine()) != null){
            lines.add(buffer.toUpperCase());
        }
        //method1:利用linkedList的descendingIterator
        Iterator<String> iter = lines.descendingIterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        //method2:for循环倒序
//        for(int i=0;i<lines.size();i++){
//            System.out.println(lines.get(lines.size()-i-1));
//        }
        //method3:linkedList的pollLast方法(链表)
//        while(lines.size()>0)
//            System.out.println(lines.pollLast());
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("./src/algo/study/java/base/IOExample/file/DirList.java"));
        System.out.println("....................");
        reverseFile("./src/algo/study/java/base/IOExample/file/DirList.java");
    }
}
