import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S7_14 {
    static int n,k,m;
    static int[] rec;
    static double[] score;
    public static void main(String[] args) throws IOException {
        DecimalFormat df = new DecimalFormat("0.000");
        R1.init(System.in); //输入挂
        n = R1.nextInt();
        k = R1.nextInt();
        m = R1.nextInt();
        rec = new int[k];
        score = new double[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < k; i++) {
                rec[i] = R1.nextInt();
            }
            Arrays.sort(rec);
            int sum = 0;
            for (int i = 1; i < k - 1; i++) {
                sum += rec[i];
            }
            score[j] = sum * 1.0 / (k - 2);
        }
        Arrays.sort(score);
        for (int i = n - m; i < n; i++) {
            if (i != n - 1)System.out.print(df.format(score[i]) + " ");
            else System.out.print(df.format(score[i]));
        }
    }
}
class R1 {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
