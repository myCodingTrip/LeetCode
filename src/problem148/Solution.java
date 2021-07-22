package problem148;

import common.LinkedListUtil;
import common.ListNode;

//链表的归并排序 使用递归
class Solution {
    //11.21-->50.19
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(head2);

        ListNode head0 = new ListNode(0);
        ListNode p = head0;
        while (left != null || right != null) {
            if (left == null) {
                p.next = right;
                //50.19-->99.18
                break;
            } else if (right == null) {
                p.next = left;
                break;
            } else {
                if (left.val <= right.val) {
                    p.next = left;
                    left = left.next;
                } else {
                    p.next = right;
                    right = right.next;
                }
            }
            p = p.next;
        }

        return head0.next;
    }

    public static void main(String[] args) {
        LinkedListUtil.print(
                new Solution().sortList(
                        LinkedListUtil.arrToLinkedList(new int[]{4, 2, 1, 3})));
    }
}