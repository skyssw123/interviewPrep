import java.util.*;

public class Main {
	//Q. Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
	// (e.g, if you have a tree with depth D, you will have D linked lists)

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root)
	{
		if(root == null)
			return null;
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		current.add(root); //enqueue
		while(current.size() > 0)
		{
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for(TreeNode parent : parents)
			{
				if(parent.left != null)
					current.add(parent.left);
				if(parent.right != null)
					current.add(parent.right);
			}
		}
		
		return result;
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
		
		ArrayList<LinkedList<TreeNode>> result = createLevelLinkedList(a);
		int i = 0;
		for(LinkedList<TreeNode> depthList : result)
		{
			System.out.println(i + " level Linked list:");
			for(TreeNode eachNode : depthList)
			{
				System.out.println(eachNode.value);
			}
			i++;
		}
		
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
