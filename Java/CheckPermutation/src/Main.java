

public class Main {
	
	//Time Complexity: O(nlog(n))
	static boolean isPermutation(String a, String b)
	{
		if(a.length() != b.length())
			return false;
		
		return sort(a).equals(sort(b));
	}
	
	static String sort(String a)
	{
		char[] char_array = a.toCharArray();
		java.util.Arrays.sort(char_array);
		return new String(char_array);
	}
	
	//Time Complexity : O(n) but uses more space (Hash Table)
	static boolean isPermutation_Opt(String a, String b)
	{
		if(a.length() != b.length())
			return false;
		int[] letters = new int[128]; //Assume input string uses ASCCI code
		for(int i = 0; i < a.length(); i++)
		{
			letters[a.charAt(i)] ++;
		}
		
		for(int i = 0; i < b.length(); i++)
		{
			letters[b.charAt(i)]--;
			if(letters[b.charAt(i)] < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String a = "abcde";
		String b = "fefde";
		String c = "cedba";
		System.out.println(isPermutation(a,b)); //false
		System.out.println(isPermutation(b,c)); //false
		System.out.println(isPermutation(a,c)); //true
		
		System.out.println(isPermutation_Opt(a,b)); //false
		System.out.println(isPermutation_Opt(b,c)); //false
		System.out.println(isPermutation_Opt(a,c)); //true
	}

}
