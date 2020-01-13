import org.junit.Test;

import java.util.Arrays;

public class 排序 {
    public static void main(String[] args) {
        //时间复杂度
        //冒泡O（n^2）
        //Array.sort() (nlgn)

        int[] arr1 = Util.getIntArr(100000, 0, 10000);
        long now = System.currentTimeMillis();
        Arrays.sort(arr1);
        System.out.print("Arrays.sort()：");
        Util.duration(now);
        /*for (int i : arr1) {
            System.out.println(i);
        }*/
        System.out.println("------------------");
        arr1 = Util.getIntArr(100000, 0, 10000);
        now = System.currentTimeMillis();
        sortMaoPao(arr1);
        System.out.print("冒泡：");
        Util.duration(now);
        /*for (int i : arr1) {
            System.out.println(i);
        }*/
    }

    //冒泡排序
    static void sortMaoPao(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //选择排序
    static void sortSelect(int[] arr) {
        int minIndex, temp;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    //插入排序
    static void sortInsert(int[] arr) {
        int j, temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

    //希尔排序
    static void sortShell(int[] arr) {
        int temp, k;
        //第一个循环控制次数/增量, i为增量
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //第二个循环控制对每个组进行插入排序，控制下标
            for (int j = i; j < arr.length; j++) {
                //第三个循环控制，每个组中的插入排序
                temp = arr[j];
                for (k = j - i; k >= 0 && temp < arr[k]; k -= i) {
                    arr[k + i] = arr[k];
                }
                arr[k + i] = temp;
            }
        }
    }


    //二分排序
    static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;
        int mid = low + ((high - low) >> 1); //防止溢出，移位也更高效
        int midVal = arr[mid];
        if (midVal < key)
            return binarySearch(arr, mid + 1, high, key);
        else if (midVal > key)
            return binarySearch(arr, low, high - 1, key);
        else
            return mid;
    }

    //快排
    public static void sortQuick(int[] arr, int left, int right) {
        if (left < right) {
            int q = partition(arr, left, right);
            sortQuick(arr, left, q - 1);
            sortQuick(arr, q + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int Pmain = arr[left];
        int pleft = left + 1;
        int pright = right;

        while (pleft <= pright) {
            if (arr[pleft] <= Pmain) {
                pleft++;
            } else {
                swap(arr, pleft, pright);
                pright--;
            }
        }
        swap(arr, left, pright);
        return pright;
    }

    //双向扫描法
    public static int partition2(int[] arr, int left, int right) {
        int pleft = left + 1;
        int pright = right;
        int pmain = arr[left];
        while (pleft <= pright) {
            while (pleft <= pright && arr[pleft] <= pmain)
                pleft++;
            while (pleft <= pright && arr[pright] > pmain)
                pright--;
            if (pleft < pright)
                swap(arr, pleft, pright);
        }
        swap(arr, left, pright);
        return pright;
    }


    public static int partition3(int[] arr, int left, int right) {
        int pright = right, pleft = left + 1;
        int indexMid = (left + right) >> 2;
        if ((arr[indexMid] > arr[left] && arr[left] > arr[right]) ||
                (arr[indexMid] < arr[left] && arr[left] < arr[right])) {
            indexMid = left;
        } else if ((arr[indexMid] > arr[right] && arr[right] > arr[left])
                || (arr[indexMid] < arr[right] && arr[right] < arr[left])) {
            indexMid = right;
        } else {
            indexMid = indexMid;
        }

        swap(arr,left,indexMid);
        int pmain = arr[left];
        while (pleft <= pright) {
            while (pleft <= pright && arr[pleft] <= pmain)
                pleft++;
            while (pleft <= pright && arr[pright] > pmain)
                pright--;
            if (pleft < pright)
                swap(arr, pright, pleft);
        }
        swap(arr, pright, left);
        return pright;
    }


    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //归并排序


    @Test
    public void test1() {
        int[] arr = Util.getIntArr(20, 0, 100);
        System.out.println(Util.printArr(arr));
        sortQuick(arr, 0, arr.length - 1);
        System.out.println(Util.printArr(arr));
    }

}
