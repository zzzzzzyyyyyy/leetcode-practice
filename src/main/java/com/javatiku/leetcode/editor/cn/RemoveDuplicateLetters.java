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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

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

            HashSet<Character> seen = new HashSet<>();
            HashMap<Character, Integer> lastOccurrence = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                lastOccurrence.put(s.charAt(i), i);
            }

            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!seen.contains(c)) {
                    while (!stack.isEmpty() && stack.peekLast() > c && lastOccurrence.get(stack.peekLast()) > i) {
                        seen.remove(stack.pollLast());
                    }
                    seen.add(c);
                    stack.add(c);
                }
            }
            return stack.stream().map(Objects::toString).reduce((x, y) -> x + y).orElse("");
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}