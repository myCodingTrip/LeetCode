package problem.problem83;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

class Solution {

    //没有利用到链表已排序的特点
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        Set<Integer> nums = new HashSet<>();
        nums.add(head.val);
        while (p2 != null) {
            int val = p2.val;
            if (!nums.contains(val)) {
                nums.add(val);
                p1 = p2;
            } else {
                p1.next = p2.next;
            }
            p2 = p2.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
