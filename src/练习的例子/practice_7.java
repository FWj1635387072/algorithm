package 练习的例子;

import org.junit.Test;

public class practice_7 {
    //字符串匹配


    //RabinKarp
    //定义种子常量
    static final int seed = 31;

    /**
     * 使用100000个不同字符串产生的冲突数，大概在0——3波动，使用100百万不同的字符串，冲突数大概110+范围波动
     *  类似于进制转换，将目标字符串转换为特定数
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
        long hash_p = hash1(p,p.length())[0];
        long[] hash_s = hash1(s,p.length());
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




}
