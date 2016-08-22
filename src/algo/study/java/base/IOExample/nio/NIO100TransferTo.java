package algo.study.java.base.IOExample.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by jetluo on 16/8/12
 */
public class NIO100TransferTo {
    public static void main(String[] args) throws Exception {
        String source = "./src/input/jobs.json";
        String target = "./src/output/transferTo.json";

        FileChannel
                in = new FileInputStream(new File(source)).getChannel(),
                out = new FileOutputStream(new File(target)).getChannel();
        in.transferTo(0,in.size(),out);
    }
}
