//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2294 👎 0


package com.javatiku.leetcode.editor.cn;

public class ReverseInteger {

    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(-2147483412));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            String s = Integer.valueOf(x).toString();
            char[] result = new char[s.length()];
            int left = 0;
            int right = s.length() - 1;
            if (s.charAt(left) == '-') {
                left++;
                result[0] = '-';
            }

            while (left <= right) {
                result[left] = s.charAt(right);
                result[right] = s.charAt(left);
                left++;
                right--;
            }

            String reversedNum = String.valueOf(result);
            String maxValue = String.valueOf(Integer.MAX_VALUE);
            if (reversedNum.length() > maxValue.length() || (reversedNum.length() == maxValue.length() && reversedNum.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0)) {
                return 0;
            }
            return Integer.parseInt(reversedNum);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}