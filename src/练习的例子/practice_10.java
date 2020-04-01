package 练习的例子;

import org.junit.Test;

public class practice_10 {
    //机器人走方格

    /**
     * 一个X*Y的方格，只能往右，往下走，问有几种走法
     */
    public int solve(int x, int y) {
        if (x == 1 || y == 1) return 1;
        return solve(x - 1, y) + solve(x, y - 1);
    }
    @Test
    public void test1(){
        System.out.println(solve(8,8));
    }
}
