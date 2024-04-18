package P9;

import java.util.Scanner;

public class Paging_Tech {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ms, ps, nop, n, rempages, i, j, x, y, pa, offset;
        int[] s = new int[10];
        int[][] fno = new int[10][20];

        System.out.print("\nEnter the memory size -- ");
        ms = sc.nextInt();

        System.out.print("\nEnter the page size -- ");
        ps = sc.nextInt();

        nop = ms / ps;
        System.out.println("\nThe no. of pages available in memory are -- " + nop);

        System.out.print("\nEnter number of processes -- ");
        n = sc.nextInt();

        rempages = nop;

        for (i = 1; i <= n; i++) {
            System.out.printf("\nEnter no. of pages required for p[%d]-- ", i);
            s[i] = sc.nextInt();

            if (s[i] > rempages) {
                System.out.println("\nMemory is Full");
                break;
            }

            rempages = rempages - s[i];

            System.out.printf("\nEnter pagetable for p[%d] -- ", i);
            for (j = 0; j < s[i]; j++)
                fno[i][j] = sc.nextInt();
        }

        System.out.println("\nEnter Logical Address to find Physical Address ");
        System.out.println("\nEnter process no. and pagenumber and offset ");
        x = sc.nextInt();
        y = sc.nextInt();
        offset = sc.nextInt();

        if (x > n || y >= s[x] || offset >= ps)
            System.out.println("\nInvalid Process or Page Number or offset");
        else {
            pa = fno[x][y] * ps + offset;
            System.out.println("\nThe Physical Address is -- " + pa);
        }

        sc.close();
    }
}
