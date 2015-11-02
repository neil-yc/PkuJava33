/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null) return false;
        ListNode a=head;
        ListNode b=head;
        
        while(a.next != null){
        /*    if(b.next!=null) b=b.next.next;
            else return false;
            if(b!=null) a=a.next;
            else return false;
            if(a==b) return true;
        */
        if(b.next == null) return false;
            
             b = b.next.next;
             
             if(b == null) return false;
             
             a = a.next;
             
             if(b == a) return true;
        }
        return false;
    }
}