import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	//Test case 1: "aaabccddd"   ->  "abd"
	//Test case 2: "aa"  -> "Empty String"
	//Test case 3: "baab" -> "Empty String"

    static String super_reduced_string(String s){
        if(s == null || s.length() == 0)
            return "Empty String";
        StringBuilder builder = new StringBuilder();
        int countConsecutive = 0;
        for(int i = 0; i < s.length(); ++i)
        {
            ++countConsecutive;
            if(i+1 >= s.length() || s.charAt(i) != s.charAt(i+1))
            {
                countConsecutive %= 2;
                if(countConsecutive != 0)
                {
                    int lastIndex = builder.length() - 1;
                    if(builder.length() == 0 || builder.charAt(lastIndex) != s.charAt(i))
                    {
                        builder.append(s.charAt(i));
                    }
                    else
                        builder.deleteCharAt(lastIndex);
                    countConsecutive = 0;
                }
            }
        }
        String result = builder.toString();
        if(result.equals(""))
            return "Empty String";
        else
            return result;
    }

    public static void main(String[] args) {
        String result = super_reduced_string("aaabccddd");
        System.out.println(result);
        result = super_reduced_string("aa");
        System.out.println(result);
        result = super_reduced_string("baab");
        System.out.println(result);
    }
}


	
	
	/*
Steve has a string, , consisting of  lowercase English alphabetic letters. In one operation, he can delete any pair of adjacent letters with same value. For example, string "aabcc" would become either "aab" or "bcc" after operation.

Steve wants to reduce  as much as possible. To do this, he will repeat the above operation as many times as it can be performed. Help Steve out by finding and printing 's non-reducible form!

Note: If the final string is empty, print Empty String .

Input Format

A single string, .

Constraints


Output Format

If the final string is empty, print Empty String; otherwise, print the final non-reducible string.

Sample Input 0

aaabccddd
Sample Output 0

abd
Sample Case 0

Steve can perform the following sequence of operations to get the final string:

aaabccddd → abccddd
abccddd → abddd
abddd → abd
Thus, we print abd.

Sample Input 1

baab
Sample Output 1

Empty String
Explanation 1

Steve can perform the following sequence of operations to get the final string:

baab → bb
bb → Empty String
Thus, we print Empty String.

Sample Input 2

aa
Sample Output 2

Empty String
Explanation 2

Steve can perform the following sequence of operations to get the final string:

aa → Empty String
Thus, we print Empty String.
	 */


