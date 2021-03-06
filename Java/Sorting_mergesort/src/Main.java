import java.util.*;

public class Main {
	static void mergesort(int[] array)
	{
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length-1);
	}
	
	static void mergesort(int[] array, int[] helper, int low, int high)
	{
		if(low < high)
		{
			int middle = (low+high) / 2;
			mergesort(array, helper, low, middle); //Sort left half
			mergesort(array, helper, middle +1, high);//Sort right half
			merge(array, helper, low, middle, high);
		}
	}
	
	static void merge(int[] array, int[] helper, int low, int middle, int high)
	{
		for(int i = low; i <= high; i++)
		{
			helper[i] = array[i];
		}
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		while(helperLeft <= middle && helperRight <= high)
		{
			if(helper[helperLeft] <= helper[helperRight])
			{
				array[current] = helper[helperLeft];
				helperLeft++;
			}
			else
			{
				array[current] = helper[helperRight];
				helperRight ++;
			}
			current++;
		}
		
		int remaining = middle - helperLeft;
		for(int i = 0; i <= remaining; i++)
		{
			array[current+i] = helper[helperLeft + i];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4, 1, 523, 49, 9, 101, 12, 3};
		print(a);
		mergesort(a);
		print(a);
	}
	
	static void print(int[] a)
	{
		for(int i=0; i<a.length; i++)
		{
			System.out.print(a[i] + "  ");
		}
		System.out.println();
	}
}
