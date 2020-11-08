//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1108 👎 0


package com.javatiku.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 递归
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            return isSymmetric(root.left, root.right);
        }

        /**
         * 判断两棵树是否互为镜像
         *
         * @param p 一棵树
         * @param q 另一棵树
         * @return 两个树是否互为镜像
         */
        private boolean isSymmetric(TreeNode p, TreeNode q) {
            if (p == null & q == null) {
                return true;
            } else if (p == null ^ q == null) {
                return false;
            } else if (p.val != q.val) {
                return false;
            }
            return isSymmetric(p.left, q.right) & isSymmetric(p.right, q.left);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 第一版，很慢
     * 执行用时：3 ms, 在所有 Java 提交中击败了8.02%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了15.97%的用户
     * <p>
     * 改进的迭代方法是，维护两个队列。判断两棵树是否互为镜像
     */
    class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            while (!list.isEmpty()) {
                int count = list.size();
                for (int i = 0; i <= count / 2; i++) {
                    if (list.get(i) == null & list.get(count - i - 1) == null) {
                        continue;
                    }
                    if (list.get(i) == null ^ list.get(count - i - 1) == null) {
                        return false;
                    }
                    if (list.get(i).val != list.get(count - i - 1).val) {
                        return false;
                    }
                }
                for (int i = 0; i < count; i++) {
                    if (list.get(i) == null) {
                        continue;
                    }
                    list.add(list.get(i).left);
                    list.add(list.get(i).right);
                }
                list = list.subList(count, list.size());
            }
            return true;
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