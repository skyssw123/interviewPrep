
public class Main {
	//Q. You are given two sorted arrays, A and B, where A has a large enough buffer at the end 
	//   to hold B. Write a method to merge B into A in sorted order.
	
	// Tip: Try to move from the end of the arrays to the beginning..
	
	public static void sorted_merge(int[] a, int[] b, int lastA, int lastB)
	{
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int indexMerged = lastA + lastB - 1;
		while(indexB >= 0)
		{
			if(a[indexA] > b[indexB])
			{
				a[indexMerged] = a[indexA];
				indexA--;
			}
			
			else
			{
				a[indexMerged] = b[indexB];
				indexB--;
			}
			indexMerged--;
		}
	}
	
	public static void print(int[] a)
	{
		for(int b: a)
			System.out.println(b);
	}
	public static void main(String[] args) {
		int[] a = {1, 3, 4, 11, 18, 23, 27, 0, 0, 0 ,0, 0};
		int[] b = {2, 6, 13, 31, 55};
		sorted_merge(a,b,a.length - 5, b.length);
		print(a);
	}
}
