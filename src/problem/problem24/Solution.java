package problem.problem24;

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
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode head0 = new ListNode(0);
        head0.next = head;

        ListNode p = head0;
        ListNode node1;
        ListNode node2;

        while (p.next != null && p.next.next != null) {
            node1 = p.next;
            node2 = node1.next;

            node1.next = node2.next;
            node2.next = node1;
            p.next = node2;

            p = node1;

        }

        return head0.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = LinkedListUtil.arrToLinkedList(arr);
        head = new Solution().swapPairs(head);
        LinkedListUtil.print(head);
    }
}
