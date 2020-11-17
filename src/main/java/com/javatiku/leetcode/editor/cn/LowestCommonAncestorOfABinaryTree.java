// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
// 一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// 输出: 3
// 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//
//
// 示例 2:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// 输出: 5
// 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉树中。
//
// Related Topics 树
// 👍 831 👎 0

package com.javatiku.leetcode.editor.cn;

public class LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 这是对{@link Solution2}中解法的改进。用boolean数组代替int位运算。 但似乎位运算速度更快一点
     */
    class Solution {
        private TreeNode result = null;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, p, q);
            return result;
        }

        private boolean[] dfs(TreeNode node, TreeNode p, TreeNode q) {
            boolean[] flag = new boolean[2];
            if (node == null) {
                return flag;
            }
            if (node.val == p.val) {
                flag[0] = true;
            }
            if (node.val == q.val) {
                flag[1] = true;
            }

            boolean[] left = dfs(node.left, p, q);
            boolean[] right = dfs(node.right, p, q);

            flag[0] = flag[0] || left[0] || right[0];
            flag[1] = flag[1] || left[1] || right[1];

            if (left[0] && left[1]) {
                return flag;
            } else if (right[0] && right[1]) {
                return flag;
            } else if (flag[0] && flag[1]) {
                result = node;
            }

            return flag;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    /**
     * 自底向上 自己想的解法，感觉不会有人像我这样写
     */
    class Solution2 {
        private TreeNode result = null;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, p, q);
            return result;
        }

        /**
         * 深度优先遍历
         *
         * @param node 当前遍历的结点
         * @param p 结点1
         * @param q 结点2
         * @return int值。按位表示不同的含义。 第一位表示p结点在node节点下。第二位表示q结点在node结点下
         */
        private int dfs(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) {
                return 0;
            }
            int flag = 0;
            if (node.val == p.val) {
                flag ^= 1;
            }
            if (node.val == q.val) {
                flag ^= 2;
            }

            int left = dfs(node.left, p, q);
            int right = dfs(node.right, p, q);
            if (left != 0 && right != 0 && (left ^ right) == 3) {
                result = node;
            } else if (left != 3 && (flag ^ left) == 3) {
                result = node;
            } else if (right != 3 && (flag ^ right) == 3) {
                result = node;
            }

            return flag ^ left ^ right;
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