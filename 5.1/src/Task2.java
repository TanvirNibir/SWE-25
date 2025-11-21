import java.util.Random;
import java.util.ArrayList;

class SumWorker extends Thread {
    private int[] arr;
    private int start, end;
    private long partialSum = 0;

    public SumWorker(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            partialSum += arr[i];
        }
    }

    public long getPartialSum() {
        return partialSum;
    }
}

public class Task2 {
    public static void main(String[] args) {
        int size = 100_000;
        int[] numbers = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            numbers[i] = rand.nextInt(100) + 1;
        }

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of processor cores: " + cores);

        int slice = size / cores;
        ArrayList<SumWorker> workers = new ArrayList<>();

        long startTime = System.nanoTime();

        for (int i = 0; i < cores; i++) {
            int start = i * slice;
            int end = (i == cores - 1) ? size : (i + 1) * slice;
            SumWorker worker = new SumWorker(numbers, start, end);
            workers.add(worker);
            worker.start();
        }

        long totalSum = 0;
        for (SumWorker w : workers) {
            try {
                w.join();
                totalSum += w.getPartialSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();
        long timeElapsed = (endTime - startTime) / 1_000_000;

        System.out.println("Total sum = " + totalSum);
        System.out.println("Time elapsed = " + timeElapsed + " ms");
    }
}