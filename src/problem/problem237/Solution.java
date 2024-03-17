package problem.problem237;

import common.LinkedListUtil;
import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (node.next == null) {
            return;
        }
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.arrToLinkedList(new int[]{4, 5, 1, 9});
        ListNode node = head.next;
        new Solution().deleteNode(node);
        LinkedListUtil.print(head);
    }
}
