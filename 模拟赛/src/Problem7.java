import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[n][m];
        int leftR = 0, leftC = 0;
        int rightR = n - 1, rightC = m - 1;
        int pr = leftR, pc = leftC;
        int i = 1;
        while (leftC < rightC && leftR < rightR) {
            while (pc <= rightC) {
                arr[pr][pc++] = i++;
            }
            pc = rightC;
            pr++;
            while (pr <= rightR) {
                arr[pr++][pc] = i++;
            }
            pr--;
            pc--;
            while (pc>=leftC){
                arr[pr][pc--] = i++;
            }
            pr--;
            pc++;
            while (pr>leftR){
                arr[pr--][pc] = i++;
            }
            leftC++;
            leftR++;
            rightC--;
            rightR--;
            pr = leftR;
            pc = leftC;
        }
        System.out.println(arr[r-1][c-1]);
    }
}
