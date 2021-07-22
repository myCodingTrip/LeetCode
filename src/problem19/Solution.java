package problem19;

import common.LinkedListUtil;
import common.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) return head;
        ListNode head0 = new ListNode(0);
        head0.next = head;
        ListNode p = head0;
        ListNode q = head0.next;
        for (int i = 0; i < n; i++) {
            if (q != null)
                q = q.next;
            else
                return head;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head0.next;
    }

    public static void main(String[] args) {
        ListNode node = LinkedListUtil.arrToLinkedList(new int[]{1});
        LinkedListUtil.print(new Solution().removeNthFromEnd(node, 1));
    }
}