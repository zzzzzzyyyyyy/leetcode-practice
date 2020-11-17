// 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定有序数组: [-10,-3,0,5,9],
//
// 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
// 0
// / \
// -3 9
// / /
// -10 5
//
// Related Topics 树 深度优先搜索
// 👍 638 👎 0

package com.javatiku.leetcode.editor.cn;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 利用数组升序的特点 二叉搜索树的特点是：中序遍历结果为升序
     * 所以可以采用二分法来构造平衡二叉搜索树 里用二分法，左右两边的结点数最多只会差1，再保证左右两边分别是平衡二叉搜索树，就可以保证整棵树是平衡的。
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
            int middle = (start + end) / 2;
            TreeNode root = new TreeNode(nums[middle]);
            if (start < middle) {
                root.left = sortedArrayToBST(nums, start, middle - 1);
            }
            if (end > middle) {
                root.right = sortedArrayToBST(nums, middle + 1, end);
            }
            return root;
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