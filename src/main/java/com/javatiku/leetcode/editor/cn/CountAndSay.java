// 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
//
// 注意：整数序列中的每一项将表示为一个字符串。
//
// 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
//
// 1. 1
// 2. 11
// 3. 21
// 4. 1211
// 5. 111221
//
//
// 第一项是数字 1
//
// 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
//
// 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
//
// 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
//
// 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
//
//
//
// 示例 1:
//
// 输入: 1
// 输出: "1"
// 解释：这是一个基本样例。
//
// 示例 2:
//
// 输入: 4
// 输出: "1211"
// 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似
// "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
// Related Topics 字符串
// 👍 589 👎 0

package com.javatiku.leetcode.editor.cn;

public class CountAndSay {

    public static void main(String[] args) {
        Solution solution = new CountAndSay().new Solution();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(2));
        System.out.println(solution.countAndSay(3));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(5));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String countAndSay(int n) {
            if (n < 1) {
                return "";
            } else if (n == 1) {
                return "1";
            }

            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            StringBuilder origin;
            StringBuilder target;
            a.append('1');
            boolean flag = true;
            while (n > 1) {
                if (flag) {
                    origin = a;
                    target = b;
                } else {
                    origin = b;
                    target = a;
                }
                int i;
                int count = 1;
                for (i = 0; i < origin.length(); i++) {
                    if (i + 1 < origin.length() && origin.charAt(i) == origin.charAt(i + 1)) {
                        count++;
                        continue;
                    }
                    target.append((char)(count + '0'));
                    target.append(origin.charAt(i));
                    count = 1;
                }
                origin.setLength(0);
                flag = !flag;
                n--;
            }
            return (flag ? a : b).toString();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}