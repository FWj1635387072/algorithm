package 练习的例子;

import org.junit.Test;
import 算法书例子.第一章.Util;

public class practice_2 {
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    //奇数在前，偶数在后
    static int[] sortOdd1(int[] arr) {
        int n = arr.length;
        int[] arr1 = new int[n];
        int pleft = 0, pright = n - 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                arr1[pleft] = arr[i];
                pleft++;
            } else {
                arr1[pright] = arr[i];
                pright--;
            }
        }
        return arr1;
    }

    static int[] sortOdd2(int[] arr) {
        int n = arr.length;
        int pleft = 0, pright = n - 1;
        while (pleft < pright) {
            while (pleft < pright && arr[pleft] % 2 == 1) {
                pleft++;
            }
            while (pleft < pright && arr[pright] % 2 == 0) {
                pright--;
            }
            swap(arr, pright, pleft);
        }
        return arr;
    }


    @Test
    public void test1() {
        int[] arr = Util.getIntArr(10, 2, 20);
        System.out.println(Util.printArr(arr));
        System.out.println(Util.printArr(sortOdd2(arr)));
    }


    //找出第k小的元素

    static int selectK(int[] A, int p, int q, int k) {
        q = partition(A, p, q);
        int qK = q - p + 1; //主元的下标
        if (qK == k) return A[q]; //主元是第几个元素
        else if (qK > k) return selectK(A, p, q - 1, k);
        else return selectK(A, q + 1, q, k - qK);
    }


    static int partition(int[] A, int p, int q) {
        int pMain = A[p];
        int pleft = p + 1 , pright = q;

        while (pleft <= pright){
            while(pleft <= pright && A[pleft] <= pMain){
                pleft++;
            }
            while(pleft <= pright && A[pright] > pMain){
                pright--;
            }
            if(pleft < pright){
                swap(A,pleft,pright);
            }
        }
        swap(A,p,pright);
        return pright;
    }
    
    @Test
    public void test(){
        int[] arr = {111,1,41,121,321,112,12};
        int res = selectK(arr,0,arr.length -1,2);
        System.out.println(Util.printArr(arr));
        System.out.println(res);
                
    }
    

    //超过一半的数字
    static int getNum(int[] A){
        int candidate,ntimes;
        candidate = A[0];
        ntimes = 0;
        for(int i = 0; i < A.length;i++){
            if(ntimes == 0){
                candidate = A[i];
                ntimes = 1;
                continue;
            }
            if(A[i] == candidate){
                ntimes++;
            }else{
                ntimes--;
            }
        }
        return candidate;
    }

    @Test
    public void test11(){
        int[] arr = {123,412,32,2,1,23,21,12,2,2,211,2,21,21,21,2,2};
        System.out.println(getNum(arr));
    }

}
