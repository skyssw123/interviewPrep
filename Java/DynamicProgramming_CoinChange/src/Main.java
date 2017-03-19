import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Main {
	
	//Recursive function
	public static int makeChange_recursive(int value, int[] numTypes, int index, Hashtable<String, Integer> hashtable)
	{	
		if(value == 0)
			return 1;
		
		else if(value < 0)
			return 0;
		
		int result = 0;
		
		for(int i = index; i < numTypes.length; i++)
		{
			int remaining_value = value - numTypes[i];
			result += makeChange_recursive(remaining_value, numTypes, i, hashtable);
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException{
		/* 
		 * Test Case 1:
		 * input:
		 4 3
		 1 2 3 
		 output : 4
		 
		 Test case 2:
		 input:
		 10 4
		2 5 3 6
		 output: 
		 */
		Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();
		int numTypes = scan.nextInt();
		int[] coinTypes = new int[numTypes];
		for(int i = 0; i < numTypes; i++)
		{
			coinTypes[i] = scan.nextInt();
		}
		Arrays.sort(coinTypes);
		System.out.println(makeChange_recursive(value, coinTypes, 0, new Hashtable<String, Integer>()));
	}

}
