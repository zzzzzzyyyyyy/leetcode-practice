// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 你的算法时间复杂度必须是 O(log n) 级别。
//
// 如果数组中不存在目标值，返回 [-1, -1]。
//
// 示例 1:
//
// 输入: nums = [5,7,7,8,8,10], target = 8
// 输出: [3,4]
//
// 示例 2:
//
// 输入: nums = [5,7,7,8,8,10], target = 6
// 输出: [-1,-1]
// Related Topics 数组 二分查找
// 👍 670 👎 0

package com.javatiku.leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 二分法
     */
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            result[0] = searchRangeLeft(nums, target);
            result[1] = searchRangeRight(nums, target);
            return result;
        }

        /** 查找与target相等的最左边的数字下标 */
        public int searchRangeLeft(int[] nums, int target) {
            int left = 0;
            int right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }

            if (left == nums.length || nums[left] != target) {
                return -1;
            }
            return left;
        }

        /** 查找与target相等的最右边的数字下标 */
        public int searchRangeRight(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = (right + left) / 2;

                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }

            if (right < 0 || nums[right] != target) {
                return -1;
            }
            return right;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}