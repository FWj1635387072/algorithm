package 算法书例子.第三章;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Goldbach {
    /**
     * 受数据类型限制，检测值不能超过int的取值
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入要查询的偶数值：");
        int n = scan.nextInt();

        if (n % 2 != 0 || n <= 2) {
            System.out.println("输入不合法！");
            return;
        }
        //测试开始时间点
        long l = System.currentTimeMillis();
        //获取n以下的所有素数，且有序
        List<Integer> list = initArray1(n);
        int pleft = 0, pright = list.size() - 1;
        //找出两个值和为n
        while (pleft < pright) {
            if (list.get(pleft) + list.get(pright) == n) {
                System.out.println(n + " = " + list.get(pleft) + " + " + list.get(pright));
                System.out.println("运行时间：" + (System.currentTimeMillis() - l) + "ms");
                return;
            } else if (list.get(pleft) + list.get(pright) < n)
                pleft++;
            else
                pright--;
        }
        System.out.println("不满足");
    }

    /**
     * 筛选法求出小于n的所有素数，放到list中，返回list
     *
     * @param a
     * @return
     */
    static List<Integer> initArray(int a) {
        List<Integer> list = new ArrayList<Integer>();
        byte[] num = new byte[a + 1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i < a + 1; ++i) {
            if (num[i] == 0) {
                for (int j = 2 * i; j < a + 1; j += i) {
                    num[j] = 1;
                }
            }
        }
        for (int i = 2; i < a + 1; i++) {
            if (num[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     *  暴力求素数
     * @param a
     * @return
     */
    static List<Integer> initArray1(int a) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i < a + 1; ++i) {
            boolean b = true;
            isPrime(i);
            if (b) {
                list.add(i);
            }
        }
        return list;
    }
    static boolean isPrime(long sum) {
        for (long i = 2; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0)
                return false;
        }
        return true;
    }
}
