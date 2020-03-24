package 练习的例子;

import org.junit.Test;

//对前几天内容的巩固
public class practice_9_1 {
    final static int seed = 31;

    static long hash(String s) {
        long hash = 0;
        int slen = s.length();
        for (int i = 0; i != slen; i++) {
            hash = seed * hash + s.charAt(i);
        }
        return hash % Long.MAX_VALUE;
    }

    static int match(String a, String b) {
        long a_hash = hash(a);
        for (int i = 0; i <= b.length() - a.length(); i++) {
            long b_hash = hash(b.substring(i, i + a.length()));
            if (a_hash == b_hash) {
                return i;
            }
        }
        return -1;
    }

    static long[] hash1(String a, int n) {
        long[] hash = new long[a.length() - n + 1];
        hash[0] = hash(a.substring(0, n));
        for (int i = 1; i < hash.length; i++) {
            char oChar = a.charAt(i - 1);
            char newChar = a.charAt(i + n - 1);
            hash[i] = (hash[i - 1] * seed + newChar - (long) Math.pow(seed, n) * oChar) % Long.MAX_VALUE;
        }
        return hash;
    }

    static void match1(String a, String b) {
        long a_hash = hash1(a, a.length())[0];
        long[] b_hash = hash1(b, a.length());
        for (int i = 0; i < b_hash.length; i++) {
            if (a_hash == b_hash[i]) {
                System.out.println("match:" + i);
            }
        }
    }

    @Test
    public void test1() {
        match1("ABA", "ABABABABABAAA");
    }

    static int indexOf(String a, String b) {
        int i = 0;
        int p1 = i;
        int j = 0;
        int len = b.length();
        while (i < b.length() - a.length()) {
            if (a.charAt(j) == b.charAt(p1)) {
                p1++;
                j++;
                if (j == a.length()) {
                    return i;
                }
            } else {
                i++;
                j = 0;
                p1 = i;
            }
        }
        return -1;
    }

    @Test
    public void test2() {
        System.out.println(indexOf("bbc", "aaabbcd"));

    }

    static int[] next(String a) {
        int len = a.length();
        int[] next = new int[len];
        next[0] = -1;
        if (len == 1)
            return next;
        next[1] = 0;

        int j = 0;
        int k = next[j];
        while (j < len - 1) {
            if (k < 0 || next[k] == next[j]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    static int indexOf1(String a, String b) {
        if (a.length() == 0 || b.length() == 0) return -1;
        if (a.length() > b.length()) return -1;

        int[] next = next(a);
        int i = 0, j = 0, alen = a.length(), blen = b.length();
        while(i < blen){
            if(j == -1 || a.charAt(j) == b.charAt(i)){
                i++;
                j++;
            }else{
                j = next[j];
            }
            if(j == alen){
                return (i - j);
            }
        }
        return -1;
    }

    @Test
    public void test3() {
        System.out.println(indexOf1("z", "ababababaaaaz"));
    }

}


