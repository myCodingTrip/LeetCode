package problem.problem23;

import common.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    //41.51%
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> queue = new PriorityQueue<>();
        int n = lists.length;
        ListNode head0 = new ListNode(0);
        ListNode p0 = head0;
        ListNode[] pointList = new ListNode[n];
        for (int i = 0; i < n; i++) {
            pointList[i] = lists[i];
        }
        boolean finish = false;
        while (!finish) {
            finish = true;
            for (int i = 0; i < n; i++) {
                ListNode p = pointList[i];
                if (p != null) {
                    finish = false;
                    queue.offer(p.val);
                    pointList[i] = p.next;
                }
            }
        }
        while (!queue.isEmpty()) {
            p0.next = new ListNode(queue.poll());
            p0 = p0.next;
        }

        return head0.next;
    }
}
