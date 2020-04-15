package 练习的例子;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class practice_14 {
    //迷宫游戏
    /**
     * 1表示墙，不能走。
     * 0表示路，可以走
     */
    private int[][] array = {

            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 1, 0, 1},
            {0, 1, 1, 1, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 1, 1, 1, 1, 0, 0, 1},
            {1, 1, 0, 0, 0, 1, 0, 1},
            {1, 1, 0, 0, 0, 0, 0, 0}
    };

    private int maxLine = 8;
    private int maxRow = 9;

    private void check(int i, int j) throws IOException {
        if (i == maxRow - 1 && j == maxLine - 1) {
            print();
            return;
        }

        //向右走
        if (canMove(i, j, i, j + 1)) {
            array[i][j] = 5;
            check(i, j + 1);
            array[i][j] = 0;
        }
        //向左走
        if (canMove(i, j, i, j - 1)) {
            array[i][j] = 5;
            check(i, j - 1);
            array[i][j] = 0;
        }
        //向下走
        if (canMove(i, j, i + 1, j)) {
            array[i][j] = 5;
            check(i + 1, j);
            array[i][j] = 0;
        }
        //向右走
        if (canMove(i, j, i - 1, j)) {
            array[i][j] = 5;
            check(i - 1, j);
            array[i][j] = 0;
        }
    }

    private boolean canMove(int i, int j, int targetI, int targetJ) {
        if (targetI < 0 || targetJ < 0 || targetI >= maxRow || targetJ >= maxLine)
            return false;

        if (array[targetI][targetJ] == 1)
            return false;

        if (array[targetI][targetJ] == 5)
            return false;

        return true;
    }

    private void print() throws IOException {
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        System.out.println("得到一个解");
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxLine; j++) {
                bf.write(array[i][j] + " ");
            }
            bf.write("\n");
        }
        bf.flush();
    }

    @Test
    public void test() throws IOException {
        check(0, 0);
    }

}
