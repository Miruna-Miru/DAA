//Fractional Knapsack Problem - Greedy Method

import java.util.Scanner;

class Item
{
    int we,val;

    public Item(int w,int v)
    {
        this.we=w;
        this.val=v;
    }
}


public class fracKnapGreedy
{
    public static void main(String [] agrgs)
    {
        int n,i,j,tot,w,v,cur_w=0,cur_v;
        double r1,r2,frac,tot_val=0d;
        Item tem;
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter no of item :  ");
        n=inp.nextInt();
        Item[] arr= new Item[n];
        System.out.print("Enter capacity :  ");
        tot=inp.nextInt();
        for(i=0;i<n;i++)
        {
            System.out.print("Enter weigth and vaalue of item :  ");
            w=inp.nextInt();
            v=inp.nextInt();
            arr[i]=new Item(w,v);
        }

        for(i=0;i<n-1;i++)
        {
            for(j=1;j<n;j++)
            {
               r1=(double)arr[i].val/arr[i].we;
               r2=(double)arr[j].val/arr[j].we;
               if(r1<r2)
               {
                  tem=arr[i];
                  arr[i]=arr[j];
                  arr[j]=tem;
               }
            }
        }
         for(Item x : arr)
         {
            cur_v=x.val;
            cur_w=x.we;
            if(tot-cur_w>=0)
            {
                tot -= cur_w;
                tot_val+=cur_v;
                Sy
            }
            else
            {
               frac=(double)tot/cur_w;
               tot_val+=(cur_v*frac);
               tot-=(cur_w*frac);
               break;
            }
         }

         System.out.print("\nValue : "+tot_val+"\nCur_w : "+cur_w);
    }
}