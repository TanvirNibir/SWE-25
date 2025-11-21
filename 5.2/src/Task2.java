import java.util.ArrayList;
import java.util.List;

class ThreadSafeList<T> {
    private final List<T> list = new ArrayList<>();

    public void add(T element) {
        synchronized (list) {
            list.add(element);
            System.out.println(Thread.currentThread().getName() + " added: " + element);
        }
    }

    public int size() {
        synchronized (list) {
            return list.size();
        }
    }

    public T remove(int index) {
        synchronized (list) {
            if (index >= 0 && index < list.size()) {
                T removed = list.remove(index);
                System.out.println(Thread.currentThread().getName() + " removed: " + removed);
                return removed;
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to remove at index " + index);
                return null;
            }
        }
    }
}

class ListWorker implements Runnable {
    private final ThreadSafeList<String> safeList;

    public ListWorker(ThreadSafeList<String> safeList) {
        this.safeList = safeList;
    }

    @Override
    public void run() {
        safeList.add("Item-" + Thread.currentThread().getId());
        safeList.remove(0);
    }
}

public class Task2 {
    public static void main(String[] args) {
        ThreadSafeList<String> safeList = new ThreadSafeList<>();

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ListWorker(safeList), "Worker-" + (i + 1));
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final size of list: " + safeList.size());
    }
}