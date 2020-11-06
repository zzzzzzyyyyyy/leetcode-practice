//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 472 👎 0


package com.javatiku.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 递归
     */
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            return postorder(root, new ArrayList<>());
        }

        private List<Integer> postorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return result;
            }

            postorder(root.left, result);
            postorder(root.right, result);
            result.add(root.val);
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

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