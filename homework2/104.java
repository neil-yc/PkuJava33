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
    public int maxDepth(TreeNode root) {
        
        if( root == null)
            return 0;
		//·Ö×óÓÒ×ÓÊ÷
        int x = maxDepth(root.left);
        int y = maxDepth(root.right);
        return 1 + (x>y ? x : y);
        
    }
}