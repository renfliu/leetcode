/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 */

public class Solution43 {

    public static void main(String[] args) {
        Solution43 solution = new Solution43();


        System.out.println(solution.multiply("123", "1"));

    }

    public String multiply(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }else if (num2 == null) {
            return num1;
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int i = num2.length()-1;
        int position = 0;
        String sum = "0";
        while (i >= 0) {
            sum = add(sum, multiplyOne(num1, num2.charAt(i), position));
            i--;
            position++;
        }

        return sum;
    }

    public String multiplyOne(String num1, char num2, int position) {
        StringBuilder sb = new StringBuilder();
        int inum1 = num1.length() -1;
        int carry = 0;
        while (inum1 >= 0) {
            int result = Character.getNumericValue(num1.charAt(inum1)) * Character.getNumericValue(num2) + carry;
            int val = result % 10;
            carry = result / 10;
            sb.append(val);
            inum1--;
        }

        if (carry != 0) {
            sb.append(carry);
        }
        sb = sb.reverse();

        while (position > 0) {
            sb.append(0);
            position--;
        }

        return sb.toString();
    }

    public String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int inum1 = num1.length()-1;
        int inum2 = num2.length()-1;
        int carry = 0;
        while (inum1 >= 0 && inum2 >= 0) {
            int sum = Character.getNumericValue(num1.charAt(inum1)) + Character.getNumericValue(num2.charAt(inum2)) + carry;
            int val = sum % 10;
            carry = sum / 10;
            sb.append(val);
            inum1--;
            inum2--;
        }

        while (inum1 >= 0) {
            int sum = Character.getNumericValue(num1.charAt(inum1)) + carry;
            int val = sum % 10;
            carry = sum / 10;
            sb.append(val);
            inum1--;
        }

        while (inum2 >= 0) {
            int sum = Character.getNumericValue(num2.charAt(inum2)) + carry;
            int val = sum % 10;
            carry = sum / 10;
            sb.append(val);
            inum2--;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
