package reflektion_ParallelServer;

import java.util.Arrays;
import java.util.Collections;

public class Main {

	/**
	chitrak.ojha@reflektion.com 


	Given a number of tasks (T) and servers (S), find out if the tasks can be accommodated on the servers. Each Task has a number of Units and each server has a number of Slots on which Units can run. 

	The only condition is that two Units of the same Task "cannot" run on the same Server. 

	Servers
	S[0] = "SS1", "SS2", "SS3", SS4 //Slots   4 -> 3 -> 2 -> 1  -> 0
	S[1] = "SS1", "SS2"                    // 2 -> 1 -> 0 -> false
	S[2] = "SS1", "SS2", SS3, SS4, SS5     // 5 -> 4 -> 3 -> 2  -> 1
	S[3] = "SS1", "SS2", SS3, SS4, SS5     // 5 -> 4 -> 3 -> 2  -> 1
	Example:
	S[0] = 4
	S[1] = 3 
	S[2] = 5
	S[3] = 5
	...

	Tasks
	T[0] = U0, U1, U2, U3   //Tasks
	T[1] = U0, U1, 
	T[2] = U0, U1, U2
	...


	Example:

	T[0] = 4
	T[1] = 2
	T[2] = 3 

	CanRunTasks(S, T) bool
	*/

	public static Boolean checkParallel(Integer[] T, Integer[] S)
	{
	    for(int i = 0; i < T.length; i++)
	    {
	    	if(S.length < T[i] || !decrement(S, T[i]))
	    		return false;
	    	
	    }
	    return true;
	}
	
	public static Boolean decrement(Integer[] S, int a)
	{
		for(int i = 0; i < S.length; i++)
		{
			if(S[i] > 0)
			{
				S[i]--;
				a--;
			}
			
			if(a == 0)
				return true;
		}
		
		return false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer S[] = {2, 1, 2};
		Integer T[] = {3, 2, 1};
		System.out.println(checkParallel(T, S));
		S = new Integer[] {2, 1, 2};
		T = new Integer[] {3, 2};
		System.out.println(checkParallel(T, S));
		
		S = new Integer[] {2, 1, 2};
		T = new Integer[] {3, 2};
		System.out.println(checkParallel(T, S));
//		Example:
//			S[0] = 4
//			S[1] = 3 
//			S[2] = 5
//			S[3] = 5
//			...
//
//			Tasks
//			T[0] = U0, U1, U2, U3   //Tasks
//			T[1] = U0, U1, 
//			T[2] = U0, U1, U2
//			...
//
//
//			Example:
//
//			T[0] = 4
//			T[1] = 2
//			T[2] = 3 
	}

}
