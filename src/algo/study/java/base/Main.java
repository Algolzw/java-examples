package algo.study.java.base;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println();
        int a = 1,b = 2;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a+" "+b);

        Byte A = 'A';
        System.out.println(A);
        Byte B = 'a';
        System.out.println(B);
        byte[] C = {48,55,56,57,58,59,60,65,90,91,92,93,94,95,96,122};
        System.out.println(new String(C));
    }
}
