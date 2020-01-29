package 练习的例子;

import org.junit.Test;


/*
 *      日期和字符串
 *
 *
 * */
public class practice_1 {
    //输出字母三角形
    static void PrintTriangle(int n) {
        String s = "";
        char c = ' ';
        for (int i = 1; i <= n; i++) {
            s = "";
            for (int j = 1; j <= n - i; j++) {
                s += " ";
            }
            c = 'A';
            for (int j = 1; j <= 2 * i - 1; j++) {
                s += (char) (c + i - 1);
            }
            System.out.println(s);
        }
    }

    static void printTriAngle1(int n) {
        String s = "";
        for (int i = 1; i <= n; i++) {
            s = "";
            for (int j = 1; j <= n - i; j++) {
                s += " ";
            }
            for (int j = 1; j <= i; j++) {
                s += (char) ('A' + j - 1);
            }
            for (int j = i - 1; j >= 1; j--) {
                s += (char) ('A' + j - 1);
            }
            System.out.println(s);
        }
    }


    static void printTriAngle2(char c) {
        int i = c - 'A' + 1;
        printTriAngle1(i);
    }

    static void printTriAngle3(int n) {
        String s = "";
        for (int i = 1; i <= n; i++) {
            s = "";
            for (int j = 1; j <= n - i; j++) {
                s += " ";
            }
            for (int j = 1; j <= i; j++) {
                s += j;
            }
            for (int j = i - 1; j >= 1; j--) {
                s += j;
            }
            System.out.println(s);
        }
    }

    static void printTriAngle(String s) {
        if ((char) s.charAt(0) >= 'A' && (char) s.charAt(0) <= 'Z') {
            printTriAngle2(s.charAt(0));
        } else {
            printTriAngle3(Integer.parseInt(s));
        }

    }


    @Test
    public void test11() {
        printTriAngle("5");
    }


}
