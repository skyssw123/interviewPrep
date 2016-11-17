
public class Main {
	
	static TreeNode createMinimalBST(int[] array)
	{
		return createMinimalBST_Recursive(array, 0, array.length - 1);
	}
	
	//Pre order Recursive Solution
	// Dont use iterative solution in this case....
	static TreeNode createMinimalBST_Recursive(int[] array, int low, int high)
	{
		if(low > high)
			return null;
		int mid = (low+high)/2;
		TreeNode n = new TreeNode(array[mid]);
		n.left = createMinimalBST_Recursive(array, low, mid-1);
		n.right = createMinimalBST_Recursive(array, mid+1, high);
		return n;
	}
	
	
	public static void main(String[] args) {
		int[] a = {1,3,5,7,9,10}; 
		TreeNode treenode = createMinimalBST(a);
		print(treenode);
		
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
