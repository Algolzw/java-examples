package algo.study.java.base.IOExample.nio;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jetluo on 16/8/15
 */
public class NIO106MappedIO {
    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;
    private static String filename = "./src/output/mappedio.txt";

    //测试输出用模板方法类
    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.print(name + " : ");
            try {
                long start = System.nanoTime(); //开始时纳秒
                test();
                double duration = System.nanoTime() - start;  //执行时间
                System.out.printf("%.2f\n", duration / 1.0e9); //格式化时间为秒
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //勾子方法
        public abstract void test() throws IOException;
    }

    public static Tester[] tests = {
            new Tester("stream write") {
                @Override
                public void test() throws IOException {
                    DataOutputStream out = new DataOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream(new File(filename))
                            )
                    );
                    for (int i = 0; i < numOfInts; i++)
                        out.writeInt(i);
                    out.close();
                }
            },
            new Tester("Mapped write") {
                @Override
                public void test() throws IOException {
                    FileChannel out = new RandomAccessFile(filename, "rw")
                            .getChannel();
                    IntBuffer buff = out.map(
                            FileChannel.MapMode.READ_WRITE, 0, numOfInts * 4
                    ).asIntBuffer();
                    for (int i = 0; i < numOfInts; i++)
                        buff.put(i);
                    out.close();
                }
            },
            new Tester("Stream read") {
                @Override
                public void test() throws IOException {
                    DataInputStream in = new DataInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(new File(filename))
                            )
                    );
                    for (int i = 0; i < numOfInts; i++)
                        in.readInt();
                    in.close();
                }
            },
            new Tester("Mapped read") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile(filename, "rw").getChannel();
                    IntBuffer buff = fc.map(
                            FileChannel.MapMode.READ_WRITE, 0, numOfInts * 4
                    ).asIntBuffer();
                    while (buff.hasRemaining())
                        buff.get();
                    fc.close();
                }
            },
            new Tester("Stream read/write") {
                @Override
                public void test() throws IOException {
                    RandomAccessFile raf = new RandomAccessFile(new File(filename), "rw");
                    raf.writeInt(1);
                    for (int i = 0; i < numOfUbuffInts; i++) {
                        raf.seek(raf.length() - 4);
                        raf.writeInt(raf.readInt());
                    }
                    raf.close();
                }
            },
            new Tester("Mapped read/write") {
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile(new File(filename), "rw").getChannel();
                    IntBuffer ib = fc.map(
                            FileChannel.MapMode.READ_WRITE, 0, numOfUbuffInts * 4
                    ).asIntBuffer();
                    ib.put(0);
                    for (int i = 1; i < numOfUbuffInts; i++) {
                        ib.put(ib.get(i - 1));
                    }
                    fc.close();
                }
            }
    };

    public static void main(String[] args) {
        for (Tester tester : tests)
            tester.runTest();
    }

}
