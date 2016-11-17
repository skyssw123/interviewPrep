
public class Main {

	//Scan first to get the number of spaces.
	//Scan again to update characters from the end of the string to the first letter of the string.
	static void replaceSpaces(char[] str, int trueLength)
	{
		int index, numSpace = 0;
		for(int i = 0; i < trueLength; i++)
		{
			if(str[i] == ' ')
				numSpace++;
		}
		index = trueLength + numSpace * 2;
		str[trueLength] = '\0'; //End of String..
		for(int i = trueLength-1; i >= 0 ; i--)
		{
			if(str[i] == ' ')
			{
				str[index-1] = '0';
				str[index-2] = '2';
				str[index-3] = '%';
				index = index - 3;
			}
			
			else
			{
				str[index-1] = str[i];
				index--;
			}
		}
	}
	
	public static void main(String[] args) {
		String a = "Mr John Smith    "; //Expected Outcome: "Mr%20John%20Smith"
		char[] array = a.toCharArray();
		replaceSpaces(array, 13);
		System.out.println(array);
	}
}
