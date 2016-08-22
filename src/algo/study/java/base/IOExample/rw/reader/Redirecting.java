package algo.study.java.base.IOExample.rw.reader;

import java.io.*;

/**
 * Created by jetluo on 16/8/11.
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("./src/input/jobs.json")
        );

        PrintStream out = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("./src/output/redirecting.txt")
                )
        );

//        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String s;
        while ((s = reader.readLine()) != null && s.length() != 0)
            System.out.println(s);
        out.close();
        System.setOut(console);

    }
}
