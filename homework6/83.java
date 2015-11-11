/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p=head;
       /* 
        ListNode q=p.next;  //RUNTIME  12
        
        while(q!=null){
            if(p.val==q.val){
                p.next=q.next;
                p=p.next;
            }else{
                p=q;
                q=q.next;
            }
        }
        */
         while( p!= null && p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }else{
                p = p.next; 
            }
        }
 
        return head;
    }
}