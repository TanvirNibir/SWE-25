public class Task1 {
    public static void main(String[] args) {
        int maxNumber = 20;

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= maxNumber; i += 2) {
                System.out.println("Odd Thread: " + i);
                try {
                    Thread.sleep(10); // small delay to mix up ordering
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= maxNumber; i += 2) {
                System.out.println("Even Thread: " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Printing complete.");
    }
}