import java.util.*;



public class Project {
	private String name;
	private ArrayList<Project> adjacentProjects;
	public State visited = State.UNVISITED;
	
	public enum State {
	    UNVISITED, VISITED, VISITING
	}
	
	public Project(String name)
	{
		this.name = name;
		adjacentProjects = new ArrayList<Project>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<Project> getAdjacentProjects()
	{
		return adjacentProjects;
	}
	
	public void addAdjacentProject(Project project)
	{
		this.adjacentProjects.add(project);
	}
}