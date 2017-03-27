import java.util.Arrays;
import java.util.*;

/**
 * Facilitates dispensing stamps for a postage stamp machine.
 */
public class StampDispenser
{
    /**
     * Constructs a new StampDispenser that will be able to dispense the given 
     * types of stamps.
     *
     * @param stampDenominations The values of the types of stamps that the 
     *     machine should have.  Should be sorted in descending order and 
     *     contain at least a 1.
     */
	Integer[] typeStamps;
	int[] numStamps;
    public StampDispenser(int[] stampDenominations)
    {
    	if(stampDenominations == null || stampDenominations.length == 0 || (stampDenominations.length == 1 && stampDenominations[0] != 1))
    		return;
    	this.typeStamps = new Integer[stampDenominations.length];
    	for(int i = 0; i < stampDenominations.length; i++)
    	{
    		this.typeStamps[i] = (Integer)stampDenominations[i];
    	}
    	
    	Arrays.sort(this.typeStamps, Collections.reverseOrder());
    	this.numStamps = new int[stampDenominations.length];
    }
 
    /**
     * Returns the minimum number of stamps that the machine can dispense to
     * fill the given request.
     *
     * @param request The total value of the stamps to be dispensed.
     */
    public int calcMinNumStampsToFillRequest(int request)
    {  
    	if(this.typeStamps == null || this.numStamps == null)
    		return -1; // -1 indicates that there is an error
    	
    	calMinNumStamps(request);
    	int sum = 0;
    	for(int num : numStamps)
    	{
    		sum += num;
    	}
    	return sum;
    }
    
    public boolean calMinNumStamps(int request)
    {
    	if(request == 0)
    		return true;
    	if(request < 0)
    		return false;
    	
    	for(int i = 0; i < typeStamps.length; i++)
    	{
    		if(calMinNumStamps(request - typeStamps[i]))
    		{
    			numStamps[i] ++;
    			return true;
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args)
    {
        int[] denominations = { 90, 30, 24, 10, 6, 2, 1 };
        StampDispenser stampDispenser = new StampDispenser(denominations);
        assert stampDispenser.calcMinNumStampsToFillRequest(18) == 3;
        
        System.out.println(stampDispenser.calcMinNumStampsToFillRequest(18));
        
        int[] denominations_2 = { 13, 29, 2, 7};
        StampDispenser stampDispenser_2 = new StampDispenser(denominations_2);
        System.out.println(stampDispenser_2.calcMinNumStampsToFillRequest(335));
        
        int[] denominations_3 = { 24, 10, 5, 1};
        StampDispenser stampDispenser_3 = new StampDispenser(denominations_3);
        System.out.println(stampDispenser_3.calcMinNumStampsToFillRequest(737));
    }
}
