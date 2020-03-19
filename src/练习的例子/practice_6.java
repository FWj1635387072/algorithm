package 练习的例子;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        int len2 = b.length();
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
            temp = (int) b.charAt(i);
            // help[temp]--;
            if (--help[temp] < 0) return false;
        }
        return true;
    }

    @Test
    public void test3() {
        String a = "aaaa";
        String b = "asd";
        System.out.println(checkSame(a, b));
        System.out.println(checkSame1(a, b));
    }

    /**
     * 请编写一个方法，将字符串中的空格全部替换成“%20”.假定该字符串有足够的空间存放新增的字符
     * 并且知道字符串的真实长度（小于等于1000），同时保证字符串由大小写的英文字母组成。
     * 给定一个string，ininString为原始的串，以及串的长度 int len，返回替换后的String
     * 测试样例：
     * "Mr John Smith",13
     * 返回："Mr%20John%20Smith"
     */

    static String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }


    @Test
    public void test4() {
        System.out.println(replaceSpace("12 3"));
    }

    /**
     * 字符串压缩
     * 字符串aabbbccccaaa压缩为a2b3c4a3
     * 如果压缩后的字符串没有变短，返回原先的字符串
     */
    static String zipString(String initString) {
        int count = 0;
        char lastC = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < initString.length(); i++) {
            char charAt = initString.charAt(i);
            if (sb.length() == 0) {
                lastC = initString.charAt(i);
                sb.append(lastC);
                count++;
            } else {
                if (lastC == charAt) {
                    count++;
                } else {
                    sb.append(count).append(charAt);
                    count = 1;
                }
            }
            lastC = charAt;
        }
        if (count >= 1) {
            sb.append(count);
        }
        if (sb.length() >= initString.length()) {
            return initString;
        }
        return sb.toString();
    }

    @Test
    public void test5() {
        System.out.println(zipString("aabbbccccaaa"));
    }

    /**
     * 两串的字符集是否相同，如果使用Ascii码，可用标记数组
     * 否则，使用hashMap
     */
    static boolean check(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.get(s1.charAt(i)) == null)
                map.put(s1.charAt(i), 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (map.get(s2.charAt(i)) == null) return false;
        }
        return true;
    }

    @Test
    public void test6() {
        System.out.println(check("adv", "addddvasw"));
    }

    /**
     * 旋转词包含问题
     * abca 的旋转词有   bcaa 、 caab 、 aabc
     * 判断字符串b是否为字符串a的旋转词
     */
    static boolean isRotate(String a, String b) {
        if (a.length() != b.length()) return false;
        StringBuilder sb = new StringBuilder().append(a).append(a);
        return sb.toString().contains(b);
    }

    @Test
    public void test7() {
        System.out.println(isRotate("abca", "baa"));
    }

    /**
     * 翻转一个字符串
     * here you are   ->  are you  here
     * <p>
     * 反转全部，然后翻转单个单词
     */

    static String reverseSen(String s) {
        String s1 = reverse(s);
        String[] str = s1.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(reverse(str[i]) + " ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    @Test
    public void test8() {
        System.out.println(reverseSen("here you are"));
    }

    /**
     * 去掉字符串中连续出现的k次的0
     * 一、正则表达式
     * 二、用扫描数组的解法
     */
    static String remove(String initString, int k) {
        String regexp = "0{" + k + "}";
        return initString.replaceAll(regexp, "");
    }
    @Test
    public void test9(){
        System.out.println(remove("1230000000111",7));
    }


}
