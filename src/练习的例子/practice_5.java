package 练习的例子;

import org.junit.Test;
import 算法书例子.第一章.Util;

public class practice_5 {

    /**
     * 顺时针打印二维数组
     */

    static void printArr(int[][] arr) {

        int leftTopRow = 0, leftTopCol = 0, rightLowRow = arr.length - 1, rightLowCol = arr[0].length - 1;
        int r = leftTopRow, c = leftTopRow;
        while (leftTopCol <= rightLowCol && leftTopRow <= rightLowRow) {
            while (c <= rightLowCol) {
                System.out.print(arr[r][c++] + " ");
            }

            c = rightLowCol;
            r++;
            while (r <= rightLowRow) {
                System.out.print(arr[r++][c] + " ");
            }

            r--;
            c--;
            while (c >= leftTopCol) {
                System.out.print(arr[r][c--] + " ");
            }

            c++;
            r--;
            while (r > leftTopRow) {
                System.out.print(arr[r--][c] + " ");
            }
            leftTopCol++;
            leftTopRow++;
            rightLowCol--;
            rightLowRow--;
            r = leftTopRow;
            c = leftTopRow;
        }


    }

    @Test
    public void test1() {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        printArr(arr);
        int[][] arr1 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}

        };
        printArr(arr1);
    }

    /**
     * 将元素为0的所在行，所在列清零
     */

    static void solve(int[][] arr) {
        int[] r = new int[arr.length];
        int[] c = new int[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    r[i] = 1;
                    c[j] = 1;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (r[i] == 1 || c[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    @Test
    public void test2() {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 0, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        solve(arr);
        //输出二维矩阵
        Util.printArr(arr);

    }


    /**
     * Z字形打印二维数组
     */
    static void printArrZ(int[][] arr) {
        int r = 0;
        int c = 0;
        int m = arr.length, n = arr[0].length;
        //true代表上升，false代表下降
        boolean d = true;
        while (r < arr.length && c < arr[0].length) {
            if (d) {
                System.out.print(arr[r][c] + " ");
                if (r == 0 && c < n - 1) {
                    d = !d;
                    c++;
                    continue;
                } else if (r > 0 && c == n - 1) {
                    d = !d;
                    r++;
                    continue;
                } else {
                    r--;
                    c++;
                }
            } else {
                System.out.println(arr[r][c] + " ");
                if (c == 0 && r < m - 1) {
                    d = !d;
                    r++;
                    continue;
                } else if (r == m - 1) {
                    d = !d;
                    c++;
                    continue;
                } else {
                    r++;
                    c--;
                }
            }
        }

    }


}