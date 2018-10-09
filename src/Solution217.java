import java.util.Arrays;

/**
 * 存在重复元素
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 */

public class Solution217 {

    public static void main(String[] args) {
        Solution217 s = new Solution217();
        int[] array = new int[]{3,1};
        System.out.println(s.containsDuplicate(array));
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }

        Arrays.sort(nums);
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last){
                return true;
            }
            last = nums[i];
        }

        return false;
    }
}
