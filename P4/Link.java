package P4;

import java.util.Scanner;

class File {
    String fname;
    int start;
    int size;
    int[] block;

    File() {
        block = new int[10];
    }
}

public class Link {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of files: ");
        int n = sc.nextInt();

        File[] f = new File[10];

        for (int i = 0; i < n; i++) {
            f[i] = new File();
            System.out.print("Enter file name: ");
            f[i].fname = sc.next();
            System.out.print("Enter starting block: ");
            f[i].start = sc.nextInt();
            f[i].block[0] = f[i].start;
            System.out.print("Enter no. of blocks: ");
            f[i].size = sc.nextInt();
            System.out.print("Enter block numbers: ");
            for (int j = 1; j <= f[i].size; j++) {
                f[i].block[j] = sc.nextInt();
            }
        }
        System.out.println("File\tstart\tsize\tblock");
        for (int i = 0; i < n; i++) {
            System.out.print(f[i].fname + "\t" + f[i].start + "\t" + f[i].size + "\t");
            for (int j = 1; j <= f[i].size - 1; j++) {
                System.out.print(f[i].block[j] + "--->");
            }
            System.out.println(f[i].block[f[i].size]);
        }
        sc.close();
    }
}