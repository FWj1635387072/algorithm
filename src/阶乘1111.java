import org.junit.Test;

public class 阶乘1111 {

    public static void main(String[] args) {
        printS(1, 10);
        System.out.println(sum(new int[]{1, 213, 2}, 0));
        System.out.println(reverse("abcd", 3));

        System.out.println(getFB(4));
    }


    // 求阶乘
    public static int jiecheng(int i) {
        if (i == 1 || i == 0)
            return 1;
        else
            return i * jiecheng(i - 1);
    }

    //打印i---j
    public static void printS(int i, int j) {
        if (i != j) {
            System.out.println(j);
            printS(i, j - 1);
        } else {
            System.out.println(j);
        }
    }

    //数组求和
    public static int sum(int[] arr, int i) {
        if (i == arr.length)
            return 0;

        else
            return arr[i] + sum(arr, i + 1);
    }

    //反转字符串
    public static String reverse(String s, int i) {
        if (i == 0)
            return "" + s.charAt(0);
        else
            return s.charAt(i) + reverse(s, i - 1);
    }

    //斐波那契数列
    public static int getFB(int i) {
        if (i == 1 || i == 2)
            return 1;
        else
            return getFB(i - 1) + getFB(i - 2);
    }

    static void ShellSort(int[] arr) {
        for (int inteval = arr.length / 2; inteval > 0; inteval = inteval / 2) {
            for (int i = inteval; i < arr.length; i++) {
                int j = i - inteval;
                int t = arr[i];
                while (j > -1 && arr[j] > t) {
                    arr[j + inteval] = arr[j];
                    j -= inteval;
                }
                arr[j + inteval] = t;
            }
        }
    }


    @Test
    public void test2() {
        int[] arr = Util.getIntArr(20, 1, 30);
        System.out.println(Util.printArr(arr));
        ShellSort(arr);
        System.out.println(Util.printArr(arr));


    }

    static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int t = arr[i];
            while (j > -1 && arr[j] > t) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = t;
        }
    }

    @Test
    public void test11() {
        int[] arr = Util.getIntArr(20, 1, 30);
        System.out.println(Util.printArr(arr));
        insertSort(arr);
        System.out.println(Util.printArr(arr));
    }

}

