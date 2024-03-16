//Coin Change - Dynamic approach

import java.util.*;

class CoinDynamic 
{
    public static void main(String[] args)
     {
        Scanner inp = new Scanner(System.in);
        int n, tot, x, i, j;
        System.out.print("Enter total amount :  ");
        tot = inp.nextInt();
        System.out.print("Enter no of denomination :  ");
        n = inp.nextInt();
        LinkedList<Integer> den = new LinkedList<>();
        System.out.print("Enter denomination :  ");
        for (i = 0; i < n; i++)
         {
            x = inp.nextInt();
            den.add(x);
        }
        Collections.sort(den);
        int[] min = new int[tot + 1];
        List<Integer>[] min_den = new List[tot + 1];

        for (i = 1; i <= tot; i++)
            min[i] = Integer.MAX_VALUE;

        min[0] = 0;

        for (int c : den) 
        {
            for (j = c; j <= tot; j++) 
            {
                if (min[j - c] != Integer.MAX_VALUE && min[j - c] + 1 < min[j]) {
                    min[j] = min[j - c] + 1;
                    List<Integer> curDen = new ArrayList<>();
                    if (min_den[j - c] != null)
                        curDen.addAll(min_den[j - c]);
                    curDen.add(c);
                    min_den[j] = curDen;
                }
            }
        }

        System.out.println("Min change is :  " + min[tot]);
        System.out.print("Denominations used: ");
        for (int denom : min_den[tot]) 
            System.out.print(denom + " ");
      
        System.out.println();
    }
}


