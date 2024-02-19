//Degrees of vertex

import java.util.*;

public class Degree
{
    int v,i;
    LinkedList<Integer> adj[] ;
 
    Degree(int v)
    {
        this.v=v;
         adj= new LinkedList[v+1];
         for(i=0;i<v;i++)
              adj[i]=new LinkedList<>();
     }

    int outDegree(int ver)
    {
         return adj[ver].size();
     }


    void addEdge(int src,int de)
    {
           adj[src].add(de);
     }

 void disG()
 {
    for(i=0;i<v;i++)
    {
       System.out.print("Vertex  "+i+" is connected to : ");
        for(Integer x : adj[i])
             System.out.print(x+"   ");
        System.out.println();
     }
   }


    int inDegree(int ver)
    {
         int c=0;
         for(i=0;i<v;i++)
        {
             if(i!=ver)
              {
                   for(int x : adj[i])
                    {
                           if(x==ver)
                                   c++;
                     }
                }
         }
      return c;
}
//ANOTHER METHOD
/*
    int calculateInDegree(int vertex) {
        int inDegree = 0;
        for (int i = 0; i < v; i++) {
            if (adjList[i].contains(vertex)) {
                inDegree++;
            }
        }
        return inDegree;
    }
*/
public static void main(String args[])
{
   Degree d = new Degree(4);
   int n;
     d.addEdge(0,1);
     d.addEdge(0,2);
     d.addEdge(1,0);
     d.addEdge(1,3);
     d.addEdge(2,1);
     d.addEdge(3,2);

    d.disG();
    Scanner inp = new Scanner(System.in);
    System.out.print("Enter vertex : ");
    n=inp.nextInt();
    System.out.print("Indegree : "+d.inDegree(n)+" , Outdegree : "+d.outDegree(n));
  }
}
   
    
        
