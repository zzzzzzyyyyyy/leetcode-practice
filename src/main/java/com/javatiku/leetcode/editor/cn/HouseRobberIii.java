// 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
// 房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
//
// 示例 1:
//
// 输入: [3,2,3,null,3,null,1]
//
// 3
// / \
// 2 3
// \ \
// 3 1
//
// 输出: 7
// 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
//
// 示例 2:
//
// 输入: [3,4,5,1,3,null,1]
//
//   3
// / \
// 4 5
// / \ \
// 1 3 1
//
// 输出: 9
// 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
//
// Related Topics 树 深度优先搜索
// 👍 632 👎 0

package com.javatiku.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import lombok.EqualsAndHashCode;

public class HouseRobberIii {

    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 递归
     */
    class Solution {
        public int rob(TreeNode root) {
            int[] result = dfs(root);
            return Math.max(result[0], result[1]);
        }

        public int[] dfs(TreeNode node) {
            if (node == null) {
                return new int[] {0, 0};
            }

            int[] left = dfs(node.left);
            int[] right = dfs(node.right);

            int[] current = new int[2];
            current[0] = node.val + left[1] + right[1];
            current[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return current;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    /**
     * HashMap
     */
    class Solution1 {
        private final Map<TreeNode, Integer> map1 = new HashMap<>();
        private final Map<TreeNode, Integer> map2 = new HashMap<>();

        public int rob(TreeNode root) {
            dfs(root);
            return Math.max(map2.getOrDefault(root, 0), map1.getOrDefault(root, 0));
        }

        public void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            dfs(node.right);

            map1.put(node, node.val + map2.getOrDefault(node.left, 0) + map2.getOrDefault(node.right, 0));
            map2.put(node, Math.max(map1.getOrDefault(node.left, 0), map2.getOrDefault(node.left, 0))
                + Math.max(map1.getOrDefault(node.right, 0), map2.getOrDefault(node.right, 0)));
        }
    }

    @EqualsAndHashCode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}