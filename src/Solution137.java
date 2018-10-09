import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
只出现一次的数字2

给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,3,2]
输出: 3
示例 2:

输入: [0,1,0,1,0,1,99]
输出: 99
 */
public class Solution137 {
    public static void main(String[] args) {
        Solution137 s = new Solution137();
        System.out.print(s.singleNumber(new int[]{1,1,1,3,3,3,4}));
        System.out.print(s.singleNumber2(new int[]{1,1,1,3,3,3,4}));
    }

    /**
     * 利用HashMap记录出现次数，但是利用的额外空间
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer n = map.get(nums[i]);
            map.put(nums[i], n == null? 1 : n+1);
        }

        Iterator<Map.Entry<Integer, Integer>>  iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> next = iter.next();
            if (next.getValue() == 1) {
                return next.getKey();
            }
        }

        return 0;
    }

    /**
     * 统计每一位出现1的个数
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                int n = nums[j] >> i;
                if ((n & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                result = result << 1 | 1;
            }else {
                result = result << 1;
            }
        }
        return result;
    }
}
