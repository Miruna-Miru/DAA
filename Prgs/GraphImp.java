//Graph Implementation using linked list

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
    if(adj[src].contains(des))
       System.out.print("Edgge already exists\n");
    else
    adj[src].add(des);
  //  adj[des].add(src);
  }

 void delVertex(int ve)
 {
    adj[ve]=new LinkedList<>();
    for(i=0;i<v;i++)
       adj[i].remove(Integer.valueOf(ve));
 }

void delEdge(int src,int de)
{
    adj[src].remove(Integer.valueOf(de));
 }

 void disG()
 {
    for(i=0;i<v;i++)
    {
      if(!adj[i].isEmpty())
      {
       System.out.print("Vertex  "+i+" is connected to : ");
        for(Integer x : adj[i])
             System.out.print(x+"   ");
        System.out.println();
      }
     }
   }
  
  public static void main(String args[])
  {
     GraphImp g = new GraphImp(4);
     Scanner inp = new Scanner(System.in);
     int x,y;

    
     g.addEdge(0,1);
     g.addEdge(0,2);
     g.addEdge(1,0);
     g.addEdge(1,3);
     g.addEdge(2,1);
     g.addEdge(3,2);
     g.addEdge(3,2);

     g.disG();

    System.out.print("Enter vertex to be deleted : ");
    x=inp.nextInt();
     g.delVertex(x);
    System.out.print("New Graph : \n");
     g.disG();
      System.out.print("Enter edge to be deleted  (src dest) : ");
      x=inp.nextInt();
      y=inp.nextInt();
      g.delEdge(x,y);
     System.out.print("New Graph : \n");
     g.disG();
    }
}
