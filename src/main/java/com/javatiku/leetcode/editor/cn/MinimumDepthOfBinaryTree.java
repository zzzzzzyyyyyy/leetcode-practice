//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 398 👎 0


package com.javatiku.leetcode.editor.cn;

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * DFS
     */
    class Solution {
        private int result = 0;
        private int depth = 0;

        public int minDepth(TreeNode root) {
            if (root == null) {
                return result;
            }

            depth++;
            if (root.left == null && root.right == null) {
                result = result == 0 ? depth : Math.min(result, depth);
            } else if (result != 0 && depth >= result) {
                depth--;
                return result;
            }
            minDepth(root.left);
            minDepth(root.right);
            depth--;
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}