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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c=0;
        ListNode mu=new ListNode(-1);
        ListNode temp=mu;
        while(l1!=null||l2!=null)
        {  int a=0+c;
           if(l1!=null)
           {
              a+=l1.val;
              l1=l1.next;
           }
           if(l2!=null){ a+=l2.val;
           l2=l2.next;}

          
            ListNode n=new ListNode(a%10);
            temp.next=n;
            c=a/10;
            temp=temp.next;
            
            
        }
        if(c!=0)
        {
            ListNode n=new ListNode(c);
            temp.next=n;

        }
        return mu.next;
    }
}