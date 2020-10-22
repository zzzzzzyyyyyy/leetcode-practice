// 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//
//
//
// 示例 1：
//
// 输入："hello"
// 输出："holle"
//
//
// 示例 2：
//
// 输入："leetcode"
// 输出："leotcede"
//
//
//
// 提示：
//
//
// 元音字母不包含字母 "y" 。
//
// Related Topics 双指针 字符串
// 👍 120 👎 0

package com.javatiku.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        public String reverseVowels(String s) {
            int i = 0;
            int j = s.length() - 1;
            char[] result = new char[s.length()];
            while (i <= j) {
                while (i < j && !vowelSet.contains(s.charAt(i))) {
                    result[i] = s.charAt(i);
                    i++;
                }
                while (i < j && !vowelSet.contains(s.charAt(j))) {
                    result[j] = s.charAt(j);
                    j--;
                }
                result[i] = s.charAt(j);
                result[j] = s.charAt(i);
                i++;
                j--;
            }
            return String.valueOf(result);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}