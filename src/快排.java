import org.junit.Test;
import 算法书例子.第一章.Util;

public class 快排 {
    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int q = partition1(arr,left,right);
            quickSort(arr, left, q - 1);
            quickSort(arr, q + 1, right);
        }
    }

    static int partition(int[] arr,int left,int right) {
        int pmain = arr[left];
        int pleft = left + 1;
        int pright = right;

        while(pleft <= pright){
            if(arr[pleft] > pmain){
                swap(arr,pleft,pright);
                pright--;
            }
            else{
                pleft++;
            }
        }
        swap(arr,left,pright);
        return pright;
    }

    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    static int partition1(int[] arr, int left,int right){
        int pmain = arr[left];
        int pleft = left + 1;
        int pright = right;

        while(pleft <= pright){
            while(pleft <= pright && arr[pleft] <=  pmain ){
                pleft++;
            }
            while(pleft <= pright && arr[pright] > pmain){
                pright--;
            }
            if(pleft < pright)
                swap(arr,pleft,pright);
        }
        swap(arr,left,pright);
        return pright;
    }


    static int partition3(int[] arr,int left,int right){
        int[] temp = {arr[left],arr[right],arr[(left+right)/2]};
        return 0;



    }



    @Test
    public void test1(){
        int[] arr = Util.getIntArr(30,1,50);
        System.out.println(Util.printArr(arr));
        quickSort(arr,0,arr.length - 1);
        System.out.println(Util.printArr(arr));
    }

}
