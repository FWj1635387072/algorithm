import org.junit.Test;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] hex = new String[n];
        for (int i = 0; i < hex.length; i++) {
            hex[i] = scan.next();
        }
        for(int i = 0;i< hex.length;i++){
            String res = HexConvert(hex[i]);
            System.out.println(res);
        }
    }

    static String HexConvert(String hex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hex.length(); i++) {
            switch (hex.charAt(i)) {
                case '0':
                    sb.append("0000");
                    break;
                case '1':
                    sb.append("0001");
                    break;
                case '2':
                    sb.append("0010");
                    break;
                case '3':
                    sb.append("0011");
                    break;
                case '4':
                    sb.append("0100");
                    break;
                case '5':
                    sb.append("0101");
                    break;
                case '6':
                    sb.append("0110");
                    break;
                case '7':
                    sb.append("0111");
                    break;
                case '8':
                    sb.append("1000");
                    break;
                case '9':
                    sb.append("1001");
                    break;
                case 'a':
                    sb.append("1010");
                    break;
                case 'b':
                    sb.append("1011");
                    break;
                case 'c':
                    sb.append("1100");
                    break;
                case 'd':
                    sb.append("1101");
                    break;
                case 'e':
                    sb.append("1110");
                    break;
                case 'f':
                    sb.append("1111");
                    break;
                default:
                    break;
            }
        }
        String temp = sb.toString();
        sb = new StringBuilder();
        if (temp.length() % 3 == 1) {
            temp = "00" + temp;
        } else if (temp.length() % 3 == 2) {
            temp = "0" + temp;
        }
        int i = 0;
        String Ox;
        while (i < temp.length() - 2) {
            Ox = temp.substring(i, i + 3);
            switch (Ox) {
                case "000":
                    sb.append("0");
                    break;
                case "001":
                    sb.append("1");
                    break;
                case "010":
                    sb.append("2");
                    break;
                case "011":
                    sb.append("3");
                    break;
                case "100":
                    sb.append("4");
                    break;
                case "101":
                    sb.append("5");
                    break;
                case "110":
                    sb.append("6");
                    break;
                case "111":
                    sb.append("7");
                    break;
                default:
                    break;
            }
            i += 3;
        }
        Ox = sb.toString();
        for (i = 0; i < Ox.length() && Ox.charAt(i) == '0'; i++) {
            Ox = Ox.substring(i + 1, Ox.length());
        }
        return Ox;
    }

    @Test
    public void test1() {
        String a = "12345678";
        System.out.println(a.substring(2, 4));
    }
}
