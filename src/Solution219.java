/**
 * 存在重复元素2
 *
 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

 示例 1:

 输入: nums = [1,2,3,1], k = 3
 输出: true
 */
public class Solution219 {
    public static void main(String[] args) {
        Solution219 s = new Solution219();
        int[] array = new int[]{1,2,3,1,2,3};
        System.out.println(s.containsNearbyDuplicate(array, 2));
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length && j < i+k+1; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
