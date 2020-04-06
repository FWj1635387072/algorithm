package 算法书例子.第三章;

import org.junit.Test;

import java.math.BigInteger;
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
    
    
    @Test
    public void test1(){
        BigInteger a = new BigInteger("101");
        BigInteger b = new BigInteger("200");
        System.out.println(a.isProbablePrime(1));
    }
}
