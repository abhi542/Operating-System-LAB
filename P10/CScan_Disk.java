package P10;

import java.util.Scanner;
import java.util.Arrays;

public class CScan_Disk {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int[] queue = new int[20];
        int n, head, max, seek = 0, diff;
        float avg;
        System.out.println("Enter the max range of disk");
        max = sc.nextInt();
        System.out.println("Enter the initial head position");
        head = sc.nextInt();
        System.out.println("Enter the size of queue request");
        n = sc.nextInt();
        System.out.println("Enter the queue of disk positions to be read");
        int[] queue1 = new int[20];
        int[] queue2 = new int[20];
        int temp1 = 0, temp2 = 0;
        for (int i = 1; i <= n; i++) {
            int temp = sc.nextInt();
            if (temp >= head) {
                queue1[temp1] = temp;
                temp1++;
            } else {
                queue2[temp2] = temp;
                temp2++;
            }
        }
        Arrays.sort(queue1, 0, temp1);
        Arrays.sort(queue2, 0, temp2);
        int i = 1, j = 0;
        for (j = 0; j < temp1; i++, j++) {
            queue[i] = queue1[j];
        }
        queue[i] = max;
        queue[i + 1] = 0;
        for (i = temp1 + 3, j = 0; j < temp2; i++, j++) {
            queue[i] = queue2[j];
        }
        queue[0] = head;
        for (j = 0; j <= n + 1; j++) {
            diff = Math.abs(queue[j + 1] - queue[j]);
            seek += diff;
            System.out.println("Disk head moves from " + queue[j] + " to " + queue[j + 1] + " with seek " + diff);
        }
        System.out.println("Total seek time is " + seek);
        avg = (float) seek / n;
        System.out.println("Average seek time is " + avg);
        sc.close();
    }
}
