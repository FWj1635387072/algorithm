package 算法书例子.第三章;

import com.sun.xml.internal.fastinfoset.util.FixedEntryStringIntMap;

import java.util.Scanner;

public class Goldbach1 {
    static void fenge(long num) {
        long m, n;
        for (m = 2; m <= num / 2; m++) {
            n = num - m;
            if (isPrime(m) && isPrime(n)) {
                System.out.println(num + "=" + m + "+" + n);
                break;
            }
        }
    }

    static boolean isPrime(long sum) {
        for (long i = 2; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        long l = System.currentTimeMillis();
        fenge(n);
        System.out.println(System.currentTimeMillis() - l);
    }
}
