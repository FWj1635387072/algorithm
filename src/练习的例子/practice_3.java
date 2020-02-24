package 练习的例子;

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

}
