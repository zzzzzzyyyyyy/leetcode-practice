// 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,null,2,3]
// 输出：[1,2,3]
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
// 输出：[1,2]
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
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 444 👎 0

package com.javatiku.leetcode.editor.cn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePreorderTraversal {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            Solution solution = new BinaryTreePreorderTraversal().new Solution();
            List<Integer> ret = solution.preorderTraversal(root);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 迭代
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode node = root;
            while (node != null) {
                stack.offer(node);
                result.add(node.val);
                TreeNode next = node.left;
                while (next == null && !stack.isEmpty()) {
                    next = stack.pollLast();
                    if (next != null) {
                        next = next.right;
                    }
                }
                node = next;
            }
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    /**
     * 递归
     */
    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            return preorder(root, new ArrayList<>());
        }

        private List<Integer> preorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return result;
            }
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
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

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
}
