//Graph Implementation

import java.util.*;

public class GraphImp
{
  int v,i;
  LinkedList<Integer> adj[] ;
  
  GraphImp(int v)
  {
    this.v=v;
    adj=new LinkedList[v+1];
    for(i=0;i<v;i++)
        adj[i]=new LinkedList<>();
   }

  void addEdge(int src,int des)
  {
    adj[src].add(des);
  //  adj[des].add(src);
  }

 void disG()
 {
    for(i=0;i<v;i++)
    {
       System.out.print("Vertex : "+i+" is connected to : ");
        for(Integer x : adj[i])
             System.out.print(x+" , ");
        System.out.println();
     }
   }
  
  public static void main(String args[])
  {
     GraphImp g = new GraphImp(4);
     g.addEdge(0,1);
     g.addEdge(0,2);
     g.addEdge(1,0);
     g.addEdge(1,3);
     g.addEdge(2,1);
     g.addEdge(3,2);

     g.disG();
    }
}