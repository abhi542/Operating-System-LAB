package P4;

import java.util.Scanner;

public class Cont_Alloc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, i, j, x;
        int[] b = new int[20];
        int[] sb = new int[20];
        int[] t = new int[20];
        int[][] c = new int[20][20];

        System.out.println("Enter no.of files:");
        n = scanner.nextInt();

        for (i = 0; i < n; i++) {
            System.out.printf("Enter no. of blocks occupied by file %d: ", i + 1);
            b[i] = scanner.nextInt();
            System.out.printf("Enter the starting block of file %d: ", i + 1);
            sb[i] = scanner.nextInt();
            t[i] = sb[i];
            for (j = 0; j < b[i]; j++) {
                c[i][j] = sb[i]++;
            }
        }

        System.out.println("Filename\tStart block\tlength");
        for (i = 0; i < n; i++) {
            System.out.printf("%d\t %d \t%d\n", i + 1, t[i], b[i]);
        }

        System.out.print("Enter file name: ");
        x = scanner.nextInt();
        System.out.printf("File name is: %d\n", x);
        System.out.printf("length is: %d\n", b[x - 1]);
        System.out.print("blocks occupied: ");
        for (i = 0; i < b[x - 1]; i++) {
            System.out.printf("%4d", c[x - 1][i]);
        }
    }
}
