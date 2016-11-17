

public class Main {
	
	//Solution 1: Hash Table, time Complexity: O(n)
	static boolean isPermutationOfPalindrome_hashTable(String phrase)
	{
		int[] hashTable = new int[128];
		int oddCount = 0;
		for(int i = 0; i < phrase.length(); i++)
		{
			int count = ++hashTable[Character.getNumericValue(phrase.charAt(i))];
			if(count % 2 == 1)
				oddCount++;
			else
				oddCount--;
		}
		
		if(oddCount > 1)
			return false;
		
		return true;
	}
	
	//Solution 2: Use Bit Vector, time Complexity: O(n)
	static boolean isPermutationOfPalindrome_bitVector(String phrase)
	{
		int bitVector = 0;
		for(int i = 0; i < phrase.length(); i++)
		{
			int index = phrase.charAt(i) - 'a';
			bitVector = toggle(bitVector, index);
		}
		return bitVector == 0 || checkExactlyOneBit(bitVector);
	}
	
	static int toggle(int bitVector, int index)
	{
		if(index < 1)
			return bitVector;
		int mask = 1 << index;
		if((bitVector & mask) == 0)
			bitVector |= mask;
		else
			bitVector &= ~mask;
		return bitVector;
	}
	
	static boolean checkExactlyOneBit(int bitVector)
	{
		return (bitVector & (bitVector-1)) == 0;
	}
	
	public static void main(String[] args) {
		String a = "tactcoa"; //tacocat, atcocta
		String b = "apokl"; 
		System.out.println(isPermutationOfPalindrome_hashTable(a)); //true
		System.out.println(isPermutationOfPalindrome_hashTable(b)); //false
		
		System.out.println(isPermutationOfPalindrome_bitVector(a)); //true
		System.out.println(isPermutationOfPalindrome_bitVector(b)); //false
	}

}
