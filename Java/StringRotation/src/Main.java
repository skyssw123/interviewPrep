
public class Main {

	static boolean isSubstring(String s1, String s2)
	{
		if(s1.length() < s2.length() || s1.length() <=0 || s2.length() <= 0)
			return false;
		int j = 0;
		boolean match = false;
		for(int i = 0; i < s1.length(); i++)
		{
			if(s1.charAt(i) == s2.charAt(j))
			{
				match = true;
				j++;
				if(j == s2.length())
					return true;
			}
			
			else if(match && s1.charAt(i) != s2.charAt(j))
			{
				j = 0;
				i--;
				match = false;
			}
		}
		
		return false;
	}
	static boolean isRotation(String s1, String s2)
	{
		int n = s1.length();
		if(n != s2.length() || n <= 0)
			return false;
		
		String s1s1 = s1 + s1;
		return isSubstring(s1s1, s2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcde";
		String b = "bcdea";
		System.out.println(isRotation(a,b));
	}

}
