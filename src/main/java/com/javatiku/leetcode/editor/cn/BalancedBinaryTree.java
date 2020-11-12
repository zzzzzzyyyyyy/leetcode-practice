// 给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
// 输入：root = [3,9,20,null,null,15,7]
// 输出：true
//
//
// 示例 2：
//
//
// 输入：root = [1,2,2,3,3,null,null,4,4]
// 输出：false
//
//
// 示例 3：
//
//
// 输入：root = []
// 输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -104 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索
// 👍 521 👎 0

package com.javatiku.leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 自底向上
     */
    class Solution {

        private boolean result = true;

        /**
         * 判断二叉树是否高度平衡的二叉树
         *
         * @param root 二叉树结点
         * @return 是否高度平衡的二叉树
         */
        public boolean isBalanced(TreeNode root) {
            checkIsBalanced(root);
            return result;
        }

        public int checkIsBalanced(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = checkIsBalanced(node.left);
            int right = checkIsBalanced(node.right);
            if (Math.abs(left - right) > 1) {
                result = false;
            }
            return Math.max(left, right) + 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    /**
     * 自顶向下
     */
    class Solution2 {

        /**
         * 判断二叉树是否高度平衡的二叉树
         *
         * @param root 二叉树结点
         * @return 是否高度平衡的二叉树
         */
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (!isBalanced(root.left) || !isBalanced(root.right)) {
                return false;
            }
            return Math.abs(maximumDepth(root.left) - maximumDepth(root.right)) <= 1;
        }

        /**
         * 二叉树的最大深度
         *
         * @param root 二叉树结点
         * @return 最大深度
         */
        private int maximumDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maximumDepth(root.left), maximumDepth(root.right)) + 1;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}