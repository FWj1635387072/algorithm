package 练习的例子;

import java.util.Set;

public class practice_11 {
    //非空子集---二进制


    private Set<Set<Integer>> getSubsets3Core(int[] A, int n, int cur) {
        Set<Set<Integer>> oldSet = getSubsets3Core(A, n, cur - 1);
        return null;
    }

}
