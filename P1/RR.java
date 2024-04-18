package P1;

// Round Robin scheduling 

import java.util.Scanner;

public class RR {
    public static void main(String args[]) {
        int n, i, qt, count = 0, temp, sq = 0, bt[], wt[], tat[], rembt[];
        float awt = 0, atat = 0;
        bt = new int[10];
        wt = new int[10];
        tat = new int[10];
        rembt = new int[10];
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of processes(maximum 10) = ");
        n = sc.nextInt();
        System.out.print("Enter process burst time\n");
        for (i = 0; i < n; i++) {
            System.out.print("P" + i + " = ");
            bt[i] = sc.nextInt();
            rembt[i] = bt[i];
        }
        System.out.print("Enter the quantum time: ");
        qt = sc.nextInt();
        while (true) {
            for (i = 0, count = 0; i < n; i++) {
                temp = qt;
                if (rembt[i] == 0) { // Process completes
                    count++;
                    continue;
                }
                if (rembt[i] > qt)
                    rembt[i] = rembt[i] - qt; // when process BT is > QT it will again repeats to its completions
                else if (rembt[i] >= 0) {
                    temp = rembt[i]; // Pending processes re-join the ready queue and repeat the remaining execution
                    rembt[i] = 0;
                }
                sq = sq + temp;// Next starting time - previous ending time
                tat[i] = sq; // For a partcular process WT & BT will computed has TAT
            }
            if (n == count)
                break;
        }
        System.out.print("*********************************************************************************");
        System.out.print("\nProcess\t      Burst Time\t       Turnaround Time\t          Waiting Time\n");
        System.out.print("*********************************************************************************");
        for (i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
            awt = awt + wt[i];
            atat = atat + tat[i];
            System.out.print("\n " + (i + 1) + "\t\t " + bt[i] + "\t\t\t " + tat[i] + "\t\t\t " + wt[i] + "\n");
        }
        awt = awt / n;
        atat = atat / n;
        System.out.println("\nThe Average waiting Time = " + awt + "\n");
        System.out.println("The Average turnaround time = " + atat);
    }
}
