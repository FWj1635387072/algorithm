package 练习的例子;

import org.junit.Test;

import java.util.Arrays;

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
    public void test1() {
        System.out.println(solve(8, 8));
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 23, 42, 124, 125, 133};
        int n = 24;
        System.out.println(searchInsert1(arr,n));

    }

    public static int searchInsert(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
        int mid = (begin + end) / 2;
        while (begin < end) {
            mid = begin + (end - begin) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return begin;
    }
    public static int searchInsert1(int[] nums, int target) {
        int  res = Arrays.binarySearch(nums,target);
        if(res < 0){
            return Math.abs(res) - 1;
        }
        return  res;
    }

}
