package 算法书例子.第二章;

import org.junit.Test;
import org.omg.CORBA.Any;
import 算法书例子.第一章.Util;

public class ch2 {
    //最大和序列

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

    static int max3(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else if (b > a && b > c)
            return b;
        else
            return c;
    }

    static int maxSubSum3(int[] a) {
        return maxSumRec(a, 0, a.length - 1);
    }

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


    public  static <Anytype extends Comparable<? super Anytype>>
    int binarySearch(Anytype[] a , Anytype x){
        int low = 0, high = a.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(a[mid].compareTo(x) < 0)
                low = mid + 1;
            else if(a[mid].compareTo(x) > 0)
                high = mid -1;
            else
                return mid;
        }
        return -1;
    }

}
