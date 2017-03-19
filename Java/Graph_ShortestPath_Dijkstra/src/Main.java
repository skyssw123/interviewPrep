import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class Main {
    public static enum State
    {
        VISITING, VISITED, UNVISITED
    }
    public static class node
    {
        public ArrayList<node> adjacentList;
        public int id;
        public State state = State.UNVISITED;
        node(int idnum)
        {
            this.id = idnum;
            this.adjacentList = new ArrayList<node>();
        }
        public void addNeighbor(node neighbor)
        {
            this.adjacentList.add(neighbor);
        }
        public int hashcode()
        {
            return this.id;
        }
        public boolean equalTo(node neighbor)
        {
            return this == neighbor;
        }
    }
    
    public static class Graph
    {
        public Hashtable<Integer, node> hashTable;
        public int[] distanceTable;
        public int[][] lengthTable;
        Graph(int size)
        {
            hashTable = new Hashtable<Integer, node> ();
            distanceTable = new int[size];
            lengthTable = new int[size][size];
            
            
            for(int i = 0; i < size; i++)
            {
                distanceTable[i] = Integer.MAX_VALUE;
                lengthTable[i][i] = 0;
            }
            
            for(int i = 1; i <= size; i++)
            {
                node newnode = new node(i);
                hashTable.put(i, newnode);
            }
        }
        public void addNodes(int id_a, int id_b)
        {
            node a = hashTable.get(id_a);
            node b = hashTable.get(id_b);
            a.addNeighbor(b);
        }
        public int getDistance(int id_a)
        {
            return distanceTable[id_a-1];
        }
        public void setDistance(int id_a, int distance)
        {
            distanceTable[id_a-1] = distance;
        }
        public int getLength(int id_a, int id_b)
        {
        	return lengthTable[id_a - 1][id_b -1];
        }
        public void setLength(int id_a, int id_b, int value)
        {
        	lengthTable[id_a - 1][id_b -1] = value;
        }
        public void Dijkstra_shortestPath(int s)
        {
            LinkedList<node> q = new LinkedList<node> ();
            node node_s = this.hashTable.get(s);
            setDistance(node_s.id, 0);
            setLength(node_s.id, node_s.id, 0);
            for(Entry<Integer, node> set: this.hashTable.entrySet())
            {
            	q.add(set.getValue());
            }
            while(!q.isEmpty())
            {
                node dequeuedNode = deletemin(q);
              //  dequeuedNode.state = State.VISITING;
                for(node neighbor : dequeuedNode.adjacentList)
                {
                	//NOTE: Integer.MAX_VALUE + positive number returns negative number!!!
                	int newLength = Integer.MAX_VALUE;
                	if(getDistance(dequeuedNode.id) != Integer.MAX_VALUE)
                		newLength = getDistance(dequeuedNode.id) + getLength(dequeuedNode.id, neighbor.id);
                    int currentLength = getDistance(neighbor.id);
                    if(newLength < currentLength)
                    {
                        setDistance(neighbor.id, newLength);
                        
                    }
                   // if(neighbor.state == State.UNVISITED)
                }
               // dequeuedNode.state = State.VISITED;
            }
        }
        
        private node deletemin(LinkedList<node> q)
        {
        	int value = Integer.MAX_VALUE;
        	int index = 0;
        	int i = 0;
        	for(node a : q)
        	{
        		if(getDistance(a.id) < value)
        		{
        			value = getDistance(a.id);
        			index = i;
        		}
        		i++;
        	}
        	node result = q.remove(index);
        	return result;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(!(n >= 1 && n <= 10)) 
           return;
          
        for(int i = 0; i < n ; i++)
        {
            int graphsize = scan.nextInt();
            int num_edge = scan.nextInt();
            if(!(graphsize >= 2 && graphsize <= 1000 && num_edge >= 1 && num_edge <= (graphsize*(graphsize-1) / 2)))
                return;
            Graph g = new Graph(graphsize);
            for(int j = 0; j < num_edge; j++)
            {
                int node_a_id = scan.nextInt();
                int node_b_id = scan.nextInt();
                if(!((node_a_id >= 1)&&(node_a_id <= graphsize)&&(node_b_id >= 1)&&node_b_id <= graphsize))
                    return;
                g.addNodes(node_a_id, node_b_id);
                g.addNodes(node_b_id, node_a_id);
                g.setLength(node_a_id, node_b_id, 6);
                g.setLength(node_b_id, node_a_id, 6);
            }
            int startnode_id = scan.nextInt();
            if(!(startnode_id >= 1&&startnode_id<=graphsize))
                return;
            g.Dijkstra_shortestPath(startnode_id);
            for(int length : g.distanceTable)
            {
                if(length != 0)
                {
                    if(length == Integer.MAX_VALUE)
                        length = -1;
                    System.out.print(length + " ");
                }
            }
            
            System.out.print("\n");
        }
    }
}
