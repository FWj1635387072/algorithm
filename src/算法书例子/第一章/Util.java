package 算法书例子.第一章;

import java.util.Random;

public class Util {
    /*
     *   返回运行时间
     * */
    public static void duration(long x) {
        System.out.println(System.currentTimeMillis() - x + "ms");
    }

    /*生成范围内的随机数组
     * */
    public static int[] getIntArr(int num, int min, int max) {
        int[] arr = new int[num];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt((max - min) + 1) + min;
        }
        return arr;
    }
    public static Integer[] getIntArr(Integer num, Integer min, Integer max) {
        Integer [] arr = new Integer[num];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt((max - min) + 1) + min;
        }
        return arr;
    }

    public static String printArr(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     *  return the max of array;
     * @param arr
     * @return
     */
    public static int maxOf(int[] arr){
        int temp = arr[0];
        for(int i : arr){
            if(temp < i){
                temp = i;
            }
        }
        return temp;
    }

    /**
     *
     *  return the min of array
     * @param arr
     * @return
     */
    public static int minOf(int[] arr){
        int temp = arr[0];
        for(int i : arr){
            if(temp > i){
                temp = i;
            }
        }
        return temp;
    }
    public static void printArr(int[][] arr){
        for(int i =0;i < arr.length;i++){
            for(int j = 0;j < arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
