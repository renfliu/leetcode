/**
 *
 移动零

 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。
 */
public class Solution283 {
    public static void main(String[] args) {
        Solution283 s = new Solution283();
        int[] num = {2,0,4,7,0,1};
        s.moveZeroes(num);
        for (int i : num) {
            System.out.print(i + " ");
        }
    }

    public void moveZeroes(int[] nums) {
        for (int i = nums.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] == 0) {
                    swap(nums, j, j+1);
                }
            }
        }
    }

    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
