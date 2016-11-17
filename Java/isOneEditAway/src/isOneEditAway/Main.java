package isOneEditAway;

public class Main {
	
	//Solution 1: use while loop, time Complexity: O(n)
	static boolean oneEditAway(String first, String second)
	{
		if(Math.abs(first.length() - second.length()) > 1)
			return false;
		String shorterString = first.length() < second.length() ? first : second;
		String longerString = first.length() < second.length() ? second : first;
		int indexShorter = 0;
		int indexLonger = 0;
		boolean foundDifference = false;
		while(indexShorter < shorterString.length() && indexLonger < longerString.length())
		{
			if(shorterString.charAt(indexShorter) != longerString.charAt(indexLonger))
			{
				if(foundDifference)
					return false;
				foundDifference = true;
				if(shorterString.length() == longerString.length()) // In case of replace..
					indexShorter++;
			}
			
			else
				indexShorter++;
			
			indexLonger ++;
		}
		return true;
	}
	
	//My Solution (Don't use this solution): Hash Table, time Complexity: O(n)
	static boolean oneEditAway_mySolution(String first, String second)
	{
		if(Math.abs(first.length() - second.length()) > 1)
			return false;
		
		int[] hashTable = new int[128];
		for(int i = 0; i < first.length(); i++)
			hashTable[first.charAt(i)] ++;
		for(int i = 0; i < second.length(); i++)
			hashTable[second.charAt(i)] --;
		
		boolean foundDifference = false;
		//We should not iterate through all elements in hash tables..
		String longerString = first.length() > second.length() ? first : second;
		for(int i = 0; i < longerString.length(); i++)
		{
			if(Math.abs(hashTable[longerString.charAt(i)]) == 1)
			{
				if(foundDifference)
					return false;
				
				foundDifference = true;
			}
			else if(hashTable[i] > 1)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String a = "pale";
		String b = "ple";
		String c = "pales";
		String d = "bale";
		String e = "bake";
		System.out.println(oneEditAway(a, b)); //true
		System.out.println(oneEditAway(a, c)); //true
		System.out.println(oneEditAway(a, d)); //true
		System.out.println(oneEditAway(a, e)); //false
		
		System.out.println(oneEditAway_mySolution(a, b)); //true
		System.out.println(oneEditAway_mySolution(a, c)); //true
		System.out.println(oneEditAway_mySolution(a, d)); //true
		System.out.println(oneEditAway_mySolution(a, e)); //false
	}

}
