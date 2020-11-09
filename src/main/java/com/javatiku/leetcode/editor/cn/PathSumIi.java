//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
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
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 383 👎 0


package com.javatiku.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathSumIi {

    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * BFS
     */
    class Solution {

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            Queue<List<Integer>> valueQueue = new LinkedList<>();

            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            valueQueue.offer(list);

            root.val = sum - root.val;
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list = valueQueue.poll();
                if (node.left == null && node.right == null && 0 == node.val) {
                    result.add(new ArrayList<>(list));
                }
                if (node.left != null) {
                    List<Integer> leftList = new ArrayList<>(list);
                    leftList.add(node.left.val);
                    valueQueue.offer(leftList);
                    node.left.val = node.val - node.left.val;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    list.add(node.right.val);
                    valueQueue.offer(list);
                    node.right.val = node.val - node.right.val;
                    queue.offer(node.right);
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * DFS
     */
    class Solution2 {
        private List<List<Integer>> result = new ArrayList<>();
        private Deque<Integer> stack = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) {
                return result;
            }

            stack.add(root.val);
            if (root.left == null && root.right == null && sum == root.val) {
                result.add(new ArrayList<>(stack));
            }
            if (root.left != null) {
                pathSum(root.left, sum - root.val);
            }
            if (root.right != null) {
                pathSum(root.right, sum - root.val);
            }
            stack.pollLast();

            return result;
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