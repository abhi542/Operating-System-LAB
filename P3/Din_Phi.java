package P3;

import java.util.concurrent.Semaphore;

class Philosopher implements Runnable {
    private int phil;
    private Semaphore room;
    private Semaphore[] chopstick;

    public Philosopher(int phil, Semaphore room, Semaphore[] chopstick) {
        this.phil = phil;
        this.room = room;
        this.chopstick = chopstick;
    }

    private void eat() {
        System.out.println("\nPhilosopher " + phil + " is eating");
    }

    @Override
    public void run() {
        try {
            room.acquire();
            System.out.println("\nPhilosopher " + phil + " has entered room");
            chopstick[phil].acquire();
            chopstick[(phil + 1) % 5].acquire();
            eat();
            // Thread.sleep(2000);
            System.out.println("\nPhilosopher " + phil + " has finished eating");
            chopstick[(phil + 1) % 5].release();
            chopstick[phil].release();
            room.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Din_Phi {
    public static void main(String[] args) {
        Semaphore room = new Semaphore(4);
        Semaphore[] chopstick = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            chopstick[i] = new Semaphore(1);
        }

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Philosopher(i, room, chopstick));
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}