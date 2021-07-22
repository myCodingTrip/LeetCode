package problem148;

import common.LinkedListUtil;
import common.ListNode;
import javafx.util.Pair;

//链表的归并排序 使用迭代
//todo 不是很理解
public class Solution2 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode head0 = new ListNode(0, head);
        int sz = 1;

        while (true) {

            ListNode pre = head0;
            ListNode cur = pre;

            while (cur.next != null) {
                cur = pre;
                for (int i = 0; i < sz && cur.next != null; i++, cur = cur.next) ;

                if (cur.next != null) {
                    ListNode pre2 = cur;
                    for (int i = 0; i < sz && cur.next != null; i++, cur = cur.next) ;
                    ListNode next = cur.next;
                    ListNode head2 = pre2.next;

                    pre2.next = null;
                    cur.next = null;

                    Pair<ListNode, ListNode> pair = merge(pre.next, head2);

                    pre.next = pair.getKey();
                    ListNode tail = pair.getValue();

                    pre = tail;
                    pre.next = next;
                } else if (pre == head0) {
                    sz = 0;
                    break;
                }
            }
            if (sz == 0) break;
            else sz *= 2;
        }

        return head0.next;
    }

    private Pair<ListNode, ListNode> merge(ListNode a, ListNode b) {
        ListNode head0 = new ListNode(0);
        ListNode p1 = a, p2 = b, p = head0;
        while (p1 != null && p2 != null)
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
                p.next = null;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
                p.next = null;
            }
        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;

        ListNode tail = p;
        while (tail.next != null) tail = tail.next;

        return new Pair<>(head0.next, tail);
    }

    public static void main(String[] args) {
        LinkedListUtil.print(
                new Solution2().sortList(
                        LinkedListUtil.arrToLinkedList(new int[]{4, 2, 1, 3})));
    }
}
