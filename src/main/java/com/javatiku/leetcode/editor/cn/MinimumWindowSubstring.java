// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//
// 示例 1：
//
//
// 输入：s = "ADOBECODEBANC", t = "ABC"
// 输出："BANC"
//
//
// 示例 2：
//
//
// 输入：s = "a", t = "a"
// 输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 105
// s 和 t 由英文字母组成
//
//
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 835 👎 0

package com.javatiku.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("aa", "aa"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 第三道滑动窗口，在知道解题思路的情况下做的磕磕绊绊。。。
     * 还是细节把握的不够好，问题都出来细节上
     */
    class Solution {
        private String result = "";

        public String minWindow(String s, String t) {
            int left = 0;
            int right = 0;

            Map<Character, Integer> map = new HashMap<>(16);
            for (int i = 0; i < t.length(); i++) {
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            }
            Map<Character, Integer> temp = new HashMap<>(16);
            int match = 0;
            while (right < s.length()) {
                if (map.containsKey(s.charAt(right))) {
                    temp.put(s.charAt(right), temp.getOrDefault(s.charAt(right), 0) + 1);
                    if (temp.get(s.charAt(right)).compareTo(map.get(s.charAt(right))) == 0) {
                        match++;
                    }
                }
                right++;

                while (match == map.size()) {
                    if (right - left < result.length() || "".equals(result)) {
                        result = s.substring(left, right);
                    }

                    if (temp.containsKey(s.charAt(left))) {
                        temp.put(s.charAt(left), temp.getOrDefault(s.charAt(left), 0) - 1);
                        if (temp.get(s.charAt(left)).compareTo(map.get(s.charAt(left))) < 0) {
                            match--;
                        }
                    }
                    left++;
                }
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}