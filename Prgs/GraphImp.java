//Graph using linked list
import java.util.*;

public class GraphImp {
    int v, i;
    LinkedList<Integer> adj[];

    GraphImp(int v) {
        this.v = v;
        adj = new LinkedList[v + 1];
        for (i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int src, int des) {
        if (src < 0 || src >= v || des < 0 || des >= v) {
            System.out.println("Invalid vertex indices.");
            return;
        }
        
        if (adj[src].contains(des)) {
            System.out.println("Duplicate edge: Edge already exists between vertex " + src + " and " + des);
        } else {
            adj[src].add(des);
            // adj[des].add(src); // Uncomment if the graph is undirected
        }
    }

    void addVertex(int vertex) {
        if (vertex < 0 || vertex >= v) {
            System.out.println("Invalid vertex: Vertex must be within range 0 to " + (v - 1));
            return;
        }
        
        if (adj[vertex].isEmpty()) {
            adj[vertex] = new LinkedList<>();
        } else {
            System.out.println("Duplicate vertex: Vertex " + vertex + " already exists");
        }
    }

    void resizeGraph(int newSize) {
        if (newSize <= v) {
            System.out.println("New size should be greater than the current size.");
            return;
        }
        
        LinkedList<Integer>[] newAdj = new LinkedList[newSize];
        for (int i = 0; i < v; i++) {
            newAdj[i] = adj[i];
        }
        for (int i = v; i < newSize; i++) {
            newAdj[i] = new LinkedList<>();
        }
        v = newSize;
        adj = newAdj;
    }

    void delVertex(int ve) {
        adj[ve] = new LinkedList<>();
        for (i = 0; i < v; i++)
            adj[i].remove(Integer.valueOf(ve));
    }

    void delEdge(int src, int de) {
        adj[src].remove(Integer.valueOf(de));
    }

    void disG() {
        for (i = 0; i < v; i++) {
            if (!adj[i].isEmpty()) {
                System.out.print("Vertex " + i + " is connected to : ");
                for (Integer x : adj[i])
                    System.out.print(x + "   ");
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
       int n=4;
        GraphImp g = new GraphImp(n); 
        Scanner inp = new Scanner(System.in);
        int x, y;

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 1);
        g.addEdge(3, 2);

        g.disG();

        System.out.print("Enter vertex to be added : ");
        x = inp.nextInt();
        g.addVertex(x);
        System.out.print("New Graph : \n");
        g.disG();

        System.out.print("Enter edge to be added  (src dest) : ");
        x = inp.nextInt();
        y = inp.nextInt();
        g.addEdge(x, y);
        System.out.print("New Graph : \n");
        g.disG();
        
        System.out.print("Enter no of vertex to be added : ");
        int newSize = inp.nextInt();
        g.resizeGraph(newSize+n);
        System.out.print("Enter edge to be added  (src dest) : ");
        x = inp.nextInt();
        y = inp.nextInt();
        g.addEdge(x, y);
        System.out.print("New Graph : \n");
        g.disG();
    }
}
