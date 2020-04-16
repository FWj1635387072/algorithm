package 练习的例子;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.function.BiFunction;

public class practice_14_1 {
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
    private int maxRow = 9;
    private int maxLine = 8;

    private void check(int x, int y) throws IOException {
        if (x  == maxRow - 1 && y  == maxLine - 1) {
            print();
            System.exit(0);
        }
        //向右走
        if (canMove(x, y + 1)) {
            array[x][y] = 5;
            check(x, y + 1);
            array[x][y] = 1;
        }

        //向左走
        if(canMove(x,y - 1)){
            array[x][y] = 5;
            check(x,y-1);
            array[x][y] = 1;
        }
        //向下走
        if (canMove(x+1,y)){
            array[x][y] = 5;
            check(x+1,y);
            array[x][y] = 1;
        }
        //向上走
        if(canMove(x-1,y)){
            array[x][y] = 5;
            check(x-1,y);
            array[x][y] = 1;
        }
    }

    private boolean canMove(int x, int y) {
        if (x > maxRow - 1 || y > maxLine - 1 || x < 0 || y < 0)
            return false;
        if (array[x][y] == 1 || array[x][y] == 5)
            return false;
        return true;

    }

    private void print() throws IOException {
        System.out.println("有一解");
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxLine; j++) {
                bf.write(array[i][j] + " ");
            }
            bf.write('\n');
        }
        bf.flush();
    }
    @Test
    public void test1() throws IOException {
        check(0,0);
    }

}
