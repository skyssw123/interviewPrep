import java.io.*;
import java.io.BufferedReader;
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

    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
		int test;// = sc.nextInt();
		int n, m;
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		test = Integer.parseInt(br.readLine());
		String split[];
		for(int i=0; i<test; i++)
		{
			split = br.readLine().split(" ");
			n = Integer.parseInt(split[0]);
			m = Integer.parseInt(split[1]);
			
			Graph g = new Graph(n);
			
			for(int j=0; j<m; j++)
			{
				split = br.readLine().split(" ");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                int r = Integer.parseInt(split[2]);
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
			
			g.shortestPath_dijkstra_withWeights(Integer.parseInt(br.readLine()) - 1);
		}
    }
}

