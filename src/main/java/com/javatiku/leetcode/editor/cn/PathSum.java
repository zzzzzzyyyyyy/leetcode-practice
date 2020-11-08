//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索 
// 👍 460 👎 0


package com.javatiku.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {

    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * DFS
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }

            if (root.left == null & root.right == null) {
                return sum == root.val;
            }
            if (root.left != null & hasPathSum(root.left, sum - root.val)) {
                return true;
            }
            return root.right != null & hasPathSum(root.right, sum - root.val);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * BFS
     */
    class Solution2 {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            root.val = sum - root.val;
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left == null & node.right == null && node.val == 0) {
                    return true;
                }
                if (node.left != null) {
                    node.left.val = node.val - node.left.val;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val - node.right.val;
                    queue.offer(node.right);
                }
            }
            return false;
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