import java.util.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer> ();
		a.add(9);
		a.add(8);
		a.add(-3);
		a.add(6);
		NewIterator<Integer> newIterator = new NewIterator<Integer> (a.iterator());
		
		//ArrayList contains [9, 8, -3, 6]
		System.out.println(newIterator.peak());  //Expected Outcome : null
		System.out.println(newIterator.next());  //Expected Outcome : 9
		System.out.println(newIterator.next());  //Expected Outcome : 8
		System.out.println(newIterator.peak());  //Expected Outcome : 8
		System.out.println(newIterator.hasNext()); //Expected Outcome : true
		System.out.println(newIterator.peak()); //Expected Outcome : -3
		System.out.println(newIterator.hasNext()); //Expected Outcome : true
		System.out.println(newIterator.peak()); //Expected Outcome : 6
		System.out.println(newIterator.hasNext()); //Expected Outcome : false
		System.out.println(newIterator.peak()); //Expected Outcome : null
	}

}
