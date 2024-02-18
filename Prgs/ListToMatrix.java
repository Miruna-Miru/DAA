//List to Matrix

import java.util.*;
public class ListToMatrix
{
     int v,i;
  LinkedList<Integer> adj[] ;
  
   ListToMatrix(int v)
  {
    this.v=v;
    adj=new LinkedList[v+1];
    for(i=0;i<v;i++)
        adj[i]=new LinkedList<>();
   }

  void addEdge(int src,int des)
  {
    adj[src].add(des);
  }


   void disG()
 {
    for(int i=0;i<v;i++)
    {
       System.out.print("Vertex  "+i+" is connected to : ");
        for(Integer x : adj[i])
             System.out.print(x+"   ");
        System.out.println();
     }
   }


  void changeLM()
 {
    int matrix[][] = new int[v][v];
    int i;
    for( i=0;i<v;i++)
    {
      for(int  j : adj[i])
            matrix[i][j]=1;
    }

  System.out.print("Matrix representation is : \n");
  for(i=0;i<v;i++)
  {
     for(int j=0;j<v;j++)
        System.out.print(matrix[i][j]+" ");
     System.out.println();
 }
}


public static void main(String args[])
{
     ListToMatrix  g = new ListToMatrix(4);
     g.addEdge(0,1);
     g.addEdge(0,2);
     g.addEdge(1,0);
     g.addEdge(1,3);
     g.addEdge(2,1);
     g.addEdge(3,2);
    
    System.out.print("Graph is: ");
    g.disG();

   g.changeLM();
}
}