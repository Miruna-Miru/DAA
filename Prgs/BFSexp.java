import java.util.*;

class BFSexp {
    public static void main(String[] args) {
        GraphBFS g = new GraphBFS(7);

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

        System.out.print("\nBFS from node '0' is   :  ");
        g.BFS(0);
    }
}

class GraphBFS {
    int v;
    LinkedList<Integer> adj[];

    GraphBFS(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

     void BFS(int s)
    {
        
        boolean visited[] = new boolean[v];
 
 
        LinkedList<Integer> queue
            = new LinkedList<Integer>();
 
 
        visited[s] = true;
        queue.add(s);
 
        while (queue.size() != 0) {
 
           
            s = queue.poll();
            System.out.print(s + " ");
 
           
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }}

}
