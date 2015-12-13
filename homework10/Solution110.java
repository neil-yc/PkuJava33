/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.lang.Math;
public class Solution110 {
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

	public boolean isBalanced(TreeNode root) {
		if (root==null) return false;
		//else if (root.left==null && root.right==null) return true;
		if ( Math.abs(treeDepth(root.left) - treeDepth(root.right)) > 1 ) return false;
		else return (isBalanced(root.left) && isBalanced(root.right));
	}

	private int treeDepth(TreeNode node) {
		if (node==null) return 0;
		return Math.max(treeDepth(node.left)+1, treeDepth(node.right)+1);
	}
}