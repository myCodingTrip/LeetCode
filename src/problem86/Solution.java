package problem86;

import common.LinkedListUtil;
import common.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        List<ListNode> list = new ArrayList<>();
        ListNode head0 = new ListNode(0, head);
        ListNode cur = head0;
        while (true) {

            if (cur.next == null) {
                for (ListNode listNode : list) {
                    cur.next = listNode;
                    cur = listNode;
                }
                cur.next = null;
                break;
            }

            if (cur.next.val >= x) {
                list.add(cur.next);
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head0.next;
    }

    public static void main(String[] args) {
        LinkedListUtil.print(new Solution().partition(
                LinkedListUtil.arrToLinkedList(new int[]{2, 1}), 2));
    }
}