// 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,null,2,3]
// 输出：[1,3,2]
//
//
// 示例 2：
//
//
// 输入：root = []
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：root = [1]
// 输出：[1]
//
//
// 示例 4：
//
//
// 输入：root = [1,2]
// 输出：[2,1]
//
//
// 示例 5：
//
//
// 输入：root = [1,null,2]
// 输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 769 👎 0

package com.javatiku.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 迭代
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.offer(node);
                    node = node.left;
                }
                node = stack.pollLast();
                result.add(node.val);
                node = node.right;
            }
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    /**
     * 递归
     */
    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            return inorder(root, new ArrayList<>());
        }

        private List<Integer> inorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return result;
            }

            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);
            return result;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}