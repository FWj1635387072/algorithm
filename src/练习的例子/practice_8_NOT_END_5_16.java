package 练习的例子;

import java.util.Arrays;

/**
 * 字符串匹配之后缀数组
 * 1、什么是后缀数组
 *      串的所有后缀按字典序的排序后，，在数组中记录后缀的起始下标
 *      排名和原下标的映射
 *
 *
 *      rank 数组
 *          给定后缀下标，返回字典序
 * 2、后缀数组有什么用？
 *      匹配
 * 3、怎么求后缀数组
 *
 */
public class practice_8_NOT_END_5_16 {




    private static void match(){
        String s = "ABABABABB";
        String p = "BABB";
    }


    public static Suff[] getSa(String src){
        int strLen = src.length();
        Suff [] suffixArray = new Suff[strLen];
        for(int i = 0;i < strLen;i++){
            String suff1 = src.substring(i);
            suffixArray[i] = new Suff(suff1,i);
        }
        Arrays.sort(suffixArray);
        return suffixArray;
    }

    static class Suff implements Comparable<Suff>{
        private String s;
        private int i;
        public Suff(String s,int i){
            this.s = s;
            this.i = i;
        }

        @Override
        public String toString() {
            return "Suff{"+
                    "str="+s+
                    ",index="+i+"}";
        }

        @Override
        public int compareTo(Suff o) {
            return this.s.compareTo(o.s);
        }
    }


}
