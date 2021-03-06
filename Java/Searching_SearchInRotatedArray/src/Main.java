
public class Main {

	//My solution using loop
	public static int search(int[] a, int low, int high, int x)
	{
		while(low <= high)
		{
			int mid = (low + high) / 2;
			if(a[mid] == x)
				return mid;
			if(a[mid] > a[low])
			{
				if( x < a[mid] && x >= a[low])
					high = mid - 1;
				else
					low = mid + 1;
			}
			
			else if(a[mid] < a[low])
			{
				if (x > a[mid] && x <= a[high])
					low = mid + 1;
				else
					high = mid - 1;
			}
			
			else // a[mid] == a[low]
			{
				if(a[mid] != a[high])
					low = mid + 1;
				else //Should check both left and right sides
				{
					int resultLeft = search(a, low, mid - 1, x);
					if(resultLeft == -1)
						return search(a, mid+1, high, x);
					else
						return resultLeft;
				}
			}
		}
		return -1;
	}
	
	//Recursive Solution (From Manual)
	public static int recursiveSearch(int[] a, int low, int high, int x)
	{
		int mid = (low+high) / 2;
		if(a[mid] == x)
			return mid;
		if(high < low)
			return -1;
		if(a[mid] > a[low])
		{
			if(a[mid] > x && x >= a[low])
				return recursiveSearch(a, low, mid-1, x);
			else
				return recursiveSearch(a, mid+1, high, x);
		}
		
		else if(a[mid] < a[low])
		{
			if(a[mid] < x && x <= a[high])
				return recursiveSearch(a, mid+1, high, x);
			else
				return recursiveSearch(a, low, mid-1, x);
		}
		
		else if (a[mid] == a[low])
		{
			if(a[mid] != a[high])
				return recursiveSearch(a, mid+1, high, x);
			else //Search both left and right sides
			{
				int resultLeft = recursiveSearch(a, low, mid-1, x);
				if(resultLeft == -1)
				{
					return recursiveSearch(a, mid+1, high, x);
				}
				else
					return resultLeft;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		//Q. Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array.
		//   You may assume that the array was originally sorted in increasing order.
		
		int[] array = {15,16,19,20,25,1,3,4,5,7,10,14};
		int[] array2 = {2,2,2,2,3,3,1};
		int[] array3 = {2,2,2,2,1,2,2};
		int[] array4 = {2,2,3,2,2,2,2};
		
		System.out.println(search(array, 0, array.length - 1, 5)); // Expected output: 8
		System.out.println(search(array, 0, array.length - 1, 19)); // Expected output: 2
		System.out.println(search(array2, 0, array2.length - 1, 1)); // Expected output: 6
		System.out.println(search(array2, 0, array2.length - 1, 3)); // Expected output: 5 or 4
		System.out.println(search(array3, 0, array3.length - 1, 1)); // Expected output: 4
		System.out.println(search(array4, 0, array4.length - 1, 3)); // Expected output: 2
		
		System.out.println();
		System.out.println();
		
		System.out.println(recursiveSearch(array, 0, array.length - 1, 5)); // Expected output: 8
		System.out.println(recursiveSearch(array, 0, array.length - 1, 19)); // Expected output: 2
		System.out.println(recursiveSearch(array2, 0, array2.length - 1, 1)); // Expected output: 6
		System.out.println(recursiveSearch(array2, 0, array2.length - 1, 3)); // Expected output: 5 or 4
		System.out.println(recursiveSearch(array3, 0, array3.length - 1, 1)); // Expected output: 4
		System.out.println(recursiveSearch(array4, 0, array4.length - 1, 3)); // Expected output: 2
	}
}
