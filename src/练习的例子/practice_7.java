package 练习的例子;

import com.oracle.webservices.internal.api.EnvelopeStyle;
import org.junit.Test;

public class practice_7 {
    //字符串匹配


    //RabinKarp
    //定义种子常量
    static final int seed = 31;

    /**
     * 使用100000个不同字符串产生的冲突数，大概在0——3波动，使用100百万不同的字符串，冲突数大概110+范围波动
     * 类似于进制转换，将目标字符串转换为特定数
     *
     * @param str
     * @return
     */
    static long hash(String str) {
        long hash = 0;
        for (int i = 0; i != str.length(); i++) {
            hash = seed * hash + str.charAt(i);
        }
        return hash % Long.MAX_VALUE;
    }

    static void match(String p, String s) {
        long hash_p = hash(p);
        int p_len = p.length();
        for (int i = 0; i + p_len <= s.length(); i++) {
            long hash_i = hash(s.substring(i, i + p_len));
            if (hash_i == hash_p)
                System.out.println("match:" + i);
        }
    }

    static long[] hash1(String s, int n) {
        long[] res = new long[s.length() - n + 1];
        res[0] = hash(s.substring(0, n));

        for (int i = n; i < s.length(); i++) {
            char newChar = s.charAt(i);
            char ochar = s.charAt(i - n);
            long v = (res[i - n] * seed + newChar - (long) Math.pow(seed, n) * ochar) % Long.MAX_VALUE;
            res[i - n + 1] = v;
        }
        return res;
    }


    static void match1(String p, String s) {
        long hash_p = hash1(p, p.length())[0];
        long[] hash_s = hash1(s, p.length());
        for (int i = 0; i < hash_s.length; i++) {
            if (hash_s[i] == hash_p) {
                System.out.println("match:" + i);
            }
        }
    }

    @Test
    public void test1() {
        match1("ABA", "ABABABAB");
    }


    //KMP思路

    /**
     * 1.暴力匹配
     * 2.next数组含义及应用
     * 3.求next数组
     */


    /**
     * 暴力法
     * @param s
     * @param p
     * @return
     */
    static int indexOf(String s, String p) {
        int i = 0;
        int p1 = i;
        int j = 0;
        while(i < s.length() - p.length()){
            if(s.charAt(p1) == p.charAt(j)){
                p1++;
                j++;
                if(j == p.length())
                    return i;
            }else{
                i++;
                j = 0;
                p1 = i;
            }
        }
        return -1;
    }

    @Test
    public void test2(){
        System.out.println(indexOf("abcdef","cde"));
    }

    /**
     * KMP
     * @param s
     * @param p
     * @return
     */
    static int indexOf1(String s, String p){
        if(s.length() == 0 || p.length() == 0) return -1;
        if(p.length() > s.length()) return -1;

        int[] next = next(p);
        int i =0;
        int j =0;
        int slen = s.length();
        int plen = p.length();

        while (i < slen){
            if(j == -1 || s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
            if(j == plen){
                return (i - j);
            }
        }
        return -1;
    }

    /**
     * 求next数组
     * @param ps
     * @return
     */
    static int[] next(String ps){
        int plen = ps.length();
        int[] next = new int[plen];
        char[] p = ps.toCharArray();
        next[0] = -1;
        if(ps.length() == 1){
            return next;
        }
        next[1] = 0;

        int j = 1;
        int k = next[j];    //看看位置j的最长匹配的前缀在哪儿

        while (j < plen - 1){
            //现在需要推出next[j+1],检查j和k位置上的关系即可。
            if(k < 0 || p[j] == p[k]){
                next[++j] = ++k;
            }else {
                k = next[k];
            }
        }
        return next;
    }
    @Test
    public void test3(){
        System.out.println(indexOf1("abcdef","cde"));
    }

}
