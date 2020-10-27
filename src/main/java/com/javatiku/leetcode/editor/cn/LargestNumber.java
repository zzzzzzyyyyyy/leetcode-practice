//给定一组非负整数 nums，重新排列它们每位数字的顺序使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 410 👎 0


package com.javatiku.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class LargestNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    /**
     * 最大堆
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public String largestNumber(int[] nums) {
            if (nums == null) {
                return "";
            }
            if (Arrays.stream(nums).allMatch(x -> x == 0)) {
                return "0";
            }
            Comparator<String> comparator = (o1, o2) -> {
                String o1o2 = o1 + o2;
                String o2o1 = o2 + o1;
                return o2o1.compareTo(o1o2);
            };
            PriorityQueue<String> queue = new PriorityQueue<>(comparator);
            Arrays.stream(nums).boxed().map(Object::toString).forEach(queue::add);
            queue.
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * Arrays.sort排序
     */
    static class Solution1 {
        public String largestNumber(int[] nums) {
            if (nums == null) {
                return "";
            }
            if (Arrays.stream(nums).allMatch(x -> x == 0)) {
                return "0";
            }
            String[] array = Arrays.stream(nums).boxed().map(Object::toString).toArray(String[]::new);
            Comparator<String> comparator = (o1, o2) -> {
                String o1o2 = o1 + o2;
                String o2o1 = o2 + o1;
                return o2o1.compareTo(o1o2);
            };
            Arrays.sort(array, comparator);
            StringBuilder stringBuilder = new StringBuilder();
            Stream.of(array).forEach(stringBuilder::append);
            return stringBuilder.toString();
        }
    }
}