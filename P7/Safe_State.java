package P7;

//Safety State Algorithm - Program 7 
public class Safe_State {
    public static void main(String[] args) {
        int np, nr, i, j, k;
        np = 5; // Number of processes
        nr = 3; // Number of resources
        int[][] alloc = { { 0, 1, 0 }, // P0 // Allocation Matrix
                          { 2, 0, 0 }, // P1
                          { 3, 0, 2 }, // P2
                          { 2, 1, 1 }, // P3
                          { 0, 0, 2 } };

        int[][] max = { { 7, 5, 3 }, // P0 // MAX Matrix
                        { 3, 2, 2 }, // P1
                        { 9, 0, 2 }, // P2
                        { 2, 2, 2 }, // P3
                        { 4, 3, 3 } };

        int[] avail = { 3, 3, 2 }; // Available Resources

        int[] f = new int[np];
        int[] ans = new int[np];
        int ind = 0;
        for (k = 0; k < np; k++) {
            f[k] = 0;
        }
        int[][] need = new int[np][nr];
        for (i = 0; i < np; i++) {
            for (j = 0; j < nr; j++)
                need[i][j] = max[i][j] - alloc[i][j];
        }
        int y = 0;
        for (k = 0; k < 5; k++) {
            for (i = 0; i < np; i++) {
                if (f[i] == 0) {

                    int flag = 0;
                    for (j = 0; j < nr; j++) {
                        if (need[i][j] > avail[j]) {
                            flag = 1;
                            break;
                        }
                    }

                    if (flag == 0) {
                        ans[ind++] = i;
                        for (y = 0; y < nr; y++)
                            avail[y] += alloc[i][y];
                        f[i] = 1;
                    }
                }
            }
        }

        int flag = 1;

        // To check if sequence is safe or not
        for (i = 0; i < np; i++) {
            if (f[i] == 0) {
                flag = 0;
                System.out.println("The given sequence is not safe");
                break;
            }
        }

        if (flag == 1) {
            System.out.println("Following is the SAFE Sequence");
            for (i = 0; i < np - 1; i++)
                System.out.print(" P" + ans[i] + " ->");
            System.out.print(" P" + ans[np - 1]);
        }
    }
}
