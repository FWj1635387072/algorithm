package 官网题目;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        str = new StringBuilder(str).reverse().toString();
        char[] ch = str.toCharArray();
        long sum = 0;
        for (int i = 0; i < ch.length; i++) {
            switch (ch[i]) {
                case '0':
                    sum += 0 * Math.pow(16, i);
                    break;
                case '1':
                    sum += 1 * Math.pow(16, i);
                    break;
                case '2':
                    sum += 2 * Math.pow(16, i);
                    break;
                case '3':
                    sum += 3 * Math.pow(16, i);
                    break;
                case '4':
                    sum += 4 * Math.pow(16, i);
                    break;
                case '5':
                    sum += 5 * Math.pow(16, i);
                    break;
                case '6':
                    sum += 6 * Math.pow(16, i);
                    break;
                case '7':
                    sum += 7 * Math.pow(16, i);
                    break;
                case '8':
                    sum += 8 * Math.pow(16, i);
                    break;
                case '9':
                    sum += 9 * Math.pow(16, i);
                    break;
                case 'A':
                    sum += 10 * Math.pow(16, i);
                    break;
                case 'B':
                    sum += 11 * Math.pow(16, i);
                    break;
                case 'C':
                    sum += 12 * Math.pow(16, i);
                    break;
                case 'D':
                    sum += 13 * Math.pow(16, i);
                    break;
                case 'E':
                    sum += 14 * Math.pow(16, i);
                    break;
                case 'F':
                    sum += 15 * Math.pow(16, i);
                    break;
                default:
                    break;
            }
        }
        System.out.println(sum);
    }
}
