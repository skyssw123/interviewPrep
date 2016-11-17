package isUniqueCharsInString;

public class Main {
	
	static boolean isUniqueChars(String str)
	{
		boolean[] char_set = new boolean[128]; //Assume the string uses ASCII code only
		for(int i = 0; i < str.length(); i++)
		{
			if(char_set[str.charAt(i)])
				return false;
			char_set[str.charAt(i)] = true;
		}
		return true;
	}
	
	static boolean isUniqueChars_Opt(String str)
	{
		//Assume that only lowercase letters are used for the input string. Ex, 26 letters..
		//It is possible to reduce the space by a factor of 8 if bit vector is used instead of boolean arrays.
		int checker = 0;
		for(int i = 0; i < str.length(); i++)
		{
			int val = (int)str.charAt(i) - 'a';
			if( (checker & (1<<val)) > 0)
				return false;
			checker |= 1<<val;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcdef";
		String b = "aabcde";
		System.out.println(isUniqueChars(a));
		System.out.println(isUniqueChars(b));
		System.out.println(isUniqueChars_Opt(a));
		System.out.println(isUniqueChars_Opt(b));
	}

}