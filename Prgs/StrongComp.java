import java.util.*;

class StrongComp {
    private int V;
    private LinkedList<Integer> adj[];
    private int time; 

    StrongComp(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[], int[] startTime, int[] finishTime, ArrayList<Integer> component) {
        visited[v] = true;
        startTime[v] = time++; 
        component.add(v); 
        int n;

        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            n = i.next();
            if (!visited[n])
                DFSUtil(n, visited, startTime, finishTime, component);
        }
        finishTime[v] = time++; 
        System.out.println("Vertex " + v + " sT["+startTime[v]+"] , fT["+ finishTime[v]+"]");
    }

    StrongComp getTranspose() {
        StrongComp g = new StrongComp(V);
        for (int v = 0; v < V; v++) {
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                fillOrder(n, visited, stack);
        }
        stack.push(v);
    }

    int printSCCs() {
        Stack<Integer> stack = new Stack<Integer>();

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        int[] sTime = new int[V]; 
        int[] fTime = new int[V]; 

        time = 0; 

        for (int i = 0; i < V; i++)
            if (!visited[i])
                fillOrder(i, visited, stack);

        StrongComp gr = getTranspose();

        for (int i = 0; i < V; i++)
            visited[i] = false;

        int count = 0;
        while (!stack.empty()) {
            int v = stack.pop();
            ArrayList<Integer> component = new ArrayList<>(); 

            if (!visited[v]) {
                gr.DFSUtil(v, visited, sTime, fTime, component);
             
                for (int vertex : component) {
                    System.out.print(vertex + " ");
                }
                System.out.println();
                count++;
            }
        }
       
       return count;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        
        StrongComp g = new StrongComp(vertices);
        
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();
        
        System.out.println("Enter the edges  (src - dest): ");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            g.addEdge(source, destination);
        }
        
        System.out.println("Strongly connected components:   "+ g.printSCCs());
       
       
    }
}
