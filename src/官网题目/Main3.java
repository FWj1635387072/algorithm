package 官网题目;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

public class Main3 {
    /* public static void f2() {
         Scanner scan = new Scanner(System.in);
         int a = scan.nextInt();
         int n = scan.nextInt();
         int sum = 0, temp = 0;
         for (int i = 0; i < n; i++) {
             temp = 0;
             for (int j = 0; j <= i; j++) {
                 temp = temp * 10 + a;
             }
             sum += temp;
         }
         System.out.println(sum);
     }

     public static void f1() {
         //使用标记数组。如果有则填1，否则为0.
         Scanner scan = new Scanner(System.in);
         int[] friends = new int[100000];
         int n,k,m;
         int friend;
         n = scan.nextInt();
         while(n-- > 0){
             k = scan.nextInt();
             while(k-- > 0){
                 friend = scan.nextInt();
                 friends[friend] = 1;
             }
         }

         //输出，输出过标记为2，不在输出。
         boolean flag = false;
         m = scan.nextInt();
         while(m-- > 0){
             friend = scan.nextInt();
             if(m != 1&&friends[friend] == 0){
                 System.out.print(friend + " ");
                 flag = true;
             }

             if(m == 1 && friends[friend] == 0){
                 System.out.print(friend);
                 flag = true;
             }
             friends[friend] = 2;
         }

         if(!flag){
             System.out.println("No one is handsome");
         }
 }




    static int n, m, k;
    static int[] rec;
    static double[] score;
    public static void f3() throws Exception {
        DecimalFormat df = new DecimalFormat("0.000");
        R.init(System.in);
        n = R.nextInt();
        k = R.nextInt();
        m = R.nextInt();
        rec = new int[k];
        score = new double[n];
        float sum;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                rec[j] = R.nextInt();
            }
            Arrays.sort(rec);
            sum = 0;
            for (int p = 1; p < k - 1; p++) {
                sum += rec[p];
            }
            score[i] = sum / (k - 2);
        }

        Arrays.sort(score);
        String s = "";
        for (int i = n - m; i < n; i++) {
            s += i == n - 1 ? df.format(score[i]) : df.format(score[i]) + " ";
        }
        System.out.println(s);
    }

    static class R {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        static String next() throws Exception {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        static Double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }
    }

     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ys, shang;
        String out;
        int num = scan.nextInt();
        shang = num;
        ys = 0;
        out = "";
        while (num >= 16 ) {
            ys = num % 16;
            switch (ys) {
                case 0:
                    out = 0 + out;
                    break;
                case 1:
                    out =1+out;
                    break;
                case 2:
                    out =2+out;
                    break;
                case 3:
                    out =3+out;
                    break;
                case 4:
                    out =4+out;
                    break;
                case 5:
                    out =5+out;
                    break;
                case 6:
                    out =6+out;
                    break;
                case 7:
                    out =7+out;
                    break;
                case 8:
                    out =8+out;
                    break;
                case 9:
                    out =9+out;
                    break;
                case 10:
                    out ="A"+out;
                    break;
                case 11:
                    out ="B"+out;
                    break;
                case 12:
                    out ="C"+out;
                    break;
                case 13:
                    out ="D"+out;
                    break;
                case 14:
                    out ="E"+out;
                    break;
                case 15:
                    out ="F"+out;
                    break;
                default:
                    break;
            }
            num = num / 16;
        }
        switch (num) {
            case 0:
                out = 0+out;
                break;
            case 1:
                out =1+out;
                break;
            case 2:
                out =2+out;
                break;
            case 3:
                out =3+out;
                break;
            case 4:
                out =4+out;
                break;
            case 5:
                out =5+out;
                break;
            case 6:
                out =6+out;
                break;
            case 7:
                out =7+out;
                break;
            case 8:
                out =8+out;
                break;
            case 9:
                out =9+out;
                break;
            case 10:
                out ="A"+out;
                break;
            case 11:
                out ="B"+out;
                break;
            case 12:
                out ="C"+out;
                break;
            case 13:
                out ="D"+out;
                break;
            case 14:
                out ="E"+out;
                break;
            case 15:
                out ="F"+out;
                break;
            default:
                break;
        }
        System.out.println(out);
        
    }
}


