package 练习的例子;

import com.sun.xml.internal.ws.util.StringUtils;
import org.junit.Test;

import java.util.Arrays;

public class practice_6 {

    /**
     * 判断字符串有无重复字符
     * <p>
     * 思路：使用标记数组
     */
    static boolean isRepeat(String s) {
        if ("".equals(s)) {
            return false;
        }
        int[] flag = new int[128];
        int len = s.length();
        int temp;
        for (int i = 0; i < len; i++) {
            temp = (int) s.charAt(i);
            flag[temp]++;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] > 1) return true;
        }
        return false;
    }

    @Test
    public void test1() {
        String s = "dfghjkldfghjklcvbnm,ijkm";
        System.out.println(isRepeat(s));
        String s1 = "123asdfg";
        System.out.println(isRepeat(s1));
    }


    /**
     * 反转字符串
     */
    static String reverse(String s) {
        int len = s.length();
        char[] ch = new char[len];
        for (int i = 0; i < len; i++) {
            ch[i] = s.charAt(len - i - 1);
        }
        return new String(ch);
    }

    static String reverse1(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    @Test
    public void test2() {
        String s = "asdf";
        System.out.println(reverse(s));
        System.out.println(reverse1(s));
    }

    /**
     * 给定一个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串
     * 这里规定大小写为不同字符，且考虑字符串的空格
     * 给定一个string stringA 和一个string StringB，请返回一个bool，代表两串是否重新排列后可相同
     * 保证两串的长度都小于等于5000
     */
    static boolean checkSame(String a, String b) {
        int len1 = a.length();
        int len2 = a.length();
        char[] ch1 = new char[len1];
        char[] ch2 = new char[len2];
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    static boolean checkSame1(String a, String b) {
        int[] help = new int[128];
        int len = a.length();
        int temp;
        for (int i = 0; i < len; i++) {
            temp = (int) a.charAt(i);
            help[temp]++;
        }
        len = b.length();
        for (int i = 0; i < len; i++) {
            temp = (int) a.charAt(i);
            if(--help[temp] < 0)return false;
        }
        return true;
    }
    
    @Test
    public void test3(){
        String a = "asd";
        String b = "asd";
        System.out.println(checkSame(a,b));
        System.out.println(checkSame1(a,b));
    }

}
