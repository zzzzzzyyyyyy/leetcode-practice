//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
// 
//
// 示例 2： 
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42 
// Related Topics 树 深度优先搜索 
// 👍 775 👎 0


package com.javatiku.leetcode.editor.cn;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 递归 DFS
     */
    class Solution {
        private int result = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxPathSumHelper(root);
            return result;
        }

        public int maxPathSumHelper(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = maxPathSumHelper(node.left);
            int right = maxPathSumHelper(node.right);

            int maxPathSum = Math.max(Math.max(node.val, left + node.val), right + node.val);

            result = Math.max(maxPathSum, result);
            result = Math.max(left + right + node.val, result);
            return maxPathSum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}