package problem.problem328;

import common.LinkedListUtil;
import common.ListNode;

class Solution {

    //0ms 100%
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        ListNode p = even.next;

        int i = 1;

        while (p != null) {
            if (i % 2 == 1) {
                odd.next = p;
                odd = p;
            } else {
                even.next = p;
                even = p;
            }
            i++;
            p = p.next;
        }
        even.next = null;

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        LinkedListUtil.print(new Solution().oddEvenList(
                LinkedListUtil.arrToLinkedList(new int[]{1, 2, 3, 4, 5})));
    }
}
