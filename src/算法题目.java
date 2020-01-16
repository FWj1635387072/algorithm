import org.junit.Test;

public class 算法题目 {
    /*
     *   1、调整数组的位置。
     *      输入一个整数数组，使奇数位于偶数前。
     * */

    static void transArr(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i];
        }

        int left = 0;
        int right = arr.length - 1;
        int current = left;
        while (left <= right) {
            if(temp[left] % 2 == 0){
                arr[left] = temp[left];
                right--;
            }else {
                left++;
            }
        }
    }

    @Test
    public void test1(){
        int[] arr = Util.getIntArr(15,1,20);
        System.out.println(Util.printArr(arr));
        transArr(arr);
        System.out.println(Util.printArr(arr));
    }
    
    
    static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
