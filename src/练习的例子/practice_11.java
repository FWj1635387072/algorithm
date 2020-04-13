package 练习的例子;

import com.sun.scenario.animation.AbstractMasterTimer;
import org.junit.Test;

import java.util.*;

public class practice_11 {
    //子集生成


    static Set<Set<Integer>> getSubsets3Core(int[] A, int n, int cur) {
        Set<Set<Integer>> newSet = new HashSet<>();
        if (cur == 0) { //处理第一个元素
            Set<Integer> nil = new HashSet<>();//空集
            Set<Integer> first = new HashSet<>();//包含第一个元素的集合
            first.add(A[0]);
            newSet.add(nil);
            newSet.add(first);
            return newSet;
        }

        Set<Set<Integer>> oldSet = getSubsets3Core(A, n, cur - 1);

        for (Set<Integer> set : oldSet) {
            //对于每个子集，cur这个元素可以加进去，也可以不加进去。
            newSet.add(set);//保留原样
            Set<Integer> clone = (Set<Integer>) ((HashSet) set).clone();
            clone.add(A[cur]);
            newSet.add(clone);//添加当前元素
        }
        return newSet;
    }

    static Set<Set<Integer>> getSubsets3Core(int[] A, int n) {
        return getSubsets3Core(A, n, n - 1);
    }

    @Test
    public void test1() {
        int[] A = {1, 2, 3};
        Set<Set<Integer>> ne = getSubsets3Core(A, A.length);
        System.out.println(ne);
    }

    //二进制解法
    public ArrayList<ArrayList<Integer>> getSubSets(int[] A, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int num = (int) Math.pow(2, n) - 1;
        for (int i = num; i > 0; i--) {
            ArrayList<Integer> s = new ArrayList<>();
            for (int j = n - 1; j >= 0; j--) {
                if (((i >> j) & 1) == 1) {
                    s.add(A[j]);
                }
            }
            res.add(s);
        }
        return res;
    }

    @Test
    public void test2() {
        int[] A = {1, 2, 3};
        ArrayList<ArrayList<Integer>> subSets = getSubSets(A, A.length);
        System.out.println(subSets);
    }

}
