package 官网题目;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for (int i = 100; i <= 999; i++) {
            int x = i / 100;
            int y = (i / 10) % 10;
            int z = i % 10;
            if (x * y * z != 0) {
                if (2 * (x + y) + z == num) {
                    list.add(x * 10000 + y * 1000 + z * 100 + y * 10 + x);
                } else if (2 * (x + y + z) == num) {
                    list.add(x * 100000 + y * 10000 + z * 1000 + z * 100 + y * 10 + x);
                }
            } else {
                if (2 * (x + y) + z == num) {
                    String s = "" + x + y + z + y + x;
                    list.add(Integer.parseInt(s));
                }
                if (2 * (x + y + z) == num) {
                    String s = "" + x + y + z + z + y + x;
                    list.add(Integer.parseInt(s));
                }
            }
        }
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void test1() {

        String s = "" + 9 + 9 + 0 + 0 + 9 + 9;
        System.out.println(s);
    }
}
