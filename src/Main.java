import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        int temp, j;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
/*  *//*余数*//*
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] f;
        int n = scan.nextInt();
        f = new int[n + 2];
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % 10007;
        }
        System.out.println(f[n]);
    }*/

//给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200