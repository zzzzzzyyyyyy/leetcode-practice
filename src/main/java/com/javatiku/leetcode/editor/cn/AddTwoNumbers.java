//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4857 👎 0


package com.javatiku.leetcode.editor.cn;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode result = solution.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            }

            int carry = 0;
            int value;
            ListNode preRoot, tempNode;
            preRoot = tempNode = new ListNode(0);
            while (l1 != null || l2 != null) {
                value = carry;
                if (l1 != null) {
                    value += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    value += l2.val;
                    l2 = l2.next;
                }
                tempNode.next = new ListNode(value % 10);
                tempNode = tempNode.next;
                carry = value > 9 ? 1 : 0;
            }
            if (carry > 0) {
                tempNode.next = new ListNode(1);
            }
            return preRoot.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
