/*

*/
import java.util.*;

public class Solution111 {
	public class TreeNode {
	    int val;
    	TreeNode left;
	    TreeNode right;
    	TreeNode(int x) { val = x; }
	}

    /*public int minDepth(TreeNode root) {
		if (root == null) return 0;
		else {
			if (root.right!=null && root.left!=null) return (minDepth(root.left)<minDepth(root.right))?minDepth(root.left)+1:minDepth(root.right)+1;
			else if (root.left==null) return minDepth(root.right)+1;
			else return minDepth(root.left)+1;
		}
	}*/

public int minDepth(TreeNode root) {
	if(root==null) return 0;
	else {
	 	if(root.left==null && root.right==null) return 1;
	 	int num1 = minDepth(root.left);
	 	int num2 = minDepth(root.right);
	 	int num = 0;
	 	if(num1==0) return num = num2+1;
	 	if(num2==0) return num = num1+1;
	 	num=(num1<=num2?num1:num2)+1;
	 	return num;
 	}
	}
/*
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		else {
			Stack temp = new Stack();
			TreeNode p = root;
			if (p.left!=null) {
				temp.push(p);
				p = p.left;
			}
			else if (p.right!=null) {
				temp.push(p);
				p = p.right;
			}
		}
		return 0;
	}
*/
   public static void main(String[] args) {
    	System.out.println(0);
    }
}