/*
398
给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。

注意：
数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。


 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution398 {
    private int[] nums;
    Random rand = new Random();

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,3};
        Solution398 solution = new Solution398(nums);
        System.out.print(solution.pick(1));
        System.out.print(solution.pick(3));
    }

    public Solution398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }
        return result.get(rand.nextInt(result.size()));
    }
}
