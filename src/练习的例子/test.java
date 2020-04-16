package 练习的例子;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test {
    @Test
    public void test() {
        int num = 14;
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            count++;
        }
        System.out.println(count);
    }

    /**
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     * 示例 1:
     * 输入: [3,0,1]
     * 输出: 2
     * 示例 2:
     * 输入: [9,6,4,2,3,5,7,0,1]
     * 输出: 8
     * 说明:
     * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int[] temp = new int[10000000];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            temp[nums[i]] = 1;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumber1(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i;
            res = res ^ nums[i];
        }
        return res;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * @param nums
     * @return
     */
    //使用异或位运算
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    //使用哈希集合
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 0 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count != 1) {
                return i;
            }
        }
        return -1;
    }


    @Test
    public void test2() {
        System.out.println(singleNumber1(new int[]{4, 1, 2, 1, 2}));
    }


    public int reverse(int x) {
        int res = 0;
        int max = 2147483647;
        while (x != 0) {
            if (Math.abs(res) > max) return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }


    @Test
    public void test3() {
        String s = "asd";
        s.length();
        System.out.println(reverse(123421311));
        s.charAt(1);
    }


    public static void main(String[] args) {

    }

}

class test1 {
    public static void main(String[] args) {
        // System.out.println((char)('0'+1));
        Scanner sc = new Scanner(System.in);
        char[][] table = new char[9][];
        for (int i = 0; i < 9; i++) {
            table[i] = sc.nextLine().toCharArray();
        }
        dfs(table, 0, 0);
    }

    private static void dfs(char[][] table, int x, int y) {
        if (x == 9) {
            print(table);
            System.exit(0);
        }
        if (table[x][y] == '0') {//虚位以待
            for (int k = 1; k < 10; k++) {
                if (check(table, x, y, k)) {
                    // f = false;
                    table[x][y] = (char) ('0' + k);
                    dfs(table, x + (y + 1) / 9, (y + 1) % 9);//处理下一个状态
                }
            }
            table[x][y] = '0';//回溯

        } else {
            dfs(table, x + (y + 1) / 9, (y + 1) % 9);//处理下一个状态
        }

    }

    private static void print(char[][] table) {
        for (int i = 0; i < 9; i++) {
            System.out.println(new String(table[i]));
        }
    }

    private static boolean check(char[][] table, int i, int j, int k) {
        //检查同行和同列i
        for (int l = 0; l < 9; l++) {
            if (table[i][l] == (char) ('0' + k)) return false;
            if (table[l][j] == (char) ('0' + k)) return false;
        }
        //检查小九宫格
        for (int l = (i / 3) * 3; l < (i / 3 + 1) * 3; l++) {
            for (int m = (j / 3) * 3; m < (j / 3 + 1) * 3; m++) {
                if (table[l][m] == (char) ('0' + k)) return false;
            }
        }
        return true;
    }
}
