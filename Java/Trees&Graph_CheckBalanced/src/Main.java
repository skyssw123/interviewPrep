import java.util.*;

public class Main {
	//Q. Implement a function to check if a binary tree is balanced.
	//   For the purposes of this question, a balanced tree is defined to be a tree
	//   such that the heights of the two subtrees of any node never differ by more than one.
	
	static int checkHeight(TreeNode root)
	{
		if(root == null)
			return -1;
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		if(Math.abs(leftHeight - rightHeight) > 1)
			return Integer.MIN_VALUE;
		
		return (Math.max(leftHeight, rightHeight) + 1);
	}
	
	static boolean isBalanced(TreeNode root)
	{
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(12);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(8);
		TreeNode f = new TreeNode(10);
		TreeNode g = new TreeNode(13);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		d.left = null;
		d.right = null;
		e.left = null;
		e.right = null;
		f.left = null;
		f.right = null;
		g.left = null;
		g.right = null;
		//  Binary Tree:
		//              9
		//           5     12
		//         1  8  10  13
		
		System.out.println(isBalanced(a)); //Expected : True
		a.right = null;
		System.out.println(isBalanced(a)); //Expected : False
	}
	
	//In-order print function
	public static void print(TreeNode a)
	{
		if(a == null)
			return;
		if(a.left != null)
			print(a.left);
				
		System.out.println(a.value);
				
		if(a.right != null)
			print(a.right);
	}
			
	public static class TreeNode
	{
		int value;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int value)
		{
			this.value = value;
		}
	}
}
