import java.util.*;
public class Project {
	private String name = null;
	HashMap<String, Project> mapChildren = new HashMap<String, Project> ();
	ArrayList<Project> children = new ArrayList<Project> (); // Children are incoming nodes 
															//(nodes that are dependent on the project)
	private int numOfDependencies = 0;
	
	public Project(String name)
	{
		this.name = name;
	}
	
	public ArrayList<Project> getChildren()
	{
		return this.children;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getNumberOfDependencies()
	{
		return this.numOfDependencies;
	}
	
	public void addChildren(Project neighbor)
	{
		if(!this.mapChildren.containsKey(neighbor.name))
		{
			neighbor.incrementDependencies();
			this.mapChildren.put(neighbor.getName(), neighbor);
			this.children.add(neighbor);
		}
	}
	
	public void incrementDependencies()
	{
		this.numOfDependencies++;
	}
	
	public void decrementDependencies()
	{
		this.numOfDependencies--;
	}
}
