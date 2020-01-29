package 算法书例子.第一章;

import javafx.scene.shape.Circle;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Date;

public class _1 {

    //使用Object做泛型
    static class MemoryCell {
        public Object Read() {
            return storeValue;
        }

        public void write(Object x) {
            storeValue = x;
        }

        private Object storeValue;
    }

    static class TestMemoryCell {
        public static void main(String[] args) {
            MemoryCell m = new MemoryCell();
            m.write("333");
            String val = (String) m.Read();
            System.out.println("Contents are: " + val);
        }
    }


    static class WrapperDemo {
        public static void main(String[] args) {
            MemoryCell m = new MemoryCell();
            m.write(new Integer(12));
            Integer wrapperVal = (Integer) m.Read();
            int val = wrapperVal.intValue();
            System.out.println("Contents are: " + val);
        }
    }

    //使用接口类型表示泛型
    static class FinMaxDemo {
        public static Comparable findMax(Comparable[] arr) {
            int maxIndex = 0;
            for (int i = 0; i < arr.length; i++)
                if (arr[i].compareTo(arr[maxIndex]) > 0)
                    maxIndex = i;
            return arr[maxIndex];
        }

        public static void main(String[] args) {
            String[] str = {"aaa", "abc", "ede"};
            Integer[] arr = Util.getIntArr(new Integer(10), new Integer(20), new Integer(50));
            System.out.println(findMax(str));
            System.out.println(findMax(arr));
        }
    }

    //练习题
    //
    static int[] arr;

    static int partition(int[] arr, int left, int right) {

        int a = 0, j;
        for (int i = 1; i < arr.length; i++) {
            a = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > a; j--)
                arr[j + 1] = arr[j];
            arr[j + 1] = a;
        }
        return arr[arr.length / 2];
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //返回的二进制表示中1的个数
    //如果n是奇数，那么其1的个数等于n/2的二进制表示1的个数加1

    static int getOneNum(int num) {
        if (num == 1)
            return 1;
        else if (num % 2 == 0)
            return 0 + getOneNum(num / 2);
        else
            return 1 + getOneNum(num / 2);
    }


    @Test
    public void test1() {
        //arr = Util.getIntArr(10000000, 2, 1000000000);
        //long l = System.currentTimeMillis();
        //int a = partition(arr,0,arr.length);
        //System.out.println(Util.printArr(arr));
        //System.out.println(a);
        //Arrays.sort(arr);
        //Util.duration(l);
        System.out.println(getOneNum(7));
    }



}
