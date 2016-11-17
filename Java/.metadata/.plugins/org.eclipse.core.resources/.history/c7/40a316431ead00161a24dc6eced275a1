import java.util.Arrays;
import java.util.*;

//Q. Write a method to sort an array of strings so that all the anagrams are next to each other.
	//Soln 1. Use sorting algorithm, modify comparator
	//Time Complexity: O(nlogn)
class AnagramComparator implements Comparator<String>
{
	public String sortChars(String s)
	{
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public int compare(String s1, String s2)
	{
		return sortChars(s1).compareTo(s2);
	}
}

public class Main {
	
	//Soln 2. We dont need to fully sort the array. We should just group them. For ex, "acre" will map to list {acre,race,care}
	// This is modification of bucket sort..
	// Time Complexity: O(n)
	static void sort(String[] array)
	{
		HashMap<String, ArrayList<String>> mapList = new HashMap<String,ArrayList<String>> ();
		for(int i = 0; i < array.length; i++)
		{
			String key = sortChar(array[i]);
			if(!mapList.containsKey(key))
				mapList.put(key, new ArrayList<String> ());
			mapList.get(key).add(array[i]);
		}
		
		int index = 0;
		for(String key: mapList.keySet())
		{
			for(String stringInHashMap: mapList.get(key))
			{
				array[index] = stringInHashMap;
				index++;
			}
		}
	}
	
	static String sortChar(String a)
	{
		char[] charArray = a.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	
	static void print(String[] a)
	{
		for(String each: a)
		{
			System.out.println(each);
		}
	}
	
	public static void main(String[] args) {
		String[] array1 = {"sucre", "abc", "cba", "recus", "kp", "cuers", "erpo", "pk"};
		String[] array2 = {"sucre", "abc", "cba", "recus", "kp", "cuers", "erpo", "pk"};
		//Soln 1
		Arrays.sort(array1, new AnagramComparator());
		print(array1);
		System.out.println();
		System.out.println();
		
		//Soln 2
		sort(array2);
		print(array2);
	}
}
