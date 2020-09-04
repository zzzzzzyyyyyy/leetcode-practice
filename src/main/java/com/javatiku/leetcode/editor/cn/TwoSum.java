// 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
// 因为 nums[0] + nums[1] = 2 + 7 = 9
// 所以返回 [0, 1]
//
// Related Topics 数组 哈希表
// 👍 9043 👎 0

package com.javatiku.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[] {2, 7, 11, 15}, 9);
        assert result[0] == 0;
        assert result[1] == 1;
    }

}

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        if (nums == null) {
            return new int[2];
        }
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = target;
            int j = temp - nums[i];
            Integer x = map.get(j);
            if (x != null) {
                return new int[] {i, x};
            }
        }
        return new int[] {0, 0};
    }
}
// leetcode submit region end(Prohibit modification and deletion)
