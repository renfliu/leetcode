/**
 *
 加一

 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。
 */
public class Solution66 {
    public static void main(String[] args) {
        Solution66 s = new Solution66();
        int[] num = {8,9,9};
        int[] sum = s.plusOne(num);
        for (int i : sum) {
            System.out.print(i);
        }
    }
    public int[] plusOne(int[] digits) {
        boolean isAll9 = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9)
                isAll9 = false;
        }

        if (isAll9) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = 0;
            }
            return result;
        }

        int carry = 1;
        for (int i = digits.length-1; i >= 0 && carry != 0; i--) {
            if (digits[i] >= 9) {
                digits[i] = 0;
            }else {
                digits[i] += carry;
                carry = 0;
            }
        }
        return digits;
    }
}
