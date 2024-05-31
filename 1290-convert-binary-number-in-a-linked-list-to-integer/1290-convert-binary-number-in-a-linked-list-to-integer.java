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
    public int getDecimalValue(ListNode head) {
        ListNode node=head;
        int size=0,sum=0;
        while(node!=null){
            node=node.next;
            size++;
        }
        node=head;
        while(size!=0){
            sum+=(int)(Math.pow(2,size-1)*node.val);
            node=node.next;
            size--;
        }
        return sum;
    }
}