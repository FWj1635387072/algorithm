package 练习的例子;

import org.junit.Test;

import java.util.Arrays;

/**
 * 字符串匹配之后缀数组
 * 1、什么是后缀数组
 * 串的所有后缀按字典序的排序后，，在数组中记录后缀的起始下标
 * 排名和原下标的映射
 * <p>
 * <p>
 * rank 数组
 * 给定后缀下标，返回字典序
 * 2、后缀数组有什么用？
 * 匹配
 * 3、怎么求后缀数组
 */
public class practice_8_NOT_END_5_16 {

    @Test
    public void match() {
        String s = "ABABABABB";
        String p = "BABB";
        Suff[] sa = getSa2(s); // 后缀数组
        int l = 0;
        int r = s.length() - 1;
        //二分查找
        while (r >= 1) {
            int mid = l + ((r - 1) >> 1);
            //居中的后缀
            Suff midSuff = sa[mid];
            String suffStr = midSuff.s;
            int comparRes;
            //将后缀和模式串比较，O(n)
            if (suffStr.length() >= p.length()) {
                comparRes = suffStr.substring(0, p.length()).compareTo(p);
            } else {
                comparRes = suffStr.compareTo(p);
            }

            //相等了，输出后缀的起始位置
            if (comparRes == 0) {
                System.out.println(midSuff.index);
                break;
            } else if (comparRes < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }


    /**
     * 直接对所有后缀排序，因为字符串的比较消耗O(n)，
     * 所有整体为 n²log(n)
     *
     * @param src
     * @return
     */
    public static Suff[] getSa(String src) {
        int strLen = src.length();
        //sa是排名到下标的映射，即sa[i] = k说明排名为i的后缀是从k开始的。
        Suff[] suffixArray = new Suff[strLen];
        for (int i = 0; i < strLen; i++) {
            String suff1 = src.substring(i);//截取后缀
            suffixArray[i] = new Suff(suff1, i);
        }
        Arrays.sort(suffixArray);
        return suffixArray;
    }

    static class Suff implements Comparable<Suff> {
        private String s;   //后缀内容
        private int index;  //后缀的起始下标

        public Suff(String s, int i) {
            this.s = s;
            this.index = i;
        }

        @Override
        public String toString() {
            return "Suff{" +
                    "str=" + s +
                    ",index=" + index + "}";
        }

        @Override
        public int compareTo(Suff o) {
            return this.s.compareTo(o.s);
        }
    }


    /**
     * 倍增法
     */
    public static Suff[] getSa2(String src) {
        int strLenth = src.length();
        //rk是下标到排名的映射
        int[] rk = new int[strLenth];
        Suff[] suffixArray = new Suff[strLenth];
        for (int k = 1; k <= strLenth; k *= 2) {    //K代表一个取值范围，一开始只截一个字符，即每个字符参与排序，下次两个字符参与排序
            for (int i = 0; i < strLenth; i++) {//增量，注意，此处可能越界
                String suffI = src.substring(i, i + k > strLenth ? strLenth : i + k);
                suffixArray[i] = new Suff(suffI, i);
            }
            if (k == 1) { //一个字符,直接排序
                Arrays.sort(suffixArray);
            } else {
                //填充完毕
                final int kk = k;
                Arrays.sort(suffixArray, (o1, o2) -> {
                    //不是基于字符串比较，而是之前的rank。
                    int i = o1.index;
                    int j = o2.index;
                    if (rk[i] == rk[j]) { //如果o1和o2的前半段
                        try {
                            return rk[i + kk / 2] - rk[j + kk / 2];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            return o1.s.length() - o2.s.length();
                        }
                    } else {
                        return rk[i] - rk[j];
                    }
                });
            }
        }
        //排序完，生产rank，即给定下标，给出排名。
        int r = 0;
        rk[suffixArray[0].index] = r;
        for (int i = 1; i < strLenth; i++) {
            if(suffixArray[i].compareTo(suffixArray[i- 1]) == 0){ // 内容相同
                rk[suffixArray[i].index] = r;//索引-排名，给定索引，知道单个字符的排名
            }else{
                rk[suffixArray[i].index] = ++r;//索引-排名，给定索引，知道单个字符的排名
            }
        }
        return suffixArray;
    }
}
