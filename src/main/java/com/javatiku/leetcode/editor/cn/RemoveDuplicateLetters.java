//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 257 👎 0


package com.javatiku.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateLetters().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            if (s == null) {
                return "";
            }

            char[] result = new char[s.length()];
            Arrays.fill(result, '0');
            Map<Character, Integer> map = new HashMap<>();
            int previous = s.length() - 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c, i);
                    result[i] = c;
                    previous = i;
                    continue;
                }
                if (c < s.charAt(previous)) {
                    result[map.get(c)] ='0';
                    result[i] = c;
                    previous = i;
                    map.put(c, i);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : result) {
                if (c == '0') {
                    continue;
                }
                stringBuilder.append(c);
            }
            return stringBuilder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}