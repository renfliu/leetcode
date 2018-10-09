/**
 *
 只出现一次的数字3
 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。

 示例 :

 输入: [1,2,1,3,2,5]
 输出: [3,5]
 注意：

 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
public class Solution260 {
    public static void main(String[] args) {
        Solution260 s = new Solution260();
        int[] r = s.singleNumber(new int[] {1,1,2,2,4,5,5,6});
        System.out.print(r[0] + " " + r[1]);
    }

    /**
     * 先计算所有数字的异或，结果即两个出现一次的数字的异或，找出不同的位，利用这一位将数组分割成两部分，
     * 每一部分单独计算。
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x = x ^ nums[i];
        }
        int bit1 = 0;
        while (((x >> bit1) & 1) == 0) {
            bit1++;
        }

        int first = 0, second = 0;
        for (int i = 0; i < nums.length ; i++) {
            if ((nums[i] & (1<<bit1)) == 0) {
                first = first ^ nums[i];
            } else {
                second = second ^ nums[i];
            }
        }

        return new int[] {first, second};
    }
}
