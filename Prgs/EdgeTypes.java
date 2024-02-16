import java.util.*;

class EdgeTypes {
    private int V;
    private LinkedList<Integer> adj[];
    private boolean visited[];
    private int agearr[];

    EdgeTypes(int v) {
        V = v;
        adj = new LinkedList[v];
        visited = new boolean[v];
        agearr = new int[v];

        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
            visited[i] = false;
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void EdgeClass(int source, int age) {
        visited[source] = true;
        agearr[source] = age;

        for (int neighbor : adj[source]) {
            if (!visited[neighbor]) 
            {
                age -= 1;
                System.out.println("Tree edge - " + source + "->" + neighbor);
                EdgeClass(neighbor, age);
            } 
            else 
            {
                if (agearr[source] > agearr[neighbor]) 
                    System.out.println("Forward edge - " + source + "->" + neighbor);
                 else if (agearr[source] < agearr[neighbor]) 
                    System.out.println("Backward edge - " + source + "->" + neighbor);
                else 
                    System.out.println("Cross edge - " + source + "->" + neighbor);
                
            }
        }
    }

    public static void main(String args[]) {
        EdgeTypes g = new EdgeTypes(4);

        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
      
        System.out.println("Starting from vertex 1");
        g.EdgeClass(1, 0);
    }
}
