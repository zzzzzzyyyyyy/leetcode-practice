//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 示例： 
//
// 输入: ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
//输出: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e'] 
//
// 注意： 
//
// 
// 单词的定义是不包含空格的一系列字符 
// 输入字符串中不会包含前置或尾随的空格 
// 单词与单词之间永远是以单个空格隔开的 
// 
//
// 进阶：使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串 
// 👍 44 👎 0


package com.javatiku.leetcode.editor.cn;

public class ReverseWordsInAStringIi {

    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIi().new Solution();
        char[] array = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        solution.reverseWords(array);
        System.out.println(array);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseWords(char[] s) {
            if (s == null || s.length == 0) {
                return;
            }

            char temp;
            for (int i = 0; i < s.length / 2; i++) {
                temp = s[i];
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = temp;
            }

            int index = 0;
            for (int i = 0; i < s.length; i++) {
                if (i == s.length - 1) {
                    i++;
                } else if (s[i] != ' ') {
                    continue;
                }
                for (int j = index; j <= (i + index - 1) / 2; j++) {
                    temp = s[j];
                    s[j] = s[i - 1 - j + index];
                    s[i - 1 - j + index] = temp;
                }
                index = i + 1;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}