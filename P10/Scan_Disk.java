package P10;

import java.util.Scanner;
import java.util.Arrays;

public class Scan_Disk {
    static final int LOW = 0;
    static final int HIGH = 199;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] queue = new int[20];
        int head, max, q_size, sum;
        int dloc; // location of disk (head) arr

        System.out.print("Input no of disk locations: ");
        q_size = sc.nextInt();

        System.out.print("Enter head position: ");
        head = sc.nextInt();

        System.out.println("Input elements into disk queue");
        for (int i = 0; i < q_size; i++) {
            queue[i] = sc.nextInt();
        }

        queue[q_size] = head; // add RW head into queue
        q_size++;

        // sort the array
        Arrays.sort(queue, 0, q_size);

        max = queue[q_size - 1];

        // locate head in the queue
        dloc = -1;
        for (int i = 0; i < q_size; i++) {
            if (head == queue[i]) {
                dloc = i;
                break;
            }
        }

        if (Math.abs(head - LOW) <= Math.abs(head - HIGH)) {
            for (int j = dloc; j >= 0; j--) {
                System.out.print(queue[j] + " --> ");
            }
            for (int j = dloc + 1; j < q_size; j++) {
                System.out.print(queue[j] + " --> ");
            }
        } else {
            for (int j = dloc + 1; j < q_size; j++) {
                System.out.print(queue[j] + " --> ");
            }
            for (int j = dloc; j >= 0; j--) {
                System.out.print(queue[j] + " --> ");
            }
        }

        sum = head + max;
        System.out.println("\nmovement of total cylinders " + sum);
        sc.close();
    }
}
