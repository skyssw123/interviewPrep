// 1 -> one
// 2 -> two
// 123 -> one hundred twenty three
// 189099 -> one hundred eighty nine thousand ninety nine

// 999,999,999  : maximum input
// Nine Hundred Ninety Nine Million,
// Nine Hundred Ninety Nine thousand,
// Nine Hundred Ninety Nine
    

/* package whatever; // don't place package name! */

import java.io.*;
import java.util.*;

public class Main
{
    public static String convert(int number)
    {
        /// 000 -> thousand
        /// 00  -> hundred
        if(number < 0)
            return "";
        Hashtable<Integer, String> table = new Hashtable<Integer, String>();
        
        
        table.put(0, "");
        table.put(1, "one");
        table.put(2, "two");
        table.put(3, "three");
        table.put(4, "four");
        table.put(5, "five");
        table.put(6, "six");
        table.put(7, "seven");
        table.put(8, "eight");
        table.put(9, "nine");
        table.put(10, "ten");
        table.put(11, "eleven");
        table.put(12, "twelve");
        table.put(13, "thirteen");
        table.put(14, "fourteen");
        table.put(15, "fifteen");
        table.put(16, "sixteen");
        table.put(17, "seventeen");
        table.put(18, "eighteen");
        table.put(19, "nineteen");
        
        table.put(20, "twenty");
        table.put(30, "thirty");
        table.put(40, "forty");
        table.put(50, "fifty");
        table.put(60, "sixty");
        table.put(70, "seventy");
        table.put(80, "eighty");
        table.put(90, "ninety");
        
        String stringNum = String.valueOf(number);
        int length = stringNum.length();
        
        
        String result = "";
     // 999,999,999  : maximum input
     // Nine Hundred Ninety Nine Million,
     // Nine Hundred Ninety Nine thousand,
     // Nine Hundred Ninety Nine
        int count = 0;
        int countThousand = 0;
        boolean isThousandPrinted = false;
        for(int i = 0; i < length; i++)
        {
        	char charDigit = stringNum.charAt(length-i-1);
        	int intDigit = Character.getNumericValue(charDigit);
        	
        	if(countThousand == 1)
        	{
        		if(isThousandPrinted == false)
        		{
        			result = "thousand " + result;
        			isThousandPrinted = true;
        		}
        		else
        			result = "million " + result;
        		countThousand = 0 ;
        	}
        	
        	if(count == 0 && i+1 < length && Character.getNumericValue(stringNum.charAt(length-i-2)) == 1 )
        	{
        		char charDigit2 = stringNum.charAt(length-i-2);
            	intDigit = Character.getNumericValue(charDigit+charDigit2);
        		result = table.get(intDigit) + " " + result;
        		count ++;
        		i ++;
        	}
        	
        	else if(count == 0)
        		result = table.get(intDigit) + " " + result;

        	else if(count == 1)
        		result = table.get(intDigit * 10) + " " + result;
        	
        	else if(count == 2)
        		result = table.get(intDigit) + " hundred " + result;
        	
        	count ++;
        	if(count == 3)
        	{
        		count = 0;
        		countThousand ++;
        	}
        }
        return result;
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(convert(99));
        System.out.println(convert(18));
        System.out.println(convert(76));
        System.out.println(convert(999));
        System.out.println(convert(812));
        
        System.out.println(convert(999999));
        System.out.println(convert(999912));
        
        System.out.println(convert(912911912));
        System.out.println(convert(912923912));
    }
}

