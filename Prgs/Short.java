import java.util.*;

class Edge
{ 
    int node, weight;

    Edge(int node, int weight)
   {
        this.node = node;
        this.weight = weight;
    }
}

public class Short
   {
    int distance[];
    boolean visited[];
    boolean not_visited[];
    int parent[];
    int no_of_ver;
    List<Edge>[] adj;

    Short(int n) 
   {
        this.no_of_ver = n;
        visited = new boolean[n + 1];
        not_visited = new boolean[n + 1];
        parent = new int[n + 1];
        distance = new int[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();
    }

    public void addEdge(int st, int en, int weight)
   {
        Edge ed = new Edge(en, weight);
        adj[st].add(ed);
    }

    public void SSP(int src) 
      {
        int current_node;
        for (int i = 1; i <= no_of_ver; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            not_visited[i] = true; 
        }

        distance[src] = 0;
        while (not_visitedCount(visited) != 0)
       { 
            current_node = min_not_visited(not_visited);
            not_visited[current_node] = false;
            visited[current_node] = true;
            adj_node(current_node);
        }
    }

    public int not_visitedCount(boolean visited[])
  {
        int count = 0, v;
        for (v = 1; v <= no_of_ver; v++) 
        {
            if (!visited[v])
                count++;
        }
        return count;
    }

    public int min_not_visited(boolean not_visited[]) 
       {
        int min = Integer.MAX_VALUE, node = 0, v;
        for (v = 1; v <= no_of_ver; v++) 
         {
            if (not_visited[v] && distance[v] < min) 
           {
                node = v;
                min = distance[v];
            }
        }
        return node;
    }

    public void adj_node(int current_node) 
    {
        int dt_node, dist, t_dist;
        for (Edge e : adj[current_node])
       {
            dt_node = e.node;
            if (!visited[dt_node]) 
            {
                dist = e.weight;
                t_dist = distance[current_node] + dist;
                if (t_dist < distance[dt_node]) 
                 {
                    distance[dt_node] = t_dist;
                    parent[dt_node] = current_node;
                }
                not_visited[dt_node] = true;
            }
        }
    }

    public void path(int dt_node)
      {
        if (parent[dt_node] == -1)
        {
            System.out.print(" " + dt_node);
            return;
        }

        path(parent[dt_node]);
        System.out.print(" -> " + dt_node);
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int src, no_of_ver = 0, i, j, weight, dt, ad_node;

        try {
            System.out.print("\nEnter no of vertex :   ");
            no_of_ver = inp.nextInt();
            Short algo = new Short(no_of_ver);
            for (i = 1; i <= no_of_ver; i++) {
                System.out.print("Enter no_adj node for [" + i + "] :");
                ad_node = inp.nextInt();
                for (j = 0; j < ad_node; j++) {
                    System.out.print("Enter node and path weight :  ");
                    dt = inp.nextInt();
                    weight = inp.nextInt();
                    algo.addEdge(i, dt, weight);
                }
            }

            System.out.print("Enter the Source :  ");
            src = inp.nextInt();

            algo.SSP(src);

            System.out.print("Shortest path from node " + src + " is : ");
            for (i = 1; i <= algo.no_of_ver; i++) 
             { 
                System.out.print("\nNode(" + i + ")  :");
                algo.path(i);
                System.out.print("      Dist [" + algo.distance[i] + "]");
            }
        } 
       catch (Exception e)
         {
            System.out.print("\n " + e.getMessage());
        }
    }
}

