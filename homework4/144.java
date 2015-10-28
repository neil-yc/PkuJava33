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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
//		TreeNode leftNode = root.left;
//		TreeNode rightNode = root.right;
		//父节点存储
		if(root == null){
		    return res;
		}
		TreeNode top;
		while(true){
			res.add(root.val);
//			stack.push(root);
			if(root.left!=null){
				//只有左右都不为空才压入栈内
				if(root.right != null){
					stack.push(root);
				}
				root = root.left;
//				res.add(root.left.val);
//				stack.push(root.left);
				
				continue;
			}else if(root.right!=null){
				root = root.right;
				continue;
			}else{
				if(!stack.empty()){
					top = stack.pop();
					root = top.right;
				}else{
					return res;
				}
			}
		}
        
    }
}