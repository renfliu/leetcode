import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
两个数组的交集

给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]
说明:

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
 */
public class Solution349 {
    public static void main(String[] args) {
        Solution349 s = new Solution349();
        int[] result = s.intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * 不考虑出现次数
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            Integer temp = map.get(i);
            map.put(i, temp == null ? 1 : temp+1);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums2) {
            if (map.get(i) != null) {
                set.add(i);
            }
        }

        int[] r = new int[set.size()];
        int ir = 0;
        for (int i : set) {
            r[ir++] = i;
        }
        return r;
    }

    /**
     * 次数保持不变
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            Integer temp = map.get(i);
            map.put(i, temp == null ? 1 : temp+1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            Integer temp = map.get(i);
            if (temp != null && temp > 0) {
                list.add(i);
                map.put(i, temp-1);
            }
        }

        int[] r = new int[list.size()];
        int ir = 0;
        for (int i : list) {
            r[ir++] = i;
        }
        return r;
    }
}
