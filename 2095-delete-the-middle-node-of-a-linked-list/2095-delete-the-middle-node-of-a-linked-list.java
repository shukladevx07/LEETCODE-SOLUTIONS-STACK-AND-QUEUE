class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // If the list is empty or has only one node, return null
        }

        // Initialize two pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // To keep track of the node before the middle node

        // Move fast pointer twice as fast as slow pointer
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        if (prev != null) {
            prev.next = slow.next;
        }

        return head;
    }
}
