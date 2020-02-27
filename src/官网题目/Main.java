package 官网题目;/*import java.util.Scanner;

public class 官网题目.Main {
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
}*/
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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

import java.util.Scanner;

public class Main {
    static int n, m, k;
    static int[] rec;
    static double[] score;
    public static void main(String[] args) throws Exception{
        DecimalFormat df = new DecimalFormat("0.000");
        R.init(System.in);
        n = R.nextInt();
        k = R.nextInt();
        m = R.nextInt();
        rec = new int[k];
        score = new double[n];
        float sum;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < k;j++){
                rec[j] = R.nextInt();
            }
            Arrays.sort(rec);
            sum = 0;
            for(int p = 1;p < k - 1;p++){
                sum += rec[p];
            }
            score[i] = sum / (k - 2);
        }

        Arrays.sort(score);
        String s = "";
        for(int i = n - m;i < n;i++){
            s += i == n - 1 ?df.format(score[i]) :df.format(score[i]) + " " ;
        }
        System.out.println(s);
    }
    static class R {
        static BufferedReader reader;
        static StringTokenizer tokenizer;
        static void init(InputStream input){
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        static String next() throws Exception{
            while(!tokenizer.hasMoreTokens()){
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }
        static int nextInt() throws  Exception{
            return Integer.parseInt(next());
        }

        static Double nextDouble() throws  Exception{
            return Double.parseDouble(next());
        }
    }
}


