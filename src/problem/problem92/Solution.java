package problem.problem92;

import common.LinkedListUtil;
import common.ListNode;

import java.util.Stack;

/**
 * 1ms 100%
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n <= 1) return head;
        ListNode p = head;
        ListNode start = null;
        Stack<ListNode> stack = new Stack<>();
        int i = 1;
        while (true) {
            if (i == m - 1) start = p;
            if (i >= m && i <= n)
                stack.add(p);
            if (i > n) {
                while (!stack.empty()) {
                    if (start == null) {
                        start = stack.pop();
                        head = start;
                    }
                    if (!stack.isEmpty()) {
                        start.next = stack.pop();
                        start = start.next;
                    }
                }
                start.next = p;
                break;
            }
            p = p.next;
            i++;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListUtil.print(new Solution().reverseBetween(
                LinkedListUtil.arrToLinkedList(new int[]{5}), 1, 1));
        LinkedListUtil.print(new Solution().reverseBetween(
                LinkedListUtil.arrToLinkedList(new int[]{1, 2, 3, 4, 5}), 1, 5));
    }
}
