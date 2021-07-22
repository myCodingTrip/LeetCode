package problem61;

import common.ListNode;

class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) return head;

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        int move = length - k % length;

        if (move == 0) return head;

        tail.next = head;

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (move > 1) {
            p1 = p1.next;
            p2 = p2.next;
            move--;
        }

        p1.next = null;

        return p2;
    }
}