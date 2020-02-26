package 练习的例子;

import org.junit.Test;
import 算法书例子.第一章.Util;

public class practice_3 {
    public static void main(String[] args) {
        int[] arr = {78, 56, 34, 43, 4, 1, 15, 2, 23};
        preOrder(arr, 0);
        System.out.println("==================");
        inOrder(arr, 0);
        System.out.println("==================");
        rightOrder(arr, 0);
    }

    /**
     * 树的先序遍历
     *
     * @param arr
     * @param i
     */
    static void preOrder(int[] arr, int i) {
        if (i >= arr.length) {
            return;
        }
        System.out.println(arr[i]);
        preOrder(arr, i * 2 + 1);
        preOrder(arr, i * 2 + 2);
    }

    /**
     * 树的中序遍历
     *
     * @param arr
     * @param index
     */
    static void inOrder(int[] arr, int index) {
        if (index >= arr.length)
            return;
        inOrder(arr, index * 2 + 1);
        System.out.println(arr[index]);
        inOrder(arr, index * 2 + 2);
    }

    /**
     * 树的后序遍历
     *
     * @param arr
     * @param index
     */
    static void rightOrder(int[] arr, int index) {
        if (index >= arr.length)
            return;
        rightOrder(arr, index * 2 + 1);
        rightOrder(arr, index * 2 + 2);
        System.out.println(arr[index]);
    }


    /**
     * MinHeap 小顶堆
     *
     * @param A
     */
    static void MinHeap(int[] A) {
        for (int i = A.length / 2 - 1; i >= 0; i--) {
            MinHeapFixDown(A, i, A.length);
        }

    }


    static void MinHeapFixDown(int[] A, int i, int n) {
        //找到左右孩子
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        //左孩子越界，i就是叶子节点
        if (left >= n) {
            return;
        }
        int min = left;
        if (right >= n) {
            min = left;
        } else {
            if (A[right] < A[left]) {
                min = right;
            }
        }

        //如果A[i]比两个孩子都要小，不用调整
        if (A[i] <= A[min]) {
            return;
        } else {                  //否则，找到两个孩子中较小的，和i交换
            int temp = A[i];
            A[i] = A[min];
            A[min] = temp;
        }
        //小孩子那个位置的值发生了变化，i变更为小孩子那个位置，递归调整
        MinHeapFixDown(A, min, n);
    }

    static void sort(int[] a) {
        MinHeap(a);
        for (int i = a.length - 1; i >= 0; i--) {
            swap(a, 0, i);
            MinHeapFixDown(a, 0, i - 1);
        }
    }

    @Test
    public void test1() {
       /* int[] a = {4, 2, 6, 1, 3, 5, 7};
        MinHeap(a);
        String s = Util.printArr(a);
        System.out.println(s);
        a = new int[]{4, 2, 6, 1, 3, 5, 7};
        sort(a);
        s = Util.printArr(a);
        System.out.println(s);*/
        int[] a = {4, 2, 6, 1, 3, 5, 7};
        maxHeap(a);
        String s = Util.printArr(a);
        System.out.println(s);
        a = new int[]{4, 2, 6, 1, 3, 5, 7};
        sort1(a);
        s = Util.printArr(a);
        System.out.println(s);

    }

    /**
     * swap A[a] with A[b]
     *
     * @param arr
     * @param a
     * @param b
     */
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    static void maxHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            maxHeapFixDown(a, i, a.length);
        }
    }

    static void maxHeapFixDown(int[] A, int i, int n) {

        //找到左右子节点
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        //确定是否有子节点,确定最大值
        int max = left;
        if (left >= n)
            return;
        if (right >= n) {
            max = left;
        } else {
            if (A[right] > A[left]) {
                max = right;
            }
        }
        //最大值上浮
        swap(A, i, max);
        //递归向下对子树进行上浮
        maxHeapFixDown(A, max, n);
    }

    static void sort1(int[] A) {
        maxHeap(A);
        for (int i = A.length - 1; i >= 0; i--) {
            swap(A, 0, i);
            maxHeapFixDown(A, 0, i - 1);
        }
    }


}
