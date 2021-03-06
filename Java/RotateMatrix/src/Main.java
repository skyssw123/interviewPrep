

public class Main {
	 
	static void print(int[][] matrix)
	{
		for(int i = 0 ; i < matrix.length ; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j] + "        ");
			}
			System.out.print("\n");
		}
	}
	
	static void makeMatrix(int[][] matrix)
	{
		int count = 0;
		for(int i = 0 ; i < matrix.length ; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				count++;
				matrix[i][j] = count; 
			}
		}
	}
	
	//Solution 1
	static boolean rotate(int[][] matrix)
	{
		if(matrix.length != matrix[0].length)
			return false;
		int n = matrix.length;
		for(int layer = 0 ; layer < n/2 ; layer++)
		{
			int first = layer;
			int last = n - 1 - layer; 
			for(int i = first ; i < last; i++)
			{
				int offset = i - first;
				int top = matrix[first][i]; // save Top
				matrix[first][i] = matrix[last-offset][first]; // left -> top
				matrix[last-offset][first] = matrix[last][last-offset]; // bottom -> left
				matrix[last][last-offset] = matrix[i][last]; // right -> bottom
				matrix[i][last] = top;
			}
		}
		
		return true;
	}	
	
	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		makeMatrix(matrix);
		print(matrix);
		System.out.println();
		System.out.println();
		rotate(matrix);
		print(matrix);
	}

}
