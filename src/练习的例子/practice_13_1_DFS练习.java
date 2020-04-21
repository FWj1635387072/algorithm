package 练习的例子;

import org.junit.Test;

public class practice_13_1_DFS练习 {
    //八皇后问题

    int max = 4;
    int[] arr = new int[4];

    boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i]))
                return false;
        }
        return true;
    }

    void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }


    void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + 1 + " ");
        }
        System.out.println();
    }
    @Test
    public void test_八皇后(){
        check(0);
    }



}
