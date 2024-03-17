package problem.problem147;

import common.LinkedListUtil;
import common.ListNode;

class Solution {

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode head0 = new ListNode(0, head);
        ListNode p1 = head0;
        ListNode tail = head;
        ListNode p2 = head.next;

        while (p2 != null) {
            //已经走到边界 一次排序完成
            //30.48%-->70.03%
            if (tail.val <= p2.val || p1.next == p2) {
                tail = tail.next;
                p2 = p2.next;
                p1 = head0;
            }
            //需要插入
            else if (p1.next.val >= p2.val) {
                tail.next = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p2 = tail.next;
                p1 = head0;
            } else {
                //在子链表中遍历
                p1 = p1.next;
            }

        }

        return head0.next;
    }

    public static void main(String[] args) {
        LinkedListUtil.print(
                new Solution().insertionSortList(
                        LinkedListUtil.arrToLinkedList(new int[]{-1, 5, 3, 4, 0})));
    }
}
