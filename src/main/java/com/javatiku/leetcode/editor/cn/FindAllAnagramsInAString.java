// 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//
// 说明：
//
//
// 字母异位词指字母相同，但排列不同的字符串。
// 不考虑答案输出的顺序。
//
//
// 示例 1:
//
//
// 输入:
// s: "cbaebabacd" p: "abc"
//
// 输出:
// [0, 6]
//
// 解释:
// 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
// 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
//
//
// 示例 2:
//
//
// 输入:
// s: "abab" p: "ab"
//
// 输出:
// [0, 1, 2]
//
// 解释:
// 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
// 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
// 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
//
// Related Topics 哈希表
// 👍 410 👎 0

package com.javatiku.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 第二道滑动窗口，可真难啊
     * 双指针，右边的先走，统计窗口内的字符，如果出现了预期数量的比对字符串中的字符，再移动左边的指针，让窗口缩小。
     * 当窗口内 出现了预期数量的比对字符串中的字符，且窗口大小等于比对字符串大小时，获得一个异构字符串
     */
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int left = 0;
            int right = 0;

            List<Integer> result = new ArrayList<>();

            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < p.length(); i++) {
                map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
            }
            int[] temp = new int[26];
            int match = 0;
            while (right < s.length()) {
                if (map.containsKey(s.charAt(right))) {
                    temp[s.charAt(right) - 'a']++;
                    if (temp[s.charAt(right) - 'a'] == map.get(s.charAt(right))) {
                        match++;
                    }
                }

                right++;
                while (match == map.size()) {
                    if (right - left == p.length()) {
                        result.add(left);
                    }
                    if (map.containsKey(s.charAt(left))) {
                        temp[s.charAt(left) - 'a']--;
                        if (temp[s.charAt(left) - 'a'] < map.get(s.charAt(left))) {
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