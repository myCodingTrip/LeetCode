package problem206;

import common.ListNode;

/**
 * 需要使用三个指针，分别是pre、cur和next
 */
class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;
        //第一个节点
        ListNode pre = null;
        //第二个节点
        ListNode cur = head;

        while (cur != null) {
            //第三个节点
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

}
