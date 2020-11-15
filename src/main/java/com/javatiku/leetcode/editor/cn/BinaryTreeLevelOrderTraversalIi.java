// 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
// 给定二叉树 [3,9,20,null,null,15,7],
//
// 3
// / \
// 9 20
// / \
// 15 7
//
//
// 返回其自底向上的层次遍历为：
//
// [
// [15,7],
// [9,20],
// [3]
// ]
//
// Related Topics 树 广度优先搜索
// 👍 364 👎 0

package com.javatiku.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIi {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * BFS
     */
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            List<TreeNode> list = new ArrayList<>();
            TreeNode dummy = new TreeNode(0);
            list.add(root);
            list.add(dummy);
            int index = 0;
            while (index < list.size()) {
                TreeNode node = list.get(index++);
                if (index < list.size() && node == dummy) {
                    list.add(dummy);
                    continue;
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                if (node.left != null) {
                    list.add(node.left);
                }
            }

            index = list.size() - 1;
            while (index >= 0) {
                TreeNode node;
                List<Integer> level = new ArrayList<>();
                while (index >= 0) {
                    node = list.get(index--);
                    if (node == dummy) {
                        break;
                    }
                    level.add(node.val);
                }
                if (!level.isEmpty()) {
                    result.add(level);
                }
            }
            return result;
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