import java.util.*;
public class Graph {
	private ArrayList<Project> projects;
	private HashMap<String, Project> hashSetProjects = new HashMap<String, Project> ();
	
	public Graph(String[] projectNames, String[][] dependencies)
	{
		this.projects = new ArrayList<Project> ();
		for(String projectName: projectNames)
		{
			Project project = new Project(projectName);
			this.hashSetProjects.put(projectName, project);
			this.projects.add(project);
		}
		
		for(int i = 0; i < dependencies.length; i++)
		{
			Project upperProject = hashSetProjects.get(dependencies[i][0]);
			Project dependentProject = hashSetProjects.get(dependencies[i][1]);
			upperProject.addAdjacentProject(dependentProject);
		}
	}
	
	public ArrayList<Project> getNodes()
	{
		return projects;
	}
}
