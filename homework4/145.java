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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //存放父节点
		Stack<TreeNode> stack = new Stack<>();
		//存放子节点
		Stack<TreeNode> stack2 = new Stack<>();
		// 父节点存储
// 		TreeNode top;
		// 防止空节点
		if (root == null) {
			return res;
		}
		// 防止一个独立节点
		if (root != null && root.left == null && root.right == null) {
			res.add(root.val);
			return res;
		}
		while (true) {
            //当两个子节点都已经输出后，输出父节点
			if (root.right != null && stack2.size() > 0
					&& stack2.contains(root.right)) {
				res.add(root.val);
				if (stack.size() == 0) {
				// 	res.add(root.val);
					return res;
				}
				stack2.add(root);
				root = stack.pop();
				continue;
			} else if (root.left != null && root.right == null
					&& stack2.size() > 0 && stack2.contains(root.left)) {
				// 当两个子节点都已经输出后，只有左子树的情况
				res.add(root.val);
				if (stack.size() == 0) {
					return res;
				}
				stack2.add(root);
				root = stack.pop();
				continue;
			} else if (root.left != null && root.right != null
					&& stack2.size() > 0 && stack2.contains(root.left)) {
			    //左子树全部遍历完，开始遍历右子树
				stack.push(root);
				root = root.right;
				continue;
			} else {
			    //子节点还没有遍历完，遍历子节点
				if (root.left != null) {
					stack.push(root);
					root = root.left;
					continue;
				} else if (root.right != null) {
					stack.push(root);
					root = root.right;
					continue;
				} else {
					res.add(root.val);
				// 	if (stack.size() == 0) {
				//     	return res;
				//     }
					stack2.add(root);
					// if(stack.size()>0){
					root = stack.pop();

				}
			}

		}
    }
}