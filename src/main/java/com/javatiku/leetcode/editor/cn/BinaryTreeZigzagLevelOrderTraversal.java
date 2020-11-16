// 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
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
// 返回锯齿形层次遍历如下：
//
// [
// [3],
// [20,9],
// [15,7]
// ]
//
// Related Topics 栈 树 广度优先搜索
// 👍 298 👎 0

package com.javatiku.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 这里用两个双端队列，每次将下一行按顺序加入空的那个队列。下次再遍历不为空的队列
     * 
     * 有更好的办法：按照正常层序遍历的方法去遍历，在将结果加入list中的会后判断当前是第几层，奇数层顺序入队，偶数层从队头入队
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Deque<TreeNode> queue1 = new LinkedList<>();
            Deque<TreeNode> queue2 = new LinkedList<>();
            queue1.offer(root);
            while (!queue1.isEmpty() || !queue2.isEmpty()) {
                List<Integer> level = new ArrayList();
                TreeNode node;
                if (queue1.isEmpty()) {
                    while (!queue2.isEmpty()) {
                        node = queue2.pollLast();
                        level.add(node.val);
                        if (node.right != null) {
                            queue1.offer(node.right);
                        }
                        if (node.left != null) {
                            queue1.offer(node.left);
                        }
                    }
                } else {
                    while (!queue1.isEmpty()) {
                        node = queue1.pollLast();
                        level.add(node.val);
                        if (node.left != null) {
                            queue2.offer(node.left);
                        }
                        if (node.right != null) {
                            queue2.offer(node.right);
                        }
                    }
                }
                result.add(level);
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