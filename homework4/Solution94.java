/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;


public class Solution94 {

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

    public List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> lst = new ArrayList<Integer>();

		if(root == null)	return lst; 
 
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while(!stack.empty() || p != null) {
            if(p != null){
				stack.push(p);
				p = p.left;
            }

            else {
                TreeNode t = stack.pop();
                lst.add(t.val);
                p = t.right;
            }
        }
        return lst;
    }
}