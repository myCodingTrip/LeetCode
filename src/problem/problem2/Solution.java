package problem.problem2;

import common.LinkedListUtil;
import common.ListNode;

class Solution {

    //2ms 99.92
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head0 = new ListNode(0);
        ListNode p = head0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int add = 0;
        while (p1 != null || p2 != null || add != 0) {

            int v1 = 0;
            int v2 = 0;

            if (p1 != null) v1 = p1.val;
            if (p2 != null) v2 = p2.val;

            int sum = v1 + v2 + add;
            p.next = new ListNode((sum) % 10);
            add = sum / 10;

            if (p1 != null)
                p1 = p1.next;
            if (p2 != null)
                p2 = p2.next;

            p = p.next;
        }

        return head0.next;
    }

    public static void main(String[] args) {
        LinkedListUtil.print(new Solution().addTwoNumbers(
                LinkedListUtil.arrToLinkedList(new int[]{5}), LinkedListUtil.arrToLinkedList(new int[]{5})));
    }
}
