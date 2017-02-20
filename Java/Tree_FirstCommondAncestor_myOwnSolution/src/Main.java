// This solution does not work on disconnected Tree. Please read pg 261
public class Main {
	public static class TreeNode
	{
		TreeNode left = null;
		TreeNode right = null;
		int value = 0;
		
		public TreeNode(int value)
		{
			this.value = value;
		}
	}
	
	public static TreeNode firstCommonAncestor(TreeNode root, TreeNode a, TreeNode b)
	{
		if(root == null)
			return null;
		if(root == a && root == b)
			return root;
		
		TreeNode left = firstCommonAncestor(root.left, a, b);
		if(left != null && left != a && left != b)
			return left; //Already found the common ancestor!
		
		TreeNode right = firstCommonAncestor(root.right, a, b);
		if(right != null && right != a && right != b)
			return right; //Already found the common ancestor!
		
		if(root == a || root == b)
			return root;
		
		if(left != null && right != null) // if( (k != null && (k == a || k == b)) 
		{						   //    && (p != null && (p == a || p == b)))
			return root; //This will be the common ancestor
		}
		
		// this is the case where ( (k != null && (k == a || k == b)) 
		//    or (p != null && (p == a || p == b)))     not both of them..
		// If not, return null.
		return (left != null)? left:right; //return non-null value
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(12);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(8);
		TreeNode f = new TreeNode(10);
		TreeNode g = new TreeNode(13);
		TreeNode p = new TreeNode(-1); // unconnected TreeNode.
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
		
		TreeNode commonAncestor = firstCommonAncestor(a, d, f);// 1, 10
		System.out.println(commonAncestor.value); // expected outcome : 9
		commonAncestor = firstCommonAncestor(a, d, b);// 1, 5
		System.out.println(commonAncestor.value); // expected outcome: 5
		commonAncestor = firstCommonAncestor(a, g, g);// 13, 13
		System.out.println(commonAncestor.value); // expected outcome: 13
		commonAncestor = firstCommonAncestor(a, g, p);// 13, 13
		System.out.println(commonAncestor.value); // expected outcome: null
												 // So this is bug.. 
									 // The code is only for connected tree
	}
}
