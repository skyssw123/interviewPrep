
public class Main {
	// Time Complexity: O(n^2)
	static void setZeros(int[][] matrix)
	{
		if(matrix.length != matrix[0].length)
			return;
		int n = matrix.length;
		boolean[] row = new boolean[n];
		boolean[] column = new boolean[n];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(matrix[i][j] == 0)
				{
					//nullifyRow(matrix,i);     WRONG because it will make it O(n^3)
					//nullifyColumn(matrix,j);
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for(int i = 0; i < n; i++)
		{
			if(row[i])
				nullifyRow(matrix, i);
		}
		
		for(int j = 0; j < n; j++)
		{
			if(column[j])
				nullifyColumn(matrix,j);
		}
	}
	
	static void nullifyRow(int[][] matrix, int row)
	{
		for(int j = 0; j < matrix[0].length; j++)
		{
			matrix[row][j] = 0;
		}
	}
	
	static void nullifyColumn(int[][] matrix, int col)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			matrix[i][col] = 0;
		}
	}

	public static void main(String[] args) {
		int[][] a = generateMatrix();
		a[3][1] = 0; a[2][2] = 0;
		print(a);
		System.out.println("");
		System.out.println("");
		
		setZeros(a);
		
		print(a);
	}
	
	static int[][] generateMatrix()
	{
		int[][] matrix = new int[4][4];
		
		for(int i = 0; i < matrix.length ; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				matrix[i][j] = 1; 
			}
		}
		return matrix;
	}
	
	static void print(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.print('\n');
		}
	}
}
