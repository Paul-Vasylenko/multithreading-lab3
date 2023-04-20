import java.util.ArrayList;

public class Main {
    public static final int numOfConsumers = 2;
    public static final int numOfProducers = 2;

    public static void main(String[] args) {
        SharedBuffer queue = new SharedBuffer();
        ArrayList<Thread> threads = new ArrayList<>();
        Runnable producer = new Producer(queue);
        Runnable consumer = new Consumer(queue);
        for(int i = 0; i < numOfProducers; i++) {
            threads.add(new Thread(producer));
        }
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