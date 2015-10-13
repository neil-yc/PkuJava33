/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution104 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public int maxDepth2(TreeNode root) {
		int a = 0;
		for (TreeNode node=root; node==null; node=node.right) {
			int b = 0;
			while (node.left != null) {
				node = node.left;
				b++;
			}
		}
		return 0;
	}

	int a = 0;
	int b = 0;
	public int maxDepth(TreeNode root) {
		if (root==null) return 0;
		else {
			int x,y;
			x = y = 0;

			if (root.left != null) {
				x = maxDepth(root.left);
			}

			if (root.right != null) {
				y = maxDepth(root.right);
			}

			return 1 + Math.max(x,y);
		}
	}

	public static void yn(TreeNode root) {
		if (root == null) System.out.println("null");
		else System.out.println("ful");
	}

	TreeNode a = new TreeNode(1);

	public static void main(String[] args) {
		//System.out.println(a);
		yn(a);
	}
}