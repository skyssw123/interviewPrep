

public class Main {
	
	//Solution 1
	static String compress(String str)
	{
		int countConsecutive = 0;
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < str.length(); i++)
		{
			countConsecutive ++;
			if((i+1) >= str.length() || str.charAt(i) != str.charAt(i+1))
			{
				stringBuilder.append(str.charAt(i));
				stringBuilder.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return str.length() <= stringBuilder.length() ? str : stringBuilder.toString();  
	}	
	
	public static void main(String[] args) {
		String a = "aaaaeeefffffcwweee"; 
		String b = "abcd"; 
		System.out.println(compress(a)); //a4e3f5c1w2e3
		System.out.println(compress(b)); //abcd 
		System.out.println();
		
		
		StringBuilder builder = new StringBuilder();
		builder.append("34");
		builder.append(" hihi");
		System.out.println(builder.length());
		System.out.println(builder.charAt(builder.length() - 1));
	}

}
