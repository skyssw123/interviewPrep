
public class Main {
	//Q. Given a sorted array of strings that is interspersed with empty strings, 
			//   write a method to find the location of a given string.
			//   For ex,
			//          input: "ball", {"at","","","","ball","","","car","dad","",""}
			//			output: 4
			// Time Complexity : O(log n)
	
	public static int search(String[] strings, String str, int first, int last)
	{
		while(first <= last)
		{
			int mid = (first + last) / 2;
			
			if(strings[mid].isEmpty())
			{
				int i = mid + 1,j = mid - 1;
				while(true)
				{
					if(j < first && i > last)
						return -1;
					
					if(!strings[i].isEmpty() && i <= last)
					{
						mid = i;
						break;
					}
					
					else if(!strings[j].isEmpty() && j >= first)
					{
						mid = j;
						break;
					}
					i ++; j --;
				}
			}
			
			if(str.equals(strings[mid]))
			{
				return mid;
			}
			
			else if(strings[mid].compareTo(str) < 0)    //strings[mid] < str 
			{
				first = mid + 1;
			}
			
			else
			{
				last = mid - 1;
			}
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		String[] strings = {"at","","","","ball","","","car","dad","",""};
		System.out.println(search(strings, "ball", 0, 10));  // Expected Output: 4
		System.out.println(search(strings, "dad", 0, 10));   // Expected Output: 8
		System.out.println(search(strings, "at", 0, 10));   // Expected Output: 0
		System.out.println(search(strings, "car", 0, 10));   // Expected Output: 7 
		System.out.println(search(strings, "asas", 0, 10));   // Expected Output: -1
		System.out.println(search(strings, "koko", 0, 10));   // Expected Output: -1
	}

}
