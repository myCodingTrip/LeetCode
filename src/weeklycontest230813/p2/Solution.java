package weeklycontest230813.p2;

import common.LinkedListUtil;
import common.ListNode;

import java.util.Stack;

class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();
        while (p != null) {
            stack.add(p.val);
            p = p.next;
        }
        int add = 0;
        ListNode res = null;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            int i = pop * 2 + add;
            add = 0;
            if (i > 9) {
                add = i / 10;
                i = i % 10;
            }
            ListNode p0 = new ListNode(i, res);
            res = p0;
        }
        if (add > 0) {
            ListNode p0 = new ListNode(add, res);
            res = p0;
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedListUtil.print(new Solution().doubleIt(
                LinkedListUtil.arrToLinkedList(new int[]{9, 9, 9})));
    }
}
