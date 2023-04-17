import java.util.ArrayList;

public class Main {
    public static int QUEUE_SIZE = 100000;
    public static final int numOfConsumers = 2;

    public static void main(String[] args) {
        SharedQueue queue = new SharedQueue(QUEUE_SIZE);
        ArrayList<Thread> threads = new ArrayList<>();
        Runnable producer = new Producer(queue);
        Runnable consumer = new Consumer(queue);
        threads.add(new Thread(producer));
        for(int i = 0; i < numOfConsumers; i++) {
            threads.add(new Thread(consumer));
        }

        for (var thread : threads) {
            thread.start();
        }

        try {
            for (var thread : threads) {
                thread.join();
            }
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}