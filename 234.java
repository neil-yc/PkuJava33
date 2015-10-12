/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	//保留head的引用 方便从两头开始对比
    ListNode temp;
    public boolean isPalindrome(ListNode head) {
		temp = head;
		return test(head);
    }
    public boolean test(ListNode node){
		if(node == null){
			return true;
		}
		boolean b = test(node.next);
		if(b && temp.val == node.val){
			temp = temp.next;
			return true;
		}
		return false;
	}
}