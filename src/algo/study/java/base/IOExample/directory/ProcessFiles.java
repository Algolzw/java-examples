package algo.study.java.base.IOExample.directory;

import java.io.File;
import java.io.IOException;

/**
 * Created by jetluo on 16/8/9
 */
public class ProcessFiles {


    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else {
                for (String arg : args) {
                    File file = new File(arg);
                    if (file.isDirectory()) {
                        processDirectoryTree(new File(arg));
                    } else {
                        if (!arg.endsWith("." + ext))
                            arg += "." + ext;
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
            strategy.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        new ProcessFiles(
//                new Strategy() {
//                    public void process(File file) {
//                        System.out.println(file);
//                    }
//                }
                System.out::println  //lambda表达式风格
                , "java").start(new String[]{"./src/algo/study/java/base/IOExample/file/DirList", "./src/algo/study/java/base/IOExample"});
    }


}
