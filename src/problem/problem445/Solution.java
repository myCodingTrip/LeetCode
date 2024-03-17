package problem.problem445;

import common.LinkedListUtil;
import common.ListNode;

import java.util.Stack;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }
        }

        int add = 0;
        ListNode head = null;
        while (!s1.empty() || !s2.empty() || add != 0) {

            int v1 = 0;
            int v2 = 0;

            if (!s1.empty()) {
                v1 = s1.pop();
            }
            if (!s2.empty()) {
                v2 = s2.pop();
            }
            int v = v1 + v2 + add;
            ListNode p = new ListNode(v % 10);
            add = v / 10;
            p.next = head;
            head = p;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedListUtil.print(new Solution().addTwoNumbers(
                LinkedListUtil.arrToLinkedList(new int[]{1}), LinkedListUtil.arrToLinkedList(new int[]{9, 9})));
    }
}
