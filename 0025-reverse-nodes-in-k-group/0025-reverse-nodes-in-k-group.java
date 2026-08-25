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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode KthNode=head;
        int c=1;
        if(head==null||head.next==null) return head;

         ListNode next=null;
         ListNode prev=null;
        while(KthNode!=null)
        {
           if(c==k)
           {
            if(temp==head)
            {
                next=KthNode.next;
                KthNode.next=null;
                head=reverse(temp);
                temp.next=next;
                prev=temp;
                 KthNode=temp.next;
                temp=temp.next;
                c=1;
            }
            else{
                 next=KthNode.next;
                 KthNode.next=null;
               
                 ListNode t=reverse(temp);
                 prev.next=t;
                 temp.next=next;
                 prev=temp;
                 KthNode=temp.next;
                 temp=temp.next;
                 c=1;

            }
           }
           else{
           c++;
           KthNode=KthNode.next;
           }
        }
       return head;
        
    }
    public  ListNode reverse( ListNode temp)
    {
      
        ListNode prev=null;
       while(temp!=null)
       {
         ListNode curr=temp.next;
         temp.next=prev;
         prev=temp;
         temp=curr;

       }
       return prev;
    }
}