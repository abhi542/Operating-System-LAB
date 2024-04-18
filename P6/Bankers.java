package P6;

import java.util.Scanner;

public class Bankers {
   private int need[][], allocate[][], max[][], avail[][], np, nr;

   // int[][] alloc = { { 0, 1, 0 }, // P0 // Allocation Matrix
   //                   { 2, 0, 0 }, // P1
   //                   { 3, 0, 2 }, // P2
   //                   { 2, 1, 1 }, // P3
   //                   { 0, 0, 2 } };

   // np = 5; // Number of processes
   // nr = 3; // Number of resources

   //      int[][] max = { { 7, 5, 3 }, // P0 // MAX Matrix
   //                      { 3, 2, 2 }, // P1
   //                      { 9, 0, 2 }, // P2
   //                      { 2, 2, 2 }, // P3
   //                      { 4, 3, 3 } };

   //      int[] avail = { 3, 3, 2 }; // Available Resources

   private void input() {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter no. of processes and resources : ");
      np = sc.nextInt(); // no. of process
      nr = sc.nextInt(); // no. of resources
      need = new int[np][nr]; // initializing arrays
      max = new int[np][nr];
      allocate = new int[np][nr];
      avail = new int[1][nr];

      System.out.println("Enter allocation matrix -->");
      for (int i = 0; i < np; i++)
         for (int j = 0; j < nr; j++)
            allocate[i][j] = sc.nextInt(); // allocation matrix

      System.out.println("Enter max matrix -->");
      for (int i = 0; i < np; i++)
         for (int j = 0; j < nr; j++)
            max[i][j] = sc.nextInt(); // max matrix

      System.out.println("Enter available matrix -->");
      for (int j = 0; j < nr; j++)
         avail[0][j] = sc.nextInt(); // available matrix

      sc.close();
   }

   private int[][] calc_need() {
      for (int i = 0; i < np; i++)
         for (int j = 0; j < nr; j++) // calculating need matrix
            need[i][j] = max[i][j] - allocate[i][j];

      return need;
   }

   private boolean check(int i) {
      // checking if all resources for ith process can be allocated
      for (int j = 0; j < nr; j++)
         if (avail[0][j] < need[i][j]) // because allocation only when avail > need
            return false;

      return true;
   }

   public void isSafe() {
      input();
      calc_need();
      boolean done[] = new boolean[np];
      int j = 0;

      while (j < np) {                       // until all process allocated
         boolean allocated = false;
         for (int i = 0; i < np; i++)
            if (!done[i] && check(i)) {      // trying to allocate
               for (int k = 0; k < nr; k++)
                  avail[0][k] = avail[0][k] - need[i][k] + max[i][k];
               System.out.println("Allocated process : " + i);
               allocated = done[i] = true;
               j++;
            }
         if (!allocated)
            break; // if no allocation
      }
      if (j == np) // if all processes are allocated
         System.out.println("\nSafely allocated");
      else
         System.out.println("All processes can't be allocated safely");
   }

   public static void main(String[] args) {
      new Bankers().isSafe();
   }
}
