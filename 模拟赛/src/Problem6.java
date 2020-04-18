import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] ch = s.toCharArray();
        for(int i = 0;i < s.length();i++){
            ch[i] += 3;
            switch ((int)ch[i]){
                case 123:
                    ch[i] = 'a';
                    break;
                case 124:
                    ch[i] = 'b';
                    break;
                case 125:
                    ch[i] = 'c';
                    break;
            }
        }
        System.out.println(new String(ch));
    }

}
