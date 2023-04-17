public class Consumer implements Runnable {
    private SharedQueue queue;
    public Consumer(SharedQueue q) {
        queue = q;
    }
    @Override
    public void run() {
        try {
            while(true) {
                int value = queue.take();
                System.out.println("CONSUMER: got value " + value);
            }
        } catch(InterruptedException e) {
            System.out.println("ERROR: Consumer.java line 14");
        }
    }
}
