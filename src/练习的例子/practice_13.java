package 练习的例子;

import org.junit.Test;

import java.util.Scanner;

public class practice_13 {
    //深度优先搜索DFS
    //数独

    /**
     * 9*9的方格，每一行包含1-9，每一列包含1-9，每一个9*9包含1-9
     */

    public static void main(String[] args) {
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
                    table[x][y] = (char) ('0' + k);
                    dfs(table, x + (y + 1) / 9, (y + 1) % 9);
                }
            }
            table[x][y] = '0'; //回溯
        } else {
            dfs(table, x + (y + 1) / 9, (y + 1) % 9); //处理下一个元素
        }
    }

    private static void print(char[][] talbe) {
        for (int i = 0; i < 9; i++) {
            System.out.println(new String(talbe[i]));
        }
    }

    private static boolean check(char[][] table, int i, int j, int k) {
        //检查同行和同列
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
