package getAdjancetFromMatrix;
import java.io.*;
import java.util.*;

// HashSet add/contains function calls hashCode() first and if it is not empty,
// add/contains function checks if the new element equals the existing elements..
// For add, it will add if the new element is not present in the HashSet..

// hashCode for coordinates in Matrix = 31 * row + column
public class Main{
  static class Pair extends Object {
    public int row;
    public int column;
 
    Pair (int a, int b)
    {
      this.row = a;
      this.column = b;
    }
    
    @Override
    public boolean equals(Object a)
    {
    	if(!(a instanceof Pair))
    		return false;
    	Pair pair = (Pair)a;
    	if(this.row == pair.row && this.column == pair.column)
    		return true;
    	return false;
    }
    
    @Override
    public int hashCode(){
    	int hashCode = 0;//31 * this.row + this.column;
    	return hashCode;
    }
  }
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();

    for (String string : strings) {
      System.out.println(string);
    }
    
    int[][] a = new int[5][5];
    a[0][1] = 1; 
    a[0][2] = 1;
    a[1][0] = 1;
    a[1][1] = 1;
    a[1][2] = 1;
    a[2][1] = 1;
    
    
    HashSet<Pair> result = new HashSet<Pair>();
    result = getAdjacent(a, new Pair(1,1), result);
    
    printPairs(result);
  }
  
  public static void printPairs(HashSet<Pair> result)
  {
    for(Pair pair: result)
    {
      System.out.print(pair.row + ", " + pair.column);
      System.out.println();
    }
  }
  
  public static void printMatrix(int[][] matrix)
  {
    if(matrix.length == 0 || matrix[0].length == 0)
      return ;
    
    for(int i = 0; i < matrix.length ; i++)
    {
      for (int j = 0; j < matrix[0].length; j++)
      {
        System.out.print(matrix[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
  
  public static HashSet<Pair> getAdjacent(int[][] matrix, Pair pair, HashSet<Pair> result)
  {
    if(matrix.length == 0 || matrix[0].length == 0)
      return null;
    
    int value = matrix[pair.row][pair.column];
    
    int left = -1;
    int right = -1;
    int top = -1;
    int bottom = -1;
    
    Pair leftPair = new Pair(pair.row, pair.column - 1);
    Pair rightPair = new Pair(pair.row, pair.column + 1);
    Pair topPair = new Pair(pair.row + 1, pair.column);
    Pair bottomPair = new Pair(pair.row -1, pair.column);
    
    if(leftPair.column >= 0 && !result.contains(leftPair))
      left = matrix[leftPair.row][leftPair.column];
    
    if(rightPair.column < matrix[0].length && !result.contains(rightPair))
      right = matrix[rightPair.row][rightPair.column];
    
    if(topPair.row < matrix.length && !result.contains(topPair))
      top = matrix[topPair.row][topPair.column];
    
    if(bottomPair.row >= 0 && !result.contains(bottomPair))
      bottom = matrix[bottomPair.row][bottomPair.column];
    
    if(left == value)
    {
      result.add(leftPair);
      result = getAdjacent(matrix, leftPair, result);
    }
    
    if(right == value)
    {
      result.add(rightPair);
      result = getAdjacent(matrix, rightPair, result);
    }
    
    if(top == value)
    {
      result.add(topPair);
      result = getAdjacent(matrix, topPair, result);
    }
    
    if(bottom == value)
    {
      result.add(bottomPair);
      result = getAdjacent(matrix, bottomPair, result);
    }
    
    return result;
  }
}
