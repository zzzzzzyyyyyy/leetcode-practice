// 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 示例:
//
// 输入: [1,2,3,null,5,null,4]
// 输出: [1, 3, 4]
// 解释:
//
// 1 <---
// / \
// 2 3 <---
// \ \
// 5 4 <---
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 358 👎 0

package com.javatiku.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * BFS 主要思想是 二叉树的层序遍历
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Integer right = null;
                while (size > 0) {
                    TreeNode node = queue.poll();
                    right = node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    size--;
                }
                result.add(right);
            }
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    /**
     * DFS
     */
    class Solution2 {
        List<Integer> result = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return result;
            }

            dfs(root, 1);
            return result;
        }

        private void dfs(TreeNode node, int depth) {
            if (node == null) {
                return;
            }

            if (depth > result.size()) {
                result.add(node.val);
            }

            dfs(node.right, depth + 1);
            dfs(node.left, depth + 1);
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