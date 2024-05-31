/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }

        int[] arr = new int[size];
        node = head;
        for (int i = 0; i < size; i++) {
            arr[i] = node.val;
            node = node.next;
        }

        // Reversing using the existing nodes by reassigning values
        node = head;
        for (int i = size - 1; i >= 0; i--) {
            node.val = arr[i];
            node = node.next;
        }

        return head;
    }
}
