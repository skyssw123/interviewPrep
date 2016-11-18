import java.util.*;

public class Graph {
	HashMap<String, Project> map = new HashMap<String, Project> ();
	ArrayList<Project> nodes = new ArrayList<Project> ();
	
	public Graph()
	{
	}
	
	public Project getOrCreateNode(String name)
	{
		if(!map.containsKey(name))
		{
			Project newProject = new Project(name);
			nodes.add(newProject);
			map.put(name, newProject);
		}
		return map.get(name);
	}
	
	public void addEdge(String a, String b)
	{
		Project projectA = getOrCreateNode(a);
		Project projectB = getOrCreateNode(b);
		projectA.addChildren(projectB);
	}
	
	public ArrayList<Project> getNodes()
	{
		return nodes;
	}
}
