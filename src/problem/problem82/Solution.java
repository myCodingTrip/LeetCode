package problem.problem82;

import common.LinkedListUtil;
import common.ListNode;

class Solution {

    //执行用时 :
    //1 ms
    //, 在所有 Java 提交中击败了
    //92.48%
    //的用户
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode head0 = new ListNode(0, head);
        ListNode p1 = head0;
        ListNode p2 = head;

        while (p2 != null) {
            if (p2 != null && p2.next != null && p2.val == p2.next.val) {
                while (p2 != null && p2.next != null && p2.val == p2.next.val) {
                    p2 = p2.next;
                }
                p2 = p2.next;

                p1.next = p2;
//                p1 = p2;
            } else {
                p1.next = p2;
                p1 = p2;
                if (p2 != null)
                    p2 = p2.next;
            }
        }

        return head0.next;
    }

    public static void main(String[] args) {
        LinkedListUtil.print(new Solution().deleteDuplicates(
                LinkedListUtil.arrToLinkedList(new int[]{1, 2, 3, 3, 4, 4, 5})));
    }
}
