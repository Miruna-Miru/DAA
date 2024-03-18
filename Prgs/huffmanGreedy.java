//Huffman Encoding - Greedy technique

import java.util.Scanner;
import java.util.PriorityQueue;

class Node
{
    int val;
    char c;
    Node left,right;

    public Node(int v,char c)
    {
        this.val=v;
        this.c=c;
        left=null;
        right=null;
    }
}


public class huffmanGreedy
{
    public static void main(String [] args)
    {
        Scanner inp = new Scanner(System.in);
        int n,i,j;
        System.out.print("Enter no of char :  ");
        n=inp.nextInt();

        char [] ch = new char[n];
        int [] freq = new int[n];
        
        System.out.print("Enter char and its frequncy :  ");
        for(i=0;i<n;i++)
        {
            ch[i]=inp.next().charAt(0);
            freq[i]=inp.nextInt();
        }
        for(i=0;i<n-1;i++)
        {
            for(j=i+1;j<n;j++)
            {
                if(freq[i]>freq[j])
                {
                    swap(i,j,ch);
                    swap(i,j,freq);
                }
            }
        }

        System.out.print("Sorted freq[] is : \n");
        for(i=0;i<n;i++)
           System.out.print(ch[i]+"-"+freq[i]+"  ");
        
        PriorityQueue<Node> pq = new PriorityQueue<>(n,(a,b)->a.val-b.val);

        for(i=0;i<n;i++)
        {
            Node nod = new Node(freq[i],ch[i]);
            pq.add(nod);
        }

        Node root = null;
        while(pq.size()>1)
        {
            Node x = pq.poll();
            Node y = pq.poll();
            Node sum = new Node(x.val+y.val,'-');
            sum.left=x;
            sum.right=y;
            root=sum;
            pq.add(sum);
        }

        System.out.print("Encoded char is : \n");
        dis(root,"");
    }

    public static void dis(Node root,String s)
    {
      if(root.right==null && root.left==null && Character.isLetter(root.c))
      {
        System.out.print(root.c+" : "+s+"\n");
        return;
      }

      dis(root.left,s+'O');
      dis(root.right,s+'1');
    }

    public static void swap(int a,int b,int ar[])
    {
        int tem=ar[a];
        ar[a]=ar[b];
        ar[b]=tem;
    }

    public static void swap(int a,int b,char ar[])
    {
        char tem=ar[a];
        ar[a]=ar[b];
        ar[b]=tem;
    }
}