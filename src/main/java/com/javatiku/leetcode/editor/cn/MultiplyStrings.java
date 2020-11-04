//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 504 👎 0


package com.javatiku.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        System.out.println(solution.multiply("123", "456"));
    }

    /**
     * 两数相乘
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
                return "0";
            }

            List<String> numberList = new ArrayList<>();
            for (int i = num1.length() - 1; i >= 0; i--) {
                StringBuilder number = multiplySingleDigit(num2, num1.charAt(i) - '0');
                number.reverse();
                for (int j = 0; j < num1.length() - 1 - i; j++) {
                    number.append('0');
                }
                numberList.add(trimZero(number.toString()));
            }
            return numberList.stream().reduce(this::addDigits).orElse("0");
        }

        /**
         * 数字字符串相加
         *
         * @param a 数字A
         * @param b 数字B
         * @return 结果
         */
        private String addDigits(String a, String b) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;
            while (i >= 0 || j >= 0) {
                int x = 0;
                int y = 0;
                if (i >= 0) {
                    x = a.charAt(i--) - '0';
                }
                if (j >= 0) {
                    y = b.charAt(j--) - '0';
                }
                stringBuilder.append((x + y + carry) % 10);
                carry = (x + y + carry) / 10;
            }
            stringBuilder.append(carry);
            stringBuilder.reverse();
            return trimZero(stringBuilder.toString());
        }

        /**
         * 数字字符串 乘 个位数
         *
         * @param number      数字字符串
         * @param singleDigit 个位数
         * @return 结果
         */
        private StringBuilder multiplySingleDigit(String number, int singleDigit) {
            StringBuilder result = new StringBuilder();
            int carry = 0;
            for (int i = number.length() - 1; i >= 0; i--) {
                result.append(((number.charAt(i) - '0') * singleDigit + carry) % 10);
                carry = ((number.charAt(i) - '0') * singleDigit + carry) / 10;
            }
            if (carry > 0) {
                result.append(carry);
            }
            return result;
        }

        /**
         * 剪除首部的0
         *
         * @param str 需要剪除的字符串
         * @return 结果
         */
        String trimZero(String str) {
            int index = 0;
            while (index < str.length() - 1 && str.charAt(index) == '0') {
                index++;
            }
            return str.substring(index);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}