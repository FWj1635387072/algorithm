package 算法书例子.第二章;

import org.junit.Test;
import org.omg.CORBA.Any;
import 算法书例子.第一章.Util;

import java.math.BigInteger;

public class ch2 {
    //最大子序列和

    /**
     * Get max subSum1
     *
     * @param a
     * @return
     */
    static int maxSubSum1(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++)
                    thisSum += a[k];
                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        return maxSum;
    }

    /**
     * Get max subSum2
     *
     * @param a
     * @return
     */
    static int maxSubSum2(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }

        return maxSum;
    }

    /**
     * Get max subSum3 part1
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    static int maxSumRec(int[] a, int left, int right) {
        if (left == right)
            if (a[left] > 0)
                return a[left];
            else
                return 0;

        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }

        return max3(maxLeftSum, maxRightBorderSum, maxLeftBorderSum + maxRightBorderSum);
    }

    /**
     * Get the Max num
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    static int max3(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else if (b > a && b > c)
            return b;
        else
            return c;
    }

    /**
     * Get max subSum3
     *
     * @param a
     * @return
     */
    static int maxSubSum3(int[] a) {
        return maxSumRec(a, 0, a.length - 1);
    }

    /**
     * Get max subSum4
     *
     * @param a
     * @return
     */
    static int maxSubSum4(int[] a) {
        int thisSum = 0, maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }

    @Test
    public void test1() {
        long l = System.currentTimeMillis();
        int[] a1 = {4, -3, 5, -2, -1, 2, 6, -2};
        int i = maxSubSum3(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
        Util.duration(l);
    }


    /**
     * binary Search
     *
     * @param a
     * @param x
     * @param <Anytype>
     * @return
     */
    public static <Anytype extends Comparable<? super Anytype>>
    int binarySearch(Anytype[] a, Anytype x) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid].compareTo(x) < 0)
                low = mid + 1;
            else if (a[mid].compareTo(x) > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }


    /**
     * gcd
     * //最大共因数
     *
     * @param m
     * @param n
     * @return
     */
    public static long gcd(long m, long n) {
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    /**
     *  get  x ** n
     * @param x
     * @param n
     * @return
     */
    public static BigInteger pow(BigInteger x, BigInteger n) {
        if (n.equals(0))
            return new BigInteger("1");
        if (n.equals(1))
            return x;
        if (x.mod(new BigInteger("2")).equals(new BigInteger("0")))
            return pow(x.multiply(x), n.divide(new BigInteger("2")));
        else
            return pow(x.multiply(x), n.divide(new BigInteger("2")).multiply(x));
    }

    /**
     * 使用递归进行幂运算(long类型)，其运算范围小于使用math函数，但速度快
     *  使用BigInteger更好更快
     * res:
     * 1.0E20
     * 1ms
     * 10000000000000000
     * 0ms
     */
    @Test
    public void test22(){
        long l = System.currentTimeMillis();
        double d =  Math.pow(100,10);
        System.out.println(d);
        Util.duration(l);

        l = System.currentTimeMillis();
        System.out.println(new BigInteger("100").pow(10));
        Util.duration(l);
    }
}
