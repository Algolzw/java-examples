package algo.study.java.base.commons.data;

/**
 * Created by jetluo on 16/8/6.
 */
public class Strings {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "cd";

        String s3 = s1;

        System.out.println(s3==s1);
        s3 = s1+s2;
        System.out.println(s3==s1);
        System.out.println(s3);
    }
}
