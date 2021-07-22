package problem25;

import common.LinkedListUtil;
import common.ListNode;

import java.util.Stack;

//你的算法只能使用常数的额外空间。
class Solution {

    //todo 执行用时 :3 ms, 在所有 Java 提交中击败了12.29%的用户
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;
        ListNode head0 = new ListNode(0, head);
        ListNode p1 = head0;
        ListNode p2 = head;
        Stack<ListNode> stack = new Stack<>();

        int i = 0;
        while (true) {
            if (i % k == 0 && !stack.empty()) {
                while (!stack.empty()) {
                    p1.next = stack.pop();
                    p1 = p1.next;
                }
                p1.next = p2;
            } else {
                if (p2 == null) break;
                stack.add(p2);
                i++;
                p2 = p2.next;
            }
        }

        return head0.next;
    }

    public static void main(String[] args) {
        LinkedListUtil.print(new Solution().reverseKGroup(LinkedListUtil.arrToLinkedList(new int[]{1, 2, 3, 4, 5}), 2));
    }
}