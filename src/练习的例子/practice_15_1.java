package 练习的例子;

public class practice_15_1 {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, 1, 0};
    static int[][] arr = new int[1000][1000];
    static int N,M,K;

    private class Block {
        int i, j, month;

        public Block(int i, int j, int month) {
            this.i = i;
            this.j = j;
            this.month = month;
        }
    }
}
