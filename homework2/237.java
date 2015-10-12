/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
		//不可直接删node 因为前一个节点的next不能改，所以要删后面的
        node.val = node.next.val;
        node.next = node.next.next;
    }
}