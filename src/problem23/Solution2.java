package problem23;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution2 {
    //todo 38.23---->41.51
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode head0 = new ListNode(0);
        ListNode p0 = head0;

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            p0.next = queue.poll();
            p0 = p0.next;
            if (p0.next != null) {
                queue.offer(p0.next);
            }
        }

        return head0.next;
    }
}