public class 递归 {


    public static void main(String[] args) {
        System.out.println(jc(5));
        print2(1, 10);
        System.out.println("------------------");
        int[] arr = Util.getIntArr(6, 20, 0);
        int sum = sumArr(arr, 0);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("------------------");
        System.out.println(sum);
        System.out.println("------------------");
        String str = "abcd";
        System.out.println(reverse(str, str.length() - 1));
        System.out.println("------------------");
        System.out.println(fib(6));

        System.out.println("------------------");
        System.out.println(gcd(115, 30));
        System.out.println("------------------");
        sortArr(arr, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("------------------");
        printHanoitower(3, "A", "B", "C");

    }


    //阶乘
    static int jc(int i) {
        if (i == 1)
            return 1;
        return i * jc(i - 1);
    }

    //输出两个数之间的所有数
    static void print2(int i, int j) {
        if (i > j)
            return;
        System.out.println(i);
        print2(++i, j);
    }

    //对arr求和
    static int sumArr(int[] arr, int begin) {
        if (begin == arr.length)
            return 0;
        return arr[begin] + sumArr(arr, ++begin);
    }

    //反转字符串
    static String reverse(String str, int end) {
        if (end == 0)
            return str.charAt(0) + "";
        return str.charAt(end) + reverse(str, --end);
    }

    //斐波那契数列
    static int fib(int num) {
        if (num == 1 || num == 2)
            return 1;
        return fib(num - 1) + fib(num - 2);
    }

    //辗转相除法求最大公约数
    static int gcd(int biger, int smaller) {
        if (smaller == 0)
            return biger;
        return gcd(smaller, biger % smaller);
    }

    //对数组进行排序
    static void sortArr(int[] arr, int index) {
        if (index == 0)
            return;
        sortArr(arr, index - 1);
        int i = index - 1;
        int temp = arr[index];
        while (i > -1 && temp < arr[i]) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = temp;
    }

    /*  将n个盘子从sourse移动到target的路径打印
     *  N：初始的N个从小到大的盘子，N是最大编号
     *  from：原始柱子
     *  to：目标柱子
     *  help：辅助柱子
     * */

    static void printHanoitower(int N, String from, String to, String help) {
        if (N == 1) {
            System.out.println("move " + N + " from " + from + " to " + to);
        } else {
            printHanoitower(N - 1, from, help, to);
            System.out.println("move " + N + " from " + from + " to " + to);
            printHanoitower(N - 1, help, to, from);
        }
    }





    //




}
