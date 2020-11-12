//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 733 👎 0


package com.javatiku.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * BFS
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            int result = 0;
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            Queue<Integer> depthQueue = new LinkedList<>();
            queue.add(root);
            depthQueue.add(0);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                int depth = depthQueue.poll();
                depth++;
                if (node.left == null && node.right == null) {
                    result = Math.max(result, depth);
                }
                if (node.left != null) {
                    queue.add(node.left);
                    depthQueue.add(depth);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    depthQueue.add(depth);
                }
            }

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