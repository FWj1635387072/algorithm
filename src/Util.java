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

    public static String printArr(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
        sb.append("]");
        return sb.toString();
    }


}
