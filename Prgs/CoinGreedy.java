//Coin Change -Greedy method

import java.util.*;

class CoinGreedy
{
    public static void main(String args[])
    {
        Scanner inp = new Scanner(System.in);
        int n,tot,i,rem,x,t_coin=0;
        System.out.print("Enter total amount :  ");
        tot=inp.nextInt();
        rem=tot;
        System.out.print("Enter no of denomination :   ");
        n=inp.nextInt();

        LinkedList<Integer> den = new LinkedList<>();
        System.out.print("Enter denomination amount :  ");
        for(i=0;i<n;i++)
        {
           x=inp.nextInt();
           den.add(x);
        }
        Collections.reverse(den);
        for(int coin :den)
        {
            while(rem>=coin)
            {
                t_coin++;
                rem-=coin;
            }
        }

        if(rem==0)
           System.out.print("No of changes : "+t_coin);
        else
           System.out.print("Can't make changes with the denomination.");
    }
}