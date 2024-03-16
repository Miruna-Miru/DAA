//Activity selection --Greedy Algorith

import java.util.Scanner;

class actSel {
    public static void main(String [] args) {
        Scanner inp = new Scanner(System.in);
        int n, i, j, took, co = 0;
        System.out.print("Enter no of Activities: ");
        n = inp.nextInt();
        int st[] = new int[n];
        int en[] = new int[n];
        for (i = 0; i < n; i++) {
            System.out.print("Enter start and end of Act[" + i + "]: ");
            st[i] = inp.nextInt();
            en[i] = inp.nextInt();
        }

        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                if (en[i] > en[j]) {
                    swap(st, i, j);
                    swap(en, i, j);
                }
            }
        }

        took = en[0];
        co = 1;
        System.out.print("Act: 0\n");

        for (i = 1; i < n; i++) {
            if (st[i] >= took) {
                co++;
                System.out.println("Act: " + i);
                took = en[i];
            }
        }

        System.out.println("Activities count: " + co);
    }

    static void swap(int ar[], int i, int j) {
        int tem = ar[i];
        ar[i] = ar[j];
        ar[j] = tem;
    }
}
