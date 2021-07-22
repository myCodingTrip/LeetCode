package common;

public class LinkedListUtil {
    public static ListNode arrToLinkedList(int[] arr) {
        if (arr == null) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            p.next = node;
            p = p.next;
        }
        return head;
    }

    public static void print(ListNode head) {
        ListNode p = head;
        int i = 0;
        while (p != null) {
            System.out.print(p.val + " --> ");
            p = p.next;
            if (++i > 1000) break;
        }
        System.out.print("null\n");
    }
}
