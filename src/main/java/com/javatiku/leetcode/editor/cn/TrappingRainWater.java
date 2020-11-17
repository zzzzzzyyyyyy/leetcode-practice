// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
// 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
// 输出：6
// 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
// 输入：height = [4,2,0,3,2,5]
// 输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针
// 👍 1751 👎 0

package com.javatiku.leetcode.editor.cn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrappingRainWater {

    public static void main(String[] args) throws IOException {
        Solution solution = new TrappingRainWater().new Solution();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            int[] height = convertToInt(line);
            System.out.println(solution.trap(height));
        }
    }

    private static int[] convertToInt(String line) {
        String[] lineStr = line.split(",");
        int[] height = new int[lineStr.length];
        for (int i = 0; i < lineStr.length; i++) {
            height[i] = Integer.parseInt(lineStr[i]);
        }
        return height;
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            if (height == null || height.length < 3) {
                return 0;
            }

            int result = 0;
            int left = 0;
            int right = height.length - 1;
            int maxLeft = 0;
            int maxRight = 0;

            while (left <= right) {
                if (maxLeft > maxRight) {
                    if (maxRight > height[right]) {
                        result += maxRight - height[right];
                    } else {
                        maxRight = height[right];
                    }
                    right--;
                } else {
                    if (maxLeft > height[left]) {
                        result += maxLeft - height[left];
                    } else {
                        maxLeft = height[left];
                    }
                    left++;
                }
            }
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    class Solution_Array {
        public int trap(int[] height) {
            if (height == null || height.length < 3) {
                return 0;
            }

            int result = 0;
            int[] maxLeft = new int[height.length];
            int[] maxRight = new int[height.length];

            maxLeft[0] = height[0];
            for (int i = 1; i < height.length; i++) {
                maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
            }
            maxRight[height.length - 1] = height[height.length - 1];
            for (int i = height.length - 2; i >= 0; i--) {
                maxRight[i] = Math.max(maxRight[i + 1], height[i]);
            }

            for (int i = 1; i < height.length - 1; i++) {
                result += Math.max(Math.min(maxLeft[i - 1], maxRight[i + 1]) - height[i], 0);
            }
            return result;
        }
    }
}