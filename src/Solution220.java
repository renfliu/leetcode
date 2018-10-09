import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * 存在重复元素3
 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。

 示例 1:

 输入: nums = [1,2,3,1], k = 3, t = 0
 输出: true
 示例 2:

 输入: nums = [1,0,1,1], k = 1, t = 2
 输出: true
 示例 3:

 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 输出: false
 */
public class Solution220 {
    public static void main(String[] args) {
        Solution220 s = new Solution220();
        int[] array = new int[] {-10, 0, 10, 10, 20};
        System.out.println(s.containsNearbyAlmostDuplicate(array, 3, 5));
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 0 || t < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long curr = (long)nums[i];
            long leftBoundary = curr -t;
            long rightBoundary = curr+t+1;
            SortedSet<Long> subSet = set.subSet(leftBoundary, rightBoundary);
            if (subSet.size() > 0) {
                return true;
            }

            set.add(curr);

            if (set.size() > k) {
                set.remove((long)nums[i-k]);
            }
        }


        return false;
    }
}
