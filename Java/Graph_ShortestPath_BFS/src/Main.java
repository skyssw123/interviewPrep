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
        public int[] lengthTable;
        Graph(int size)
        {
            hashTable = new Hashtable<Integer, node> ();
            lengthTable = new int[size];
            for(int i = 0; i < size; i++)
            {
                lengthTable[i] = Integer.MAX_VALUE;
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
        public int getLength(int id_a)
        {
            return lengthTable[id_a-1];
        }
        public void setLength(int id_a, int distance)
        {
            lengthTable[id_a-1] = distance;
        }
        public void BFS_shortestPath(int s)
        {
            LinkedList<node> q = new LinkedList<node> ();
            node node_s = this.hashTable.get(s);
            setLength(node_s.id, 0);
            q.add(node_s);
            while(!q.isEmpty())
            {
                node dequeuedNode = q.removeFirst();
              //  dequeuedNode.state = State.VISITING;
                for(node neighbor : dequeuedNode.adjacentList)
                {
                    int currentLength = getLength(neighbor.id);
                    if(currentLength == Integer.MAX_VALUE)
                    {
                    	int newLength = getLength(dequeuedNode.id) + 6;
                        setLength(neighbor.id, newLength);
                    }
                   // if(neighbor.state == State.UNVISITED)
                }
               // dequeuedNode.state = State.VISITED;
            }
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        /*Input :
         * Test Case 1
2
4 2
1 2
1 3
1
3 1
2 3
2 
         *
 output:
6 6 -1
-1 6
         */
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
            }
            int startnode_id = scan.nextInt();
            if(!(startnode_id >= 1&&startnode_id<=graphsize))
                return;
            g.BFS_shortestPath(startnode_id);
            for(int length : g.lengthTable)
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
