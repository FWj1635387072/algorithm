package 练习的例子;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class practice_15 {
    /**
     * 小明有一块空地，他将这块空地划分为 n 行 m 列的小块，每行和每列的长度都为 1。
     * 小明选了其中的一些小块空地，种上了草，其他小块仍然保持是空地。
     * 这些草长得很快，每个月，草都会向外长出一些，如果一个小块种了草，则它将向自己的上、下、左、右四小块空地扩展，这四小块空地都将变为有草的小块。
     * 请告诉小明，k 个月后空地上哪些地方有草。
     * 【输入格式】
     * 输入的第一行包含两个整数 n, m。
     * 接下来 n 行，每行包含 m 个字母，表示初始的空地状态，字母之间没有空格。如果为小数点，表示为空地，如果字母为 g，表示种了草。
     * 接下来包含一个整数 k。
     * 【输出格式】
     * 输出 n 行，每行包含 m 个字母，表示 k 个月后空地的状态。如果为小数点，表示为空地，如果字母为 g，表示长了草
     */


    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static Scanner sc;
    static int[][] vis = new int[1000][1000];
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        LinkedList<Block> q = new LinkedList<Block>();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'g') {
                    q.addLast(new Block(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        K = sc.nextInt();

        while (!q.isEmpty()) {
            Block b = q.removeFirst();
            int month = b.month;
            if (month < K) {
                for (int i = 0; i <= 3; i++) {
                    int nx = b.i + dx[i];
                    int ny = b.j + dy[i];
                    if (0 <= nx && nx < N && 0 <= ny && ny < M && vis[nx][ny] == 0) {
                        vis[nx][ny] = 1;
                        q.addLast(new Block(nx, ny, month + 1));
                    }
                }
            }
        }
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (vis[i][j] == 1)
                    bf.write('g');
                else
                    bf.write(".");
            }
            bf.write('\n');
        }
        bf.flush();

    }


    private static class Block {
        int i, j, month;

        public Block(int i, int j, int month) {
            this.i = i;
            this.j = j;
            this.month = month;
        }

    }
}
