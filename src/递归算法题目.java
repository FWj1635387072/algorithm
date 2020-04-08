import org.junit.Test;

import java.util.Scanner;

public class 递归算法题目 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, res;
        while (true) {
            n = scanner.nextInt();
            res = f(n);
            System.out.println(res);
        }
    }

    /*  上楼梯
     *  共有n阶楼梯，一次可以上1阶，2阶，3阶。
     *  问：有多少中可以走完楼梯的方法
     * */
    private static int f(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return f(n - 1) + f(n - 2) + f(n - 3);
    }

    /*  改造二分法
     *  把一个数组最开始的若干个元素搬到末尾,称为数组的旋转
     *  输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
     *  例如{3，4，5，1，2}为{1，2，3，4，5}的旋转数组
     *  该数组的最小值为1
     *
     *  有序：用二分法
     * */


    /*
     *  有序数组内查找元素
     *
     *
     * */
    static int indexOf(String[] str, String p) {
        int begin = 0;
        int end = str.length - 1;
        int mid;
        while (begin <= end) {
            mid = begin + (end - begin) >> 2;
            while (str[mid].equals("")) {
                mid++;
                if (mid >= end)
                    return -1;
            }
            if (str[mid].compareTo(p) > 0)
                end = mid - 1;
            else if (str[mid].compareTo(p) < 0)
                begin = mid + 1;
            else
                return mid;
        }
        return -1;
    }


    //最长的递增子序列
    static int len(int[] arr) {
        int first = 0, last = 0;
        int len = 0;
        while (first < arr.length - 1) {
            if (arr[first] > arr[first + 1]) {
                if (first - last + 1 > len ) {
                    len = first - last + 1;
                }
                last = first + 1;
                first = first + 1;
                continue;
            }
            first++;
        }
        if(arr[first] > arr[first - 1]){
            if (first - last + 1 > len ) {
                len = first - last + 1;
            }
        }
        return len;
    }

    @Test
    public void Test1(){
        int[] arr = {1,2,3,2,6,1};
        System.out.println(len(arr));
    }


    //快排
    public static void sortQuick(int[] arr,int left,int right){




    }

    public static void sort(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int k = arr[low];
        while (l < h) {
            // 从后往前比较
            while (l < h && arr[h] >= k) { // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                h--;// h=6
            }
            if (l < h) {
                //拿到右边比标准值小的元素
                int temp = arr[h];
                //填充元素位置为标准值
                arr[h] = arr[l];
                //标准值位置为右边小的元素
                arr[l] = temp;
                //进行过一次替换后，没必要将替换后的两值再次比较，所以i++直接下一位与k对比
                l++;
            }
            // 从前往后比较
            while (l < h && arr[l] <= k) { // 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                l++;
            }
            if (l < h) {
                //拿到左边比标准值大的元素
                int temp = arr[h];
                //填充元素位置为标准值
                arr[h] = arr[l];
                //标准值位置为左边大的元素
                arr[l] = temp;
                h--;
            }
            // 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        // 递归
        //l=h为标准值的位置
        if (l > low)//先判断l>low再次经行左边排序
            sort(arr, low, l - 1);// 左边序列。第一个索引位置到关键值索引-1
        if (h < high)//左边依次排序执行完递归后，弹栈进行右边排序
            sort(arr, l + 1, high);// 右边序列。从关键值索引+1到最后一个
    }










}
