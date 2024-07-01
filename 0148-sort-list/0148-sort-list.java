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



 // pehle linked list ki length nikalo 
 // us length ka array bnao 
 // array mein elements store krado saare
 // array ko sort maardo 
 // phir vapas usko linked list mein store krado 

class Solution
 {
    public ListNode sortList(ListNode head) 
    {
        ListNode temp =head;
         int length=0;
        while(temp!=null)
        {
         length++;
         temp=temp.next;
        }

        int arr[] =new int[length];
        temp=head;
        int pos=0;
        while(temp!=null)
        {
            arr[pos]=temp.val;
            pos++;
            temp=temp.next;
        }

        Arrays.sort(arr);

        temp=head;
        int count=0;
         while(temp!=null)
         {
        temp.val=arr[count];
        count++;
        temp=temp.next;
         }
         return head;
    }
}