import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 算法竞赛4 {
    /*
        1、小白上楼梯。
            共有n阶楼梯，假如每次只能上1、2或3个台阶，问有几种上楼梯的方案。
        问题分析：
            该类问题可以倒着想。
            小白最后一步是在倒数第二、第三、第四个台阶。
            总方案 = 到倒数第二个台阶的方案 + 到倒数第三个台阶的方案 + 到倒数第四个台阶的方案。
            f(n) = f(n - 1 ) + f(n - 2) + f(n - 3)
            得到递推公式，明显，该表达式为一递归表达式。

            递归的三步走：
                找重复、找变化、找边界
            边界值：当n = 1时，返回1，f(1) = f(0) + f(-1) + f(-2)
                   当n = 2时，返回2，f(2) = f(1) + f(0) + f(-1)
                   当n = 3时，返回4，f(3) = f(2) + f(1) + f(0)
            当n < 0时，返回0；
            当n = 0时，返回1
     */
    static int f1(int n) {
        if (n == 0)
            return 1;
        else if (n < 0)
            return 0;
        else
            return f1(n - 1) + f1(n - 2) + f1(n - 3);
    }

    @Test
    public void testF1() {
        System.out.println(f1(4));
        Assertions.assertThat(f1(4)).isEqualTo(7);
    }


    /*
        2、旋转数组的最小数字（改造二分法）
            把一个数组最开始的若干个元素搬到末尾,称为数组的旋转
            输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
            例如{3，4，5，1，2}为{1，2，3，4，5}的旋转数组
            该数组的最小值为1

            有序：用二分法
            把数组用中间值分成2段，看两端那一段无序（左侧的大于右侧的），最小值在无序的那一段。
            结束时，只剩下两个数，右侧的一定是最小值。
     */
    static int f2(int[] arr) {
        int begin = 0;
        int end = arr.length - 1;
        int mid = (begin + end) / 2;
        while (begin + 1 < end) {
            if (arr[begin] > arr[mid]) {
                end = mid;
                mid = (begin + mid) / 2;
            } else {
                begin = mid;
                mid = (mid + end) / 2;
            }
        }
        return arr[end];
    }

    @Test
    public void testF2() {
        int[] arr = {5, 6, 7, 2, 3, 4};
        System.out.println(f2(arr));
    }

    /*
        3、求一个部分有序的数组中，最长的连续递增子序列的长度。
            例如（1，3，4，23，23，5，4，2，3，5，6，7，8）
                 其最长子序列为（2，3，5，6，7，8）
            思路：
                由于要求其最长子序列，及其长度。
                使用双指针对数组进行操作。
     */

    static void f3(int[] arr) {
        List<ArrayList> l = new ArrayList<ArrayList>();
        int first = 1, last = 0;
        while (first < arr.length) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (arr[first] < arr[first - 1]) {
                list.add(last);
                list.add(first);
                list.add(first - last);
                last = first + 1;
                first = last + 1;
            } else {
                first++;
            }

        }


    }

}
