/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */

public class Solution326 {

    // 循环的方法超时
    public boolean isPowerOfThree(int n) {
        int product = 1;
        while (product <= n) {
            if (product == n) {
                return true;
            }else {
                product *= 3;
            }
        }
        return false;
    }

    public boolean isPowerOfThree2(int n) {
        return (n > 0 && Math.pow(3, 19) % n ==0);
    }
}
