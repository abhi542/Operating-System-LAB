package P1;

// FCFS scheduling 
import java.util.*;
import java.util.Arrays;

public class FCFS {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter no of process: ");
		int n = sc.nextInt();
		int pid[] = new int[n]; // process ids
		int at[] = new int[n]; // arrival times
		int bt[] = new int[n]; // burst or execution times
		int ct[] = new int[n]; // completion times
		int tat[] = new int[n]; // turn around times
		int wt[] = new int[n]; // waiting times
		// int temp;
		float avgwt = 0, avgta = 0;

		for (int i = 0; i < n; i++) {
			System.out.println("enter process" + (i + 1) + " arrival time and burst time ");
			at[i] = sc.nextInt();
			bt[i] = sc.nextInt();

		}

		// sorting according to arrival times
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - (i + 1); j++) {
				if (at[j] > at[j + 1]) // ascending order
				{
					// temp = at[j];
					// at[j] = at[j+1];
					// at[j+1] = temp;

					// temp = bt[j];
					// bt[j] = bt[j+1];
					// bt[j+1] = temp;

					// temp = pid[j];
					// pid[j] = pid[j+1];
					// pid[j+1] = temp;
					Arrays.sort(at);
					Arrays.sort(bt);
					Arrays.sort(pid);

				}
			}
		}
		// finding completion times
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				ct[i] = at[i] + bt[i];
			} else {
				if (at[i] > ct[i - 1])
					ct[i] = at[i] + bt[i];
				else
					ct[i] = ct[i - 1] + bt[i];
			}
			tat[i] = ct[i] - at[i];
			wt[i] = tat[i] - bt[i];
			avgwt += wt[i];
			avgta += tat[i];
		}

		System.out.println("\npid  arrival  brust  complete turn waiting");
		for (int i = 0; i < n; i++) {
			System.out.println(pid[i] + "  \t " + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
		}
		sc.close();
		System.out.println("\naverage waiting time: " + (avgwt / n));
		System.out.println("average turnaround time:" + (avgta / n));
	}
}
