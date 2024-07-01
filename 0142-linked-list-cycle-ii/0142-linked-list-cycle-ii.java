public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(fast==slow){
                    break;
                }
        }
        ListNode p=head;
        if(fast!=slow){
            return null;
        }
        while(p!=slow){
            p=p.next;
            slow=slow.next;
        }
        return slow;
    }
}