import java.util.*;

public class Main {
	enum State
	{
		Unvisited,
		Visiting,
		Visited
	};
	
	//Solution: Breadth-Depth Search. Time Complexity: O(n), Space Complexity: O(n)
	static boolean search(Graph g, Node start, Node end)
	{
		if(start == end)
			return true;
		
		for(Node node : g.getNodes())
		{
			node.state = State.Unvisited;
		}
		
		LinkedList<Node> q = new LinkedList<Node> ();
		start.state = State.Visiting;
		q.add(start);
		Node node;
		while(!q.isEmpty())
		{
			node = q.removeFirst(); //dequeue
			for(Node adjNode : node.getAdjacent())
			{
				if(adjNode.state == State.Unvisited)
				{
					if(adjNode == end)
						return true;
					else
					{
						q.add(adjNode);
						adjNode.state = State.Visiting;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Node a = new Node(0);
		Node b = new Node(1);
		Node c = new Node(2);
		Node d = new Node(3);
		Node e = new Node(4);
		Node f = new Node(5);
		a.setAdjacent( new Node[]{b, e, f} );
		b.setAdjacent( new Node[]{d, e} );
		c.setAdjacent( new Node[]{b} );
		d.setAdjacent( new Node[]{c, e} );
		e.setAdjacent( new Node[0] );
		f.setAdjacent( new Node[0] );
		
		Graph g = new Graph(new Node[] {a, b, c, d, e, f});
		
		System.out.println(search(g, a, f)); //Expected Output: True
		System.out.println(search(g, a, d)); //Expected Output: True
		System.out.println(search(g, c, e)); //Expected Output: True
		System.out.println(search(g, b, f)); //Expected Output: false
		System.out.println(search(g, c, a)); //Expected Output: false
	}
	
	
	
	
	//Class Graph
	public static class Graph
	{
		Node[] nodes;
		Graph(Node[] nodes)
		{
			this.nodes = nodes;
		}
		
		public Node[] getNodes()
		{
			return nodes;
		}
	}
	
	//Class Node
	public static class Node
	{
		public int data;
		public State state; 
		Node[] adjacent;
		Node(int data)
		{
			this.data = data;
			this.state = state;
			this.adjacent = adjacent;
		}
		
		public Node[] getAdjacent()
		{
			return adjacent;
		}
		
		public void setAdjacent(Node[] adjacent)
		{
			this.adjacent = adjacent;
		}
	}
}


