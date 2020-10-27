//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 500 👎 0


package com.javatiku.leetcode.editor.cn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) throws IOException {
        Solution solution = new GroupAnagrams().new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] array = line.split(",");
            solution.groupAnagrams(array);
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }
            int[] count = new int[26];
            StringBuilder stringBuilder = new StringBuilder();
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                stringBuilder.setLength(0);
                Arrays.fill(count, 0);
                for (int j = 0; j < str.length(); j++) {
                    count[str.charAt(j) - 'a']++;
                }
                for (int k : count) {
                    stringBuilder.append("@");
                    stringBuilder.append(k);
                }
                String key = stringBuilder.toString();
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}