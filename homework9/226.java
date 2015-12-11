/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null){
            return root;
        }
		if(root.left==null && root.right==null){
			return root;
		}
		TreeNode leftNode = null;
		TreeNode rightNode = null;
		TreeNode rootNode = new TreeNode(root.val);
		leftNode = invertTree(root.left);
		rightNode = invertTree(root.right);
		
//		TreeNode temp = null;
//		temp = leftNode;
//		leftNode = rightNode;
//		rightNode = leftNode;

		rootNode.left = rightNode;
		rootNode.right = leftNode;
		
		return rootNode;
    }
}