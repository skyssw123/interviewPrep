public class Main {
	//Q. You are given an array-like data structure Listy which lacks a size method.
	//   It does, however, have an elementAt(i) method that returns the element at index i
	//   in O(1) time. If i is beyond the boundes of the data structure, it returns -1.
	//   (For this reason, the data structure only supports positive integers)
	//   Given a Listy which contains sorted, positive integers, find the index at which an element x occurs.
	//   If x occurs multiple times, you may return any index.
	
	// Time Complexity = O(log n)
	
	
	
	static int search(Listy list, int value)
	{
		if(list.elementAt(0) == -1)
			return -1;
		int high = 1;
		while (list.elementAt(high) != -1)
		{
			high *= 2;
		}
		
		return search(list, value, 0, high);
	}
	
	static int search(Listy list, int value, int low, int high)
	{
		while(low <= high)
		{
			int mid = (low+high) / 2;
			if(list.elementAt(mid) == value)
				return mid;
			else if(list.elementAt(mid) > value || list.elementAt(mid) == -1)
				high = mid - 1;
			else 
				low = mid + 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 11, 33, 36, 89, 91, 101, 121};
		Listy list = new Listy(a);
		System.out.println(search(list, 1));// Expected Output: 0
		System.out.println(search(list, 3));// Expected Output: 1
		System.out.println(search(list, 91));// Expected Output: 7
		System.out.println(search(list, 101)); //Expected Output: 8
		System.out.println(search(list, 121));//Expected Output: 9
	}
	
	public static class Listy
	{
		private int[] a;
		public Listy (int[] input)
		{
			a = input;
		}
		public int elementAt(int i)
		{
			if(a.length-1 < i || i < 0)
				return -1;
			return a[i];
		}
	}
}
