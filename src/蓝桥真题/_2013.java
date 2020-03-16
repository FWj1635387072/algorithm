package 蓝桥真题;

import org.junit.Test;

import java.util.Calendar;

public class _2013 {
    /**
     * 世纪末的星期
     * <p>
     * 析：世纪末的星叫
     * 曾有教称1999年12月31日是世界末日。当然该评言已不攻自破
     * 还有称今后的渠个世纪末的12月31日，如果是星期一会、。
     * 有趣的是，任何一个世纪末的年份的12月31日都不可能是星期一
     * 于是，“谣言制商”又修改为星期日
     * 1999年的12月31日是星期五，请问：未来哪一个离我们最近的一个世末年（即xx99年）的12月31日正好是星期天（星期日）？
     * 请回答该年份，（只写这个4位整数，不要写12月31等多余信息）
     */

    //熟悉Caladar的API
    static void _01_世纪末的星期() {
        Calendar calendar = Calendar.getInstance();
        for (int year = 1999; year < 10000; year += 100) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, 11);
            calendar.set(Calendar.DAY_OF_MONTH, 31);
            if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
                System.out.println(year);
                break;
            }
        }
    }


    /**
     * 马虎的算式
     * 小明是个急性子上小学的时候经常把老师写在黑板上的题目抄错了。
     * <p>
     * 有一次老师出的题目是36 x 495 = ? 他却给抄成了396 x 45 = ?
     * <p>
     * 但结果却很戏剧性他的答案竟然是对的  因为 36 * 495 = 396 * 45 = 17820
     * <p>
     * 类似这样的巧合情况可能还有很多比如27 * 594 = 297 * 54
     * <p>
     * 假设 a b c d e 代表1~9不同的5个数字注意是各不相同的数字且不含0
     * <p>
     * 能满足形如ab * cde = adb * ce 这样的算式一共有多少种呢
     */

    static void _02_马虎的算式_枚举() {
        int res = 0;
        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                if (b != a) for (int c = 1; c < 10; c++) {
                    if (c != a && c != b) for (int d = 1; d < 10; d++) {
                        if (d != a && d != b && d != c) for (int e = 1; e < 10; e++) {
                            if (e != a && e != b && e != c && e != d) {
                                if ((a * 10 + b) * (c * 100 + d * 10 + e) == (a * 100 + d * 10 + b) * (c * 10 + e)) {
                                    res++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }


    @Test
    public void test1() {
        // _01_世纪末的星期();
        _02_马虎的算式_枚举();
    }
}
