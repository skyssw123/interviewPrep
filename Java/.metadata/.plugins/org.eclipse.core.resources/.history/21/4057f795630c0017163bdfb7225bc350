import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public static class node implements Comparable<node>
    {
        int id;
        ArrayList<node> adjacentNodes;
        int shortestDistance;
        node(int id)
        {
            this.id = id;    
            this.adjacentNodes = new ArrayList<node>();
            this.shortestDistance = Integer.MAX_VALUE;
        }
        public void addNeighbor(node b)
        {
        	this.adjacentNodes.add(b);
        }
        @Override
        public int compareTo(node other)
        {
        	return Integer.compare(this.shortestDistance, other.shortestDistance);
        }
    }
    
    public static class Graph
    {
        Hashtable<Integer, node> hashtable;
        int size;
        int [][] lengthtable;
        int [] shortestDistanceTable;
        Graph(int numNodes)
        {
            this.hashtable = new Hashtable<Integer, node>();
            this.size = numNodes;
            this.shortestDistanceTable = new int[numNodes];
            lengthtable = new int[numNodes][numNodes];
            for(int i = 0; i < numNodes; i++)
            {
                node newNode = new node(i);
                this.hashtable.put(i, newNode);
                this.shortestDistanceTable[i] = Integer.MAX_VALUE;
            }
        }
        
        public void addEdge(int a, int b, int length)
        {
            node node_a = this.hashtable.get(a);
            node node_b = this.hashtable.get(b);
            node_a.addNeighbor(node_b);
            
            lengthtable[a][b] = length; 
        }
        
        
        public void shortestPath_dijkstra_withWeights(int s)
        {
            PriorityQueue<node> queue = new PriorityQueue<node> ();
            node a = this.hashtable.get(s);
            this.shortestDistanceTable[s] = 0;
            a.shortestDistance = 0;
            queue.add(a);
            while(!queue.isEmpty())
            {
                node dequeuedNode = queue.remove(); // Same as deletemin()
                for(node neighbor: dequeuedNode.adjacentNodes)
                {
                    int newLength = Integer.MAX_VALUE;
                    if(this.shortestDistanceTable[dequeuedNode.id] < Integer.MAX_VALUE)
                    {
                        newLength = this.shortestDistanceTable[dequeuedNode.id] + this.lengthtable[dequeuedNode.id][neighbor.id];
                    }
                    if(this.shortestDistanceTable[neighbor.id] > newLength)    
                    {
                        this.shortestDistanceTable[neighbor.id] = newLength;
                        neighbor.shortestDistance = newLength;
                        queue.add(neighbor);
                    }
                }
            }
            
            //print
            for(int i = 0; i < this.shortestDistanceTable.length; i++)
            {
            	if(this.shortestDistanceTable[i] == Integer.MAX_VALUE)
            		System.out.print(-1 + " ");
            	else if(this.shortestDistanceTable[i] != 0)
                    System.out.print(this.shortestDistanceTable[i]+" ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
    	//Test case 1: type input to the console.
    	//Input:
    /*
    	1
    	4 4
    	1 2 24
    	1 4 20
    	3 1 3
    	4 3 12
    	1
    	*/
    	
    	//Output: 24 3 15
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            Graph g = new Graph(n);
            for(int a1 = 0; a1 < m; a1++){
                int x = in.nextInt();
                int y = in.nextInt();
                int r = in.nextInt();
                if(g.lengthtable[x-1][y-1] == 0)
                {
                	g.addEdge(x-1, y-1, r);
                	g.addEdge(y-1, x-1, r);
            	}
                
                else if(r < g.lengthtable[x-1][y-1])
                {
                	g.lengthtable[x-1][y-1] = r;
                	g.lengthtable[y-1][x-1] = r;
                }
            }
            int s = in.nextInt();
            g.shortestPath_dijkstra_withWeights(s-1);
        }
    }
}
