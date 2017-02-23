import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* You are given a list of projects and a list of dependencies 
		 *  (which is a list of pairs of projects, where the second project is 
		 *   dependent on the first project). All of a project's dependencies must be built
		 *   before the project is. Find a build order that will allow the projects to be built.
		 *   If there is no valid build order, return an error.
		 */  
		
		//Solution 2. DFS_PostOrder (Topological Order)
		
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		String e = "e";
		String f = "f";
		String[] projects = {a, b, c, d, e, f};
		
		String[][] dependencies = new String[5][2];
		dependencies[0][0] = a; //(a, d) : d is dependent on a (a -> d)
		dependencies[0][1] = d;
		dependencies[1][0] = f; //(f, b)
		dependencies[1][1] = b;
		dependencies[2][0] = b; //(b, d)
		dependencies[2][1] = d;
		dependencies[3][0] = f; //(f, a)
		dependencies[3][1] = a;
		dependencies[4][0] = d; //(d, c)
		dependencies[4][1] = c;
		//dependencies[5][0] = c; //(d, c)
		//dependencies[5][1] = d;
		
		//Expected Outcome : [f, e, a, b, d, c]
		Graph graph = new Graph(projects, dependencies);
		Stack<Project> result = new Stack<Project> ();
		result = orderProjects(graph.getNodes(), result);
		
		if(result == null)
			System.out.println("This is an Acyclic Graph");
		
		else
		{
			while(!result.isEmpty())
			{
				System.out.println(result.pop().getName());
			}
		}
	}
	
	public static Stack<Project> orderProjects(ArrayList<Project> projects, Stack<Project> orderedProjects)
	{
		if(projects == null || projects.size() == 0)
			return null;
		for (Project project : projects)
		{
			if(project.visited == Project.State.VISITING)
				return null; // Cyclic Graph..
			else if(project.visited == Project.State.UNVISITED)
			{
				project.visited = Project.State.VISITING;
				orderProjects(project.getAdjacentProjects(), orderedProjects);
				//Post Order (We visit its adjacent projects first and update it after)
				orderedProjects.push(project);
				project.visited = Project.State.VISITED;
			}
		}
		return orderedProjects;
	}
}
