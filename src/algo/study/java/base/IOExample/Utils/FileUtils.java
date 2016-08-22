package algo.study.java.base.IOExample.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by jetluo on 16/8/11.
 */
public class FileUtils {
    public static File createFile(String path) throws IOException{
        Path p = Paths.get(path);
        if(!Files.exists(p)){
            if(Files.exists(p.getParent()))
                Files.createDirectories(p.getParent());
            Files.createFile(p);
        }
        return p.toFile();
    }
}
