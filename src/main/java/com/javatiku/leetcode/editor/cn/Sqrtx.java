//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 534 👎 0


package com.javatiku.leetcode.editor.cn;

public class Sqrtx {

    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(2147483647));
    }

    /**
     * 二分查找法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            } else if (x < 4) {
                return 1;
            }
            int i = 1;
            int j = x / 2;
            while (i < j - 1) {
                int middle = (i + j) / 2;
                if (x / middle == middle) {
                    return middle;
                } else if (x / middle < middle) {
                    j = middle;
                } else {
                    i = middle;
                }
            }
            if (x / j >= j) {
                return j;
            }
            return i;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}