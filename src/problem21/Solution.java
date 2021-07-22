package problem21;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //仅作为根，root.next为结果链表
        ListNode root = new ListNode(0);
        //结果链表临时节点
        ListNode n = root;

        while (true) {
            //分4种情况进行处理
            if (l1 == null && l2 != null) {
                n.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                n.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    n.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    n.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            } else {
                break;
            }
            n = n.next;
        }
        return root.next;
    }

}