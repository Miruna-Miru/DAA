import java.util.*;

public class GraphMatrix {
    int v, i, j;
    int adjM[][];

    GraphMatrix(int v) {
        this.v = v;
        adjM = new int[v][v];
        for (i = 0; i < v; i++) {
            for (j = 0; j < v; j++)
                adjM[i][j] = 0;
        }
    }

    void addEdgeM(int src, int des) {
        if (adjM[src][des] == 0)
            adjM[src][des] = 1;
        else
            System.out.print("Edge already exists between (" + src + " and " + des + ")\n");
    }

    void delEdgeM(int src, int des) {
        adjM[src][des] = 0;
    }

    void disGrM() {
        for (i = 0; i < v; i++) {
            for (j = 0; j < v; j++)
                System.out.print("  " + adjM[i][j]);
            System.out.println();
        }
    }

    void addVertexM() {
        v++;
        int[][] newAdjM = new int[v][v];
        for (int k = 0; k < v - 1; k++) {
            System.arraycopy(adjM[k], 0, newAdjM[k], 0, v - 1);
        }
        adjM = newAdjM;
    }

    void delVertexM(int vertex) {
        if (vertex >= v || vertex < 0) {
            System.out.println("Vertex " + vertex + " does not exist");
            return;
        }
        for (int k = vertex; k < v - 1; k++) {
            System.arraycopy(adjM[k + 1], 0, adjM[k], 0, v);
        }
        for (int k = 0; k < v; k++) {
            adjM[k] = Arrays.copyOf(adjM[k], v - 1);
        }
        v--;
    }

    int calculateInDegree(int vertex) {
        int inDegree = 0;
        for (i = 0; i < v; i++) {
            if (adjM[i][vertex] == 1)
                inDegree++;
        }
        return inDegree;
    }

   int calculateOutDegree(int vertex) {
        int outDegree = 0;
        for (j = 0; j < v; j++) {
            if (adjM[vertex][j] == 1)
                outDegree++;
        }
        return outDegree;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int v = 4, n, x, y;
        // System.out.print("Enter no of vertex : ");
        // v=inp.nextInt();
        GraphMatrix gm = new GraphMatrix(v);
        gm.addEdgeM(0, 1);
        gm.addEdgeM(0, 2);
        gm.addEdgeM(1, 0);
        gm.addEdgeM(1, 3);
        gm.addEdgeM(2, 1);
        gm.addEdgeM(3, 2);

        gm.disGrM();

        System.out.print("Enter edge to be deleted (src des) :  ");
        x = inp.nextInt();
        y = inp.nextInt();
        gm.delEdgeM(x, y);
        System.out.print("New graph  :\n");
        gm.disGrM();

      

        System.out.print("Enter vertex to be added: ");
        x = inp.nextInt();
        gm.addVertexM();
        System.out.print("New graph  :\n");
        gm.disGrM();

         System.out.print("Enter edge to be added (src des) :  ");
        x = inp.nextInt();
        y = inp.nextInt();
        gm.addEdgeM(x, y);
        System.out.print("New graph  :\n");
        gm.disGrM();


        System.out.print("Enter vertex to be deleted: ");
        x = inp.nextInt();
        gm.delVertexM(x);
        System.out.print("New graph  :\n");
        gm.disGrM();
       int ve=2;
      System.out.println("In-degree of " + ve + ": " + gm.calculateInDegree(ve));
        System.out.println("Out-degree of  " + ve + ": " + gm.calculateOutDegree(ve));
    }
}
