package problem.problem234;

import common.LinkedListUtil;
import common.ListNode;

import java.util.Stack;

class Solution {

    //todo 38.94%
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;

        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        int length = 0;
        while (p != null) {
            stack.add(p);
            p = p.next;
            length++;
        }
        p = head;
        int i = 1;
        while (p != null) {
            ListNode pop = stack.pop();
            if (i > length / 2) {
                return true;
            } else if (p.val != pop.val) {
                return false;
            } else {
                p = p.next;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(
                LinkedListUtil.arrToLinkedList(new int[]{1, 2})));
    }
}
