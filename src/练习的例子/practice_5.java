package 练习的例子;

import com.sun.deploy.util.StringUtils;
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
                System.out.print(arr[r][c] + " ");
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

    @Test
    public void test3() {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 0, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        printArrZ(arr);
    }

    /**
     *
     * 倒Z输出二维数组
     *
     */

//------------------------

    /**
     * 给定一个N*N的矩阵，在这个矩阵中，只有0和1两种值，返回边框全是1的最大正方形的边长长度
     */

    static int FindMaxOrder(int[][] A) {
        int r;
        int c;
        int n = A.length;

        while (n > 0) {
            for (int i = 0; i < A.length; i++) {
                if (i + n > A.length) break;

                l1:
                for (int j = 0; i < A[0].length; j++) {
                    if (j + n > A[0].length) break;
                    r = i;
                    c = j;
                    while (c < j + n) {
                        if (A[r][c++] == 0) continue l1;
                    }

                    c--;
                    r++;
                    while (r < i + n) {
                        if (A[r++][c] == 0) continue l1;
                    }
                    r--;
                    c--;
                    while (c >= j) {
                        if (A[r][c--] == 0) continue l1;
                    }
                    c++;
                    r--;
                    while (r >= i) {
                        if (A[r--][c] == 0) continue l1;
                    }
                    return n;
                }
            }
            n--;
        }
        return 0;
    }


    @Test
    public void test4() {

        //五阶有bug

        int[][] arr = {
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 1, 1}
        };
        int[][] arr1 = {
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        System.out.println(FindMaxOrder(arr));

    }


    /**
     * 子数组最大累加和
     * 给定一个数组arr，返回子数组的最大累加和
     * 例：arr=[1,-2,3,5,-2,6,-1];所有的子数组中[3，5，-2，6]可以累加出最大的和12，所以返回12
     */


    static int getMaxSum(int[] arr) {
        int left = 0, right = 0;
        int sum = arr[0];
        int max = sum;
        for (int i = 0; i < arr.length; i++) {
            if (sum >= 0) {
                sum += arr[i];
            } else {
                sum = arr[i];
                left = i;
            }

            if (sum > max) {
                max = sum;
                right = i;
            }
        }
        return max;
    }

    @Test
    public void test5() {
        int[] arr = {1, -2, 3, 5, -2, 6, -1};
        System.out.println(getMaxSum(arr));
    }


}