import java.util.*;
public class Main {
	public static class ExampleClass
	{
		int[] a = new int[10];
		ArrayList<Integer> p = new ArrayList<Integer> ();
		int b;
		public ExampleClass(Integer a)
		{
			this.b = a;
		}
	}

	public static void main(String[] args) {
		System.out.println("PRACTICE"); 
		ExampleClass a = new ExampleClass(3);
		
		helloWorld(a.p);
		helloWorld(a.a);
		
		Iterator<Integer> iterator = a.p.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println();
		
		Iterator<Integer> iterator2 = Arrays.stream(a.a).iterator();
		while(iterator2.hasNext())
		{
			System.out.println(iterator2.next());
		}
		
		System.out.println();
		
		int k = 15; // 1111
		System.out.println(k & (1<<0)); // 1
		System.out.println(k & (1<<1)); // 2
		System.out.println(k & (1<<2)); // 4
		System.out.println(k & (1<<3)); // 8
	}
	
	public static void helloWorld(ArrayList<Integer> a)
	{
		a.add(1);
		a.add(2);
	}
	
	public static void helloWorld(int[] a)
	{
		a[0] = 1;
	}
}