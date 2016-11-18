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
		
		//Solution 1.
		//  1. Build graph that contains projects and link projects based on the dependencies.
		//  2. Find nodes that have no incoming edges.
		//  3. Add these nodes into array called, "buildOrder"
		//  4. Remove the outgoing nodes of these nodes.
		//  5. Repeat the process....
		
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		String e = "e";
		String f = "f";
		String[] projects = {a, b, c, d, e, f};
		
		String[][] dependencies = new String[5][2];
		dependencies[0][0] = a; //(a, d) : d is dependent on a
		dependencies[0][1] = d;
		dependencies[1][0] = f; //(f, b)
		dependencies[1][1] = b;
		dependencies[2][0] = b; //(b, d)
		dependencies[2][1] = d;
		dependencies[3][0] = f; //(f, a)
		dependencies[3][1] = a;
		dependencies[4][0] = d; //(d, c)
		dependencies[4][1] = c;
		
		//Expected Outcome : [f, e, a, b, d, c]
		Graph graph = buildGraph(projects, dependencies);
		Project[] result = orderProjects(graph.getNodes());
		for(int i = 0; i < result.length; i++)
		{
			System.out.println(result[i].getName());
		}
	}
	
	public static Project[] orderProjects(ArrayList<Project> projects)
	{
		Project[] orderedProjects = new Project[projects.size()];
		int offset = addNonDependent(orderedProjects, projects, 0);
		int index = 0;
		while(index < orderedProjects.length)
		{
			Project current = orderedProjects[index];
			if(current == null) //Circular dependencies 
				return null;      // Ex: if input is a<->b, both never get into the array 
								   //   in addNonDependent method
			ArrayList<Project> children = current.getChildren();
			for(Project child : children)
			{
				child.decrementDependencies();
			}
			
			offset = addNonDependent(orderedProjects, children, offset);
			index++;
		}
		
		return orderedProjects;
	}
	
	public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset)
	{
		for(Project project : projects)
		{
			if(project.getNumberOfDependencies() == 0)
			{
				order[offset] = project;
				offset++;
			}
		}
		return offset;
	}
	
	public static Graph buildGraph(String[] projects, String[][] dependencies)
	{
		Graph graph = new Graph();
		for(String project : projects)
		{
			graph.getOrCreateNode(project);
		}
		
		for(String[] dependency : dependencies)
		{
			graph.addEdge(dependency[0], dependency[1]);
		}
		return graph;
	}
}
