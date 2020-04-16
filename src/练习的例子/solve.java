package 练习的例子;

import java.util.Scanner;

public class solve {
    static double a, b, J, lambda, mu, temp;
    static int k;
    static int[] x = {180, 454, 150, 440};
    static int[] y = {341, 354, 140, 117};
    static final int L = 500, l = 20;

    //求lambda
    static double f1(double a, double b) {
        return a + 0.382 * (b - a);
    }
    //求mu
    static double f2(double a, double b) {
        return a + 0.618 * (b - a);
    }

    static void step2(double a, double b) {
        int count = 0;
        if (b - a < J) {
            temp = (a + b) / 2; //令α为a、b均值
            //依次验证3-22表达式
            double[] a1 = new double[4];
            for (int i = 0; i < 4; i++) {
                a1[i] = Math.sqrt((Math.abs(x[i] - temp)) * Math.abs(x[i] - temp) + y[i] * y[i]);
            }
            count = 0;
            for (int i = 0; i < 4; i++) {
                if (temp >= l && a1[i] <= L) {
                    count++;
                }
                if (count == 4) {
                    System.out.println(temp);
                    System.exit(0);
                }
            }
        } else if (b - a >= J) {
            if (f1(a, b) > f2(a, b)) {
                step3();
                step5();
            } else {
                step4();
                step5();
            }
        }
    }

    static void step3() {
        a = lambda;
        b = b;
        mu = f2(a, b);
    }

    static void step4() {
        a = a;
        b = mu;
        lambda = f1(a, b);
    }

    static void step5() {
        k += 1;
        step2(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextDouble();
        b = sc.nextDouble();
        J = sc.nextDouble();
        lambda = f1(a, b);
        mu = f2(a, b);
        k = 1;
        step2(a, b);
        System.out.println(temp);
    }
}
