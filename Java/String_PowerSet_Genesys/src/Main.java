import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abc";
		List<String> result = powerSet(input);
		Iterator<String> itr = result.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

	}
	
	public static List<String> powerSet(String a)
	{
		int powerSetSize = (int) Math.pow(2, a.length());
		ArrayList<String> result = new ArrayList<String>(powerSetSize);
		for(int counter = 0; counter < powerSetSize; counter++)
		{
			StringBuilder builder = new StringBuilder();
			for(int j = 0; j < a.length(); j ++)
			{
				if( (counter & (1<<j)) > 0)
				{
					builder.append(a.charAt(j));
				}
			}
			result.add(builder.toString());
		}
		
		return result;
	}
	/* For example,
Set  = [a,b,c]
power_set_size = pow(2, 3) = 8
Run for binary counter = 000 to 111

Value of Counter            Subset
    000   (0)                 -> Empty set
    001   (1)                 -> a
    010   (2)                 -> b
    011   (3)                 -> ab
    100   (4)                 -> c
    101   (5)                 -> ac
    110   (6)                 -> bc
    111   (7)                 -> abc
	 */
}