// 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
// 2
// / \
// 1 3
// 输出: true
//
//
// 示例 2:
//
// 输入:
// 5
// / \
// 1 4
//   / \
//   3 6
// 输出: false
// 解释: 输入为: [5,1,4,null,null,3,6]。
//   根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索
// 👍 828 👎 0

package com.javatiku.leetcode.editor.cn;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 递归，设置上界、下界。校验当前值是否在上下界之间。 当前节点的下界是左子树的下界，当前节点的上界是右子树的上界
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        private boolean isValidBST(TreeNode node, Integer floor, Integer ceiling) {
            if (node == null) {
                return true;
            }
            if (floor != null && floor >= node.val) {
                return false;
            }
            if (ceiling != null && ceiling <= node.val) {
                return false;
            }
            return isValidBST(node.left, floor, node.val) && isValidBST(node.right, node.val, ceiling);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}