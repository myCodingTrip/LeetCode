package problem143;

import common.LinkedListUtil;
import common.ListNode;

import java.util.Stack;

class Solution {

    //todo 29.16
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        int length = 0;
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.add(p);
            p = p.next;
            length++;
        }

        p = head;
        int i = 1;
        while (p != null && !stack.empty()) {
            ListNode p0 = p;
            p = p.next;
            ListNode pop = stack.pop();
            pop.next = p;
            p0.next = pop;
            if (i >= length / 2) {
                p.next = null;
                return;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = LinkedListUtil.arrToLinkedList(new int[]{1, 2, 3, 4});
        new Solution().reorderList(listNode);
        LinkedListUtil.print(listNode);
    }
}