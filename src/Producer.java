public class Producer implements Runnable {
    private SharedQueue queue;
    public Producer(SharedQueue q) {
        queue = q;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                queue.put(i);
                System.out.println("PRODUCER: Sent value " + i);
            }
        } catch(InterruptedException e) {
            System.out.println("ERROR: Producer.java line 14");
        }
    }
}
