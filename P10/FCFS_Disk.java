package P10;

import java.util.Scanner;

public class FCFS_Disk {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int[] t = new int[20];
        int n, tot = 0;
        int[] tohm = new int[20];
        float avhm;
        System.out.println("enter the no.of tracks");
        n = sc.nextInt();
        System.out.println("enter the tracks to be traversed");
        for (int i = 2; i < n + 2; i++) {
            t[i] = sc.nextInt();
        }
        for (int i = 1; i < n + 1; i++) {
            tohm[i] = Math.abs(t[i + 1] - t[i]);
            // if (tohm[i] < 0) {
            //     tohm[i] = tohm[i] * (-1);
            // }
        }
        for (int i = 1; i < n + 1; i++) {
            tot += tohm[i];
        }
        avhm = (float) tot / n;
        System.out.println("Tracks traversed\tDifference between tracks");
        for (int i = 1; i < n + 1; i++) {
            System.out.printf("%d\t\t\t%d\n", t[i], tohm[i]);
        }
        System.out.printf("\nAverage header movements:%f", avhm);
        sc.close();
    }
}
