package 练习的例子;

import org.junit.Test;
import 算法书例子.第一章.Util;

import java.util.*;

public class practice_4 {
    /**
     * 鸽巢排序：
     * 快，但是原始数据范围大，稀疏，则辅助空间大，稀疏，造成空间的浪费。
     * <p>
     * 思路：
     * 开辟数组中 max - min + 1 大小的辅助空间，然后对应下标进行计数。
     */
    static void countSort(int[] arr) {
        int min = Util.minOf(arr);
        int max = Util.maxOf(arr);

        int[] helper = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            helper[arr[i] - min] += 1;
        }
        int j = 0;
        for (int i = 0; i < helper.length; i++) {
            while (helper[i] > 0) {
                arr[j] = i + min;
                j++;
                helper[i]--;
            }
        }
    }

    @Test
    public void test() {
        int[] a = {-3, -6, 12, 15, 23, -20, 10};
        System.out.println(Util.printArr(a));
        countSort(a);
        System.out.println(Util.printArr(a));
    }


    /**
     * 排序数组中找和的因子
     * 给定已排序数组arr和k，不重复打印arr中所有相加和为k的不降序二元组
     * 如输入arr={-8,-4,-3,0,2,4,5,8,9,10}
     * 输出（0，10），（2，8）
     * 思路：
     * 已排序，想到二分，第一个-8和后面的数找。。。
     * 但是-8和10 和为2，则-8和10之间没有数满足。
     * 所以可以用双指针
     */

    static void findFactor(int[] arr, int a) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] + arr[right] < a) {
                left++;
            }
            while (left < right && arr[left] + arr[right] > a) {
                right--;
            }
            if (left != right && arr[left] + arr[right] == a)
                System.out.println(arr[left] + "   " + arr[right]);
            right--;
        }
    }

    @Test
    public void test1() {
        int[] arr = {-8, -4, -3, 0, 2, 4, 5, 8, 9, 10};
        findFactor(arr, 10);
    }


    /**
     * 计数排序实例
     * 公司现在要对几万员工的年龄进行排序，因为公司员工的人数非常多，、
     * 所以要求排序算法的效率要非常高，你能写出这样的程序吗？
     * 第一行为一个整数n(1 <= n <= 1000000)：代表公司内员工的人数，
     * 输入的第二行包括n各整数：代表公司内每个员工的年龄，其中，员工年龄age的取值范围为（1 <= age <= 99）
     * 输出：对应每个测试案例
     * 输出n个员工的年龄，每个年龄后有一个空格。
     */
    static void sortAge() {
        int[] help = new int[100];
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a;
        for (int i = 0; i < n; i++) {
            a = scan.nextInt();
            help[a + 1]++;
        }

        for (int i = 0; i < help.length; i++) {
            while (help[i] > 0) {
                System.out.println((i + 1) + " ");
            }
        }
    }

    /**
     * 特殊排序
     */
    static int f(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            s.append(arr[i]);
        }
        return Integer.parseInt(s.toString());
    }


    @Test
    public void test2() {
        int res = f(new Integer[]{32, 12, 1});
        System.out.println(res);
    }


    /**
     * 数组的包含：
     * 输入两个字符串str1和str2，请判断str1中的所有字符是否都存在于str2中
     */
    static boolean check(String a, String b) {
        char[] ch = b.toCharArray();
        Arrays.sort(ch);

        int len = a.length();
        for (int i = 0; i < len; i++) {
            int index = Arrays.binarySearch(ch, a.charAt(i));
            if (index < 0)
                return false;
        }
        return true;
    }
    static boolean check1(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (b.indexOf(a.charAt(i)) < 0)
                return false;
        }
        return true;
    }


    @Test
    public void test3(){
        System.out.println(check("a,,as","asdaewa"));
        System.out.println(check("123","12345"));
        System.out.println(check1("a,,as","asdaewa"));
        System.out.println(check1("123","12345"));
    }



}
