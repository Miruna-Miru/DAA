
import java.io.*;
import java.util.*;


class DFS {
	private int V;


	private LinkedList<Integer> adj[];

    DFS(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	
	void addEdge(int v, int w)
	{
		adj[v].add(w);
	}


	void DFSUtil(int v, boolean visited[])
	{

		visited[v] = true;
		System.out.print(v + " ");


		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}


	void DFSs(int v)
	{
	
		boolean visited[] = new boolean[V];

		DFSUtil(v, visited);
	}


	public static void main(String args[])
	{
		DFS g = new DFS(7);
	    g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(1, 6);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 0);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 2);
        g.addEdge(4, 3);
        g.addEdge(4, 6);
        g.addEdge(5, 1);
        g.addEdge(5, 2);
        g.addEdge(6, 1);
        g.addEdge(6, 2);

	

		System.out.println(
			"Following is Depth First Traversal "
			+ "(starting from vertex 0)");

		g.DFSs(0);
	}
}