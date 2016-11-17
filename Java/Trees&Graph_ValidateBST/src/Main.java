import java.util.*;


public class Main {
	//Q. Implement a function to check if a binary tree is a binary search tree.
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(12);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(8);
		TreeNode f = new TreeNode(11);
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
		//         1  8  11  13
		
		System.out.println(checkBST(a)); //Expected : true
		c.value = 10;
		System.out.println(checkBST(a)); //Expected : false
		
		
		c.value = 11;
		System.out.println(checkBST_inOrder(a)); //Expected : true
		c.value = 10;
		System.out.println(checkBST_inOrder(a)); //Expected : false
	}
	
	//Solution 1, using min and max
	public static boolean checkBST(TreeNode n)
	{
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean checkBST(TreeNode n, int min, int max)
	{
		if(n == null)
			return true;
		
		if(n.value < min || n.value > max)
			return false;
		
		if(!checkBST(n.left, min, n.value))
			return false;
		
		if(!checkBST(n.right, n.value, max))
			return false;
		
		return true;
	}
	
	static //Solution 2, in-order
	int prev = 0;
	public static boolean checkBST_inOrder(TreeNode n)
	{
		if(n == null)
			return true;
		
		if(!checkBST_inOrder(n.left))
			return false;
		
		if(n.value < prev)
			return false;
		prev = n.value;
		
		if(!checkBST_inOrder(n.right))
			return false;
		
		return true;
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
