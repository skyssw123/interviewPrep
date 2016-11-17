
public class Main {
	//Q. Find the largest and smallest # in a list. THe list is sorted as two sections,
	//   one in ascending order and the other in descending order
	//    input: {2, 3, 4, 5, 6, 7, 10, 9, 8, 7}
	//      output: 2, 10
	
	public static int findBiggest(int[] a)
	{
		int low = 0 ;
		int high = a.length - 1;
		while(low <= high)
		{
			int mid = (low + high) / 2;
			if(a[mid] > a[mid-1] && a[mid] > a[mid+1])
				return a[mid];
			else if(a[mid + 1] > a[mid])
				low = mid + 1;
			else if(a[mid + 1] < a[mid])
				high = mid - 1;
		}
		
		return -1;
	}
	
	public static int findSmallest(int[] a)
	{
		int last = a.length - 1;
		return a[0]<a[last] ? a[0]:a[last];
	}
	
	public static void main(String[] args) {
		int[] a = {2, 3, 4, 5, 6, 7, 10, 9, 8, 7};
		System.out.println(findSmallest(a)); // Expected Outcome: 2
		System.out.println(findBiggest(a));  // Expected Outcome: 10
	}
}
