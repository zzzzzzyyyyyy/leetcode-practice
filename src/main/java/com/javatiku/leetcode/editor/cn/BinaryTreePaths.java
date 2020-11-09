// 给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
// 输出: ["1->2->5", "1->3"]
//
// 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
// Related Topics 树 深度优先搜索
// 👍 395 👎 0

package com.javatiku.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {

    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * BFS
     */
    class Solution {
        private List<String> result = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) {
                return result;
            }

            Queue<TreeNode> nodeQueue = new LinkedList<>();
            Queue<StringBuilder> queue = new LinkedList<>();
            nodeQueue.add(root);
            queue.add(new StringBuilder().append(root.val));
            while (!queue.isEmpty()) {
                TreeNode node = nodeQueue.poll();
                StringBuilder stringBuilder = queue.poll();
                if (node.left == null && node.right == null) {
                    result.add(stringBuilder.toString());
                    continue;
                }
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    queue.add(new StringBuilder(stringBuilder.toString()).append("->").append(node.left.val));
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    queue.add(stringBuilder.append("->").append(node.right.val));
                }
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    /**
     * DFS
     */
    class Solution2 {
        private List<String> result = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) {
                return result;
            }

            binaryTreePaths(root, new StringBuilder());
            return result;
        }

        public void binaryTreePaths(TreeNode node, StringBuilder stringBuilder) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("->");
            }
            stringBuilder.append(node.val);
            if (node.left == null && node.right == null) {
                result.add(stringBuilder.toString());
                return;
            }
            int count = stringBuilder.length();
            if (node.left != null) {
                binaryTreePaths(node.left, stringBuilder);
            }
            stringBuilder.setLength(count);
            if (node.right != null) {
                binaryTreePaths(node.right, stringBuilder);
            }
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